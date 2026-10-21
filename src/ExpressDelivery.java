public class ExpressDelivery implements DeliveryMethod {
    public double cost(Order order) {return 1000;}
    public int days(Order order) {return 1;}
    public boolean courierNeeded() {return true;}
}