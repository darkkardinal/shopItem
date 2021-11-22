package shopitem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import shopitem.Item;

public class ShopItemRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> p = new ArrayList<Item>() {
            {
                add(new Item(1, 9.75f, "T-Shirt"));
                add(new Item(2, 13.99f, "Dress"));
                add(new Item(3, 45.95f, "Jeans"));
                add(new Item(4, 60.9f, "Gloves"));
                add(new Item(5, 31f, "Shirt"));
                add(new Item(6, 14.9f, "Tie"));
            }

        };

        ArrayList<Cards> c = new ArrayList<Cards>() {
            {
                add(new Cards(1234, 5));   // %5 скидка

            }

        };

        float total = 0;

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`: ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");

            String[] item;
            String name;
            int cnt;
            float price;
            float sum;
            int id = 0;
            int idCard = 0;
            int discount;
            System.out.format("%3s|%30s|%10s|%10s|%n", "QTY", "Description", "Price", "Total");
            for (int i = 0; i < parts.length; i++) {
                item = parts[i].split("-");
                cnt = 0;
                price = 0;
                sum = 0;
                name = "";
                discount = 0;
                for (int j = 0; j < item.length; j++) {

                    if (j == 0) {
                        if (item[j].toUpperCase() != "CARD") {
                            id = (Integer) Integer.parseInt(item[j]) - 1;
                            name = p.get(id).getName();
                            price = p.get(id).getPrice();

                        } else {
                            idCard = (Integer) Integer.parseInt(item[j]) - 1;
                        }

                    }
                    if (j == 1) {
                        if (idCard != 0) {
                            cnt = (Integer) Integer.parseInt(item[j]);
                            sum = p.get(id).getSum(cnt, price);
                        } else {
discount = 
                        }

                    }

                    total += sum;

                }
                System.out.format("%3s|%30s|%10s|%10s|%n", cnt, name, price, String.format("%.2f", sum));

            }
            System.out.format("%n%3s%51s%n", "Total", String.format("%.2f", total));

        }
    }
}
