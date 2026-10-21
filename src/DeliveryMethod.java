public interface DeliveryMethod {
    double cost(Order order);
    int days(Order order);
    boolean courierNeeded();
}