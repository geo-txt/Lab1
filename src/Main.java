public class Client {
    private String address;
    private String name;
    private String phoneNumber;
}

public class Courier {
    private String name;
    private String transport;
}

public class Position {
    private String name;
    private int amount;
    private double price;
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
}

void main() {
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }
}
