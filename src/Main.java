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

}

public class StandardDelivery implements DeliveryMethod {

}

public class ExpressDelivery implements DeliveryMethod {

}

public class PickupDelivery implements DeliveryMethod {

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
    private double price;
    private int deliveryTime;

    public void setClient(Client client) {this.client = client;}
    public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {this.deliveryMethod = deliveryMethod;}
    public void setCourier(Courier courier) {this.courier = courier;}
    public void setDeliveryTime(int deliveryTime) {this.deliveryTime = deliveryTime;}
    public void setPrice(double price) {this.price = price;}
    public void setStatus(OrderStatus status) {this.status = status;}

    public int getOrderNumber() {return this.orderNumber;}
    public OrderStatus getStatus() {return this.status;}
    private double getPrice() {return this.price;}
    private int getDeliveryTime() {return this.deliveryTime;}
}

void main() {
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }
}
