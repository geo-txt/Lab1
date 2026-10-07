import java.util.Scanner;

public class Client {
    private String address;
    private String name;
    private String phoneNumber;

    public Client(String address, String name, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getClientName() {return this.name;}
    public String getClientAddress() {return this.address;}
    public String getClientPhoneNumber() {return this.phoneNumber;}
}

public class Courier {
    private String name;
    private String transport;

    public Courier(String name, String transport) {
        this.name = name;
        this.transport = transport;
    }

    public String getCourierName() {return this.name;}
    public String getCourierTransport() {return this.transport;}
}

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

public interface DeliveryMethod {
    double cost(Order order);
    int days(Order order);
    boolean courierNeeded();
}

public class NoDelivery implements DeliveryMethod {
    public double cost(Order order) {return 0;}
    public int days(Order order) {return 4;}
    public boolean courierNeeded() {return false;}
}

public class CourierDelivery implements DeliveryMethod {
    public double cost(Order order) {return 500;}
    public int days(Order order) {return 3;}
    public boolean courierNeeded() {return true;}
}

public class ExpressDelivery implements DeliveryMethod {
    public double cost(Order order) {return 1000;}
    public int days(Order order) {return 1;}
    public boolean courierNeeded() {return true;}
}

public enum OrderStatus {
    New, Processing, Delivering, Delivered, Cancelled
}

public class Order {
    private int orderNumber;
    private OrderStatus status;
    private Client client;
    private List<Position> positions = new ArrayList<>();
    private DeliveryMethod deliveryMethod;
    private Courier courier;
    private double cost;
    private int deliveryTime;

    public void setClient(Client client) {this.client = client;}
    public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {this.deliveryMethod = deliveryMethod;}
    public void setCourier(Courier courier) {this.courier = courier;}
    public void setDeliveryTime(int deliveryTime) {this.deliveryTime = deliveryTime;}
    public void setCost(double cost) {this.cost = cost;}
    public void setStatus(OrderStatus status) {this.status = status;}
    public void addPosition(Position position) {this.positions.add(position);}

    public int getOrderNumber() {return this.orderNumber;}
    public OrderStatus getStatus() {return this.status;}
    public double getCost() {return this.cost;}
    public int getDeliveryTime() {return this.deliveryTime;}
    public List<Position> getPositions() {return this.positions;}

    public double calculateCost() {
        double s = 0;
        for (Position p : positions) {s += p.getAmount() * p.getPrice();}
        this.setCost(this.getCost() + s);
        return s;
    }

    public void applyMethod(DeliveryMethod method) {
        this.setDeliveryMethod(method);
        this.setDeliveryTime(method.days(this));
        this.setCost(this.getCost() + method.cost(this));
    }
}

void main() {
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }
}
