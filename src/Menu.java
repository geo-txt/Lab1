import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Order> orderList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addOrder(Order order) {this.orderList.add(order);}
    public List<Order> getOrderList() {return this.orderList;}

    private int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Это не число, попробуйте ещё раз. ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Это не число, попробуйте ещё раз: ");
            }
        }
    }

    public Order findOrder() {
        Order foundOrder = null;
        if (orderList.isEmpty()) {
            System.out.println("Заказов пока нет.");
            return null;
        }

        boolean run1 = true;
        while (run1) {
            int orderNum = readInt();
            for (Order order : orderList) {
                if (order.getOrderNumber() == orderNum) {
                    foundOrder = order;
                    run1 = false;
                    break;
                }
            }
            if (foundOrder == null) {
                System.out.println("Заказ не найден, повторите ввод.");
            }
        }
        return foundOrder;
    }

    public void menuStart() {
        boolean run = true;
        int orderCount = 1;

        while (run) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать заказ");
            System.out.println("2. Показать заказы");
            System.out.println("3. Выбрать способ доставки");
            System.out.println("4. Назначить курьера");
            System.out.println("5. Изменить статус заказа");
            System.out.println("6. Выход");
            int choice1 = readInt();
            switch(choice1) {
                case 1:
                    Order new_order = new Order(orderCount);
                    System.out.print("Создание заказа. Введите клиента: ");
                    String name = scanner.nextLine();

                    System.out.print("Введите адрес: ");
                    String address = scanner.nextLine();

                    System.out.print("Введите телефон: ");
                    String phone = scanner.nextLine();

                    Client new_client = new Client(name, address, phone);
                    new_order.setClient(new_client);

                    System.out.println("Добавление товаров");

                    boolean run2 = true;
                    while (run2) {
                        System.out.print("Добавить товар? 1 - Да. 2 - Нет ");
                        int choice2 = readInt();
                        switch (choice2) {
                            case 1:
                                System.out.print("Название товара: ");
                                String productName = scanner.nextLine();

                                System.out.print("Количество: ");
                                int amount = readInt();

                                System.out.print("Цена за штуку: ");
                                double price = readDouble();

                                Position position = new Position(productName, amount, price);
                                new_order.addPosition(position);

                                System.out.println("Товар добавлен.");
                                break;

                            case 2:
                                run2 = false;
                                break;

                            default:
                                System.out.println("Некорректный ввод");
                        }
                    }

                    addOrder(new_order);
                    System.out.print("Заказ создан");
                    orderCount += 1;
                    break;

                case 2:
                    System.out.println("Вывод списка заказов: ");
                    if (orderList.isEmpty()) {
                        System.out.println("Заказов пока нет.");
                    }
                    else {
                        for (Order order : orderList) {
                            System.out.println("Заказ №" + order.getOrderNumber() + ". Клиент: " + order.getClient().getClientName() + ". Позиций: " + order.getPositions().size() + ". Стоимость: " + order.calculateTotalCost() + " руб. Статус: " + order.getStatus());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Выбор способа доставки:");
                    System.out.println("Введите номер заказа");
                    Order foundOrder = findOrder();

                    System.out.println("Выберите способ доставки:");
                    System.out.println("1. Самовывоз");
                    System.out.println("2. Доставка крьером");
                    System.out.println("3. Экспресс-доставка");
                    DeliveryMethod method = null;
                    boolean run1 = true;
                    while (run1) {
                        int type = readInt();
                        switch (type) {
                            case 1:
                                method = new NoDelivery();
                                run1 = false;
                                break;
                            case 2:
                                method = new CourierDelivery();
                                run1 = false;
                                break;
                            case 3:
                                method = new ExpressDelivery();
                                run1 = false;
                                break;
                            default:
                                System.out.println("Неверный тип доставки.");
                                break;
                        }
                    }

                    foundOrder.applyMethod(method);
                    System.out.println("Способ доставки выбран. Срок: " + foundOrder.getDeliveryTime() + " дн.");
                    System.out.println("Стоимость заказа с доставкой: " + foundOrder.calculateTotalCost() + " руб.");
                    break;

                case 4:
                    System.out.println("Назначить курьера");
                    break;

                case 5:
                    System.out.println("Изменить статус заказа");
                    break;

                case 6:
                    System.out.println("Завершение работы");
                    run = false;
                    break;

                default:
                    System.out.println("Некорректный ввод");
            }
        }
    }
}