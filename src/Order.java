import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private OrderStatus status;
    private Client client;
    private List<Position> positions = new ArrayList<>();
    private DeliveryMethod deliveryMethod;
    private Courier courier;
    private int deliveryTime;

    public void setClient(Client client) {this.client = client;}
    public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {this.deliveryMethod = deliveryMethod;}
    public void setCourier(Courier courier) {this.courier = courier;}
    public void setDeliveryTime(int deliveryTime) {this.deliveryTime = deliveryTime;}
    public void setStatus(OrderStatus status) {this.status = status;}
    public void addPosition(Position position) {this.positions.add(position);}

    public int getOrderNumber() {return this.orderNumber;}
    public OrderStatus getStatus() {return this.status;}
    public int getDeliveryTime() {return this.deliveryTime;}
    public DeliveryMethod getDeliveryMethod() {return deliveryMethod;}
    public List<Position> getPositions() {return this.positions;}
    public Client getClient() {return this.client;}
    public Courier getCourier() {return courier;}

    public Order(int number) {
        setOrderNumber(number);
        setStatus(OrderStatus.New);
    }

    public double calculateItemsCost() {
        double sum = 0;
        for (Position p : positions) {
            sum += p.getAmount() * p.getPrice();
        }
        return sum;
    }

    public double calculateTotalCost() {
        double items = calculateItemsCost();
        if (deliveryMethod == null) {
            return items;
        }
        return items + deliveryMethod.cost(this);
    }

    public void applyMethod(DeliveryMethod method) {
        this.setDeliveryMethod(method);
        this.setDeliveryTime(method.days(this));
    }

    public void assignCourier(Courier courier) {
        if (getDeliveryMethod() == null)
            throw new IllegalStateException("Сначала выберите способ доставки");
        if (!getDeliveryMethod().courierNeeded())
            throw new IllegalStateException("Этот заказ не требует курьера");
        if (getCourier() != null)
            throw new IllegalStateException("Курьер уже назначен");

        this.courier = courier;
        courier.busy();
    }

    public void releaseCourier() {
        if (courier != null) {
            courier.available();   // курьер снова свободен
            courier = null;        // отвязываем его от заказа
        }
    }

    public void nextStatus() {
        switch (status) {
            case New:
                status = OrderStatus.Processing;
                break;
            case Processing:
                status = OrderStatus.Delivering;
                break;
            case Delivering:
                status = OrderStatus.Delivered;
                releaseCourier();
                break;
            case Delivered:
                throw new IllegalStateException("Заказ уже доставлен");
            case Cancelled:
                throw new IllegalStateException("Заказ отменён, статус не меняется");
        }
    }

    public void cancelOrder() {
        switch (status) {
            case Delivering:
                throw new IllegalStateException("Заказ уже доставляется.");
            case Delivered:
                throw new IllegalStateException("Заказ уже доставлен.");
            case Cancelled:
                throw new IllegalStateException("Заказ уже отменён.");
            default:
                status = OrderStatus.Cancelled;
                releaseCourier();
                break;
        }
    }
}