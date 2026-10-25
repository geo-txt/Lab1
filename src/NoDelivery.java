public class NoDelivery implements DeliveryMethod {
    public double cost(Order order) {return 0;}
    public int days(Order order) {return 0;}
    public boolean courierNeeded() {return false;}
}