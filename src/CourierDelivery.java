public class CourierDelivery implements DeliveryMethod {
    public double cost(Order order) {return 500;}
    public int days(Order order) {return 3;}
    public boolean courierNeeded() {return true;}
}