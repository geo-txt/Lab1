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
            int choice1 = scanner.nextInt();
            switch(choice1) {
                case 1:
                    scanner.nextLine();
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
                    System.out.println("Выбрать способ доставки");
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