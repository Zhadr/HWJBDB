package my.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBBook dbBook= new DBBook();
        dbBook.connect();

        ArrayList<Item> item = dbBook.getAllItems();
        for (Item i:item){
            System.out.println(i.toString());
        }

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("PRESS [1] TO ADD ITEMS");
            System.out.println("PRESS [2] TO LIST ITEMS");
            System.out.println("PRESS [3] TO DELETE ITEMS");
            System.out.println("PRESS [0] TO EXIT");
            String choice= in.next();
            if (choice.equals("1")){
                System.out.println("Insert name:");
                String name = in.next();
                System.out.println("Insert price:");
                double price = in.nextDouble();
                Item i = new Item(null, name, price);
                dbBook.addItem(i);
                //items.add(new Item(null, name, price));
            }
            else if (choice.equals("2")){
                for (Item b: item){
                    System.out.println(b);
                }
//                for (int i=0; i<item.size(); i++){
//                    System.out.println(item.get(i).getName()+ " "+ item.get(i).getPrice());
//                }
            }else if (choice.equals("3")){
                System.out.println("Insert ID:");
                Long l= in.nextLong();
                dbBook.deleteItem(l);
            }else if (choice.equals("0")){
                dbBook.disconnect();
                break;
            }

        }



    }
}
