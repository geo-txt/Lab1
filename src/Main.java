import java.util.Scanner;

void main() {
    Menu menu = new Menu();

    System.out.println("Симулятор службы доставки");
    menu.menuStart();

    for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }
}