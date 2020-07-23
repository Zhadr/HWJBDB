package my.project;

import java.sql.*;
import java.util.ArrayList;

public class DBBook {
    private static Connection connection;
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/item?useUnicode=true&serverTimezone=UTC", "root", ""
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void addItem (Item item){
        try{
            PreparedStatement statement = connection.prepareStatement(" "+
                    "INSERT INTO item(id, name, price)"+ "VALUES(NULL, ?, ?)");
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            int rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
    public ArrayList<Item> getAllItems(){
        ArrayList<Item> itemsList = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){ //есть ли дальше строка или нет
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                itemsList.add(new Item(id, name, price));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return itemsList;

    }

    public void deleteItem(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM item WHERE id = ?"
            );
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
