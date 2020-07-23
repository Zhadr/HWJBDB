package my.project;

public class Item {
    private Long id;
    private String name;
    double price;

    public Item(){

    }

    public Item(Long id, String name, double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
