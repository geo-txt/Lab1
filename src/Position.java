public class Position {
    private String name;
    private int amount;
    private double price;

    public Position(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getPositionName() {return this.name;}
    public int getAmount() {return this.amount;}
    public double getPrice() {return this.price;}
}