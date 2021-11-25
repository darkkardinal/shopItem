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
                add(new Cards(1, 100));   // %5 скидка


            }

        };

        float total = 0;
        float discount = 0;
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


            System.out.format("%3s|%30s|%10s|%10s|%n", "QTY", "Description", "Price", "Total");
            for (int i = 0; i < parts.length; i++) {
                int id = 0;
                int idCard = 0;
                item = parts[i].split("-");
                cnt = 0;
                price = 0;
                sum = 0;
                name = "";
                discount = 0;
                for (int j = 0; j < item.length; j++) {

                    if (j == 0) {
                        if (item[j].equalsIgnoreCase(new String("card"))) {

                            for (int m = 0; m < c.size(); m++) {
                                if (c.get(m).getCardId() == Integer.parseInt(item[j + 1])) {
                                    idCard = c.get(m).getCardId();
                                    discount = c.get(m).getCardPercent();
                                    break;
                                }
                            }


                        } else {
                            for (int m = 0; m < p.size(); m++) {
                                if (p.get(m).getItemId() == Integer.parseInt(item[j])) {
                                    id = p.get(m).getItemId();
                                    name = p.get(m).getName();
                                    price = p.get(m).getPrice();
                                    break;

                                }

                            }


                        }

                    }
                    if (j == 1) {
                        if (idCard == 0) {
                            cnt = (Integer) Integer.parseInt(item[j]);
                            sum = p.get(id).getSum(cnt, price);
                        }

                    }

                    total += sum;

                }

                if (idCard == 0) {
                    if (id != 0) {
                        System.out.format("%3s|%30s|%10s|%10s|%n", cnt, name, price, String.format("%.2f", sum));
                    }
                }


            }
            if (discount != 0) {


                System.out.format("%n%3s%48s%n", "Discount ", String.format("%.2f", (total * discount / 100)));
                total = total - (total * discount / 100);

            }
            System.out.format("%n%3s%51s%n", "Total", String.format("%.2f", total));

        }
    }
}
