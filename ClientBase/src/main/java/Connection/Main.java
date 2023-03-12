package Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            ClientDaoReq c = new ClientDaoReq(conn);
            GoodDaoReq g = new GoodDaoReq(conn);
            OrderDao o = new OrderDaoReq(conn);

            c.createTableClient();
            g.createTableGood();
            o.createTableOrder();

            System.out.println("Make your choose" + System.lineSeparator() + "1. Add new client" + System.lineSeparator() +
                    "2. Show all clients" + System.lineSeparator() +
                    "3. Add new good" + System.lineSeparator() + "4. Show all goods" + System.lineSeparator() +
                    "5. Add new order" + System.lineSeparator() + "6. Show all orders" + System.lineSeparator() +
                    "Enter your answer" + System.lineSeparator());

            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            while (s.equals("1")) {
                System.out.println("Enter name");
                String name = sc.nextLine();

                System.out.println("Enter sName");
                String sName = sc.nextLine();

                System.out.println("Enter phone");
                int phone = Integer.valueOf(sc.nextLine());

                System.out.println("Enter city");
                String city = sc.nextLine();


                c.addClient(name, sName, phone, city);


                System.out.println("Do you want enter new client? if yes enter 1" + System.lineSeparator());
                s = sc.nextLine();
                if (!(s.equals("1"))) {
                    s = "2";
                }
            }

            while (s.equals("2")) {

                List<Client> list = c.getAllClients();
                for (Client cl : list) {
                    System.out.println(cl);
                }
                break;
            }

//            int article, String name, int price
            while (s.equals("3")) {
                System.out.println("Enter article");
                int article = Integer.valueOf( sc.nextLine());

                System.out.println("Enter name");
                String name = sc.nextLine();

                System.out.println("Enter price");
                int price = Integer.valueOf(sc.nextLine());

                g.addGood( article, name, price);


                System.out.println("Do you want enter new good? if yes enter 3" + System.lineSeparator());
                s = sc.nextLine();
                if (!(s.equals("3"))) {
                    s = "4";
                }
            }

            while (s.equals("4")) {

                List<Good> list = g.getAllGoods();
                for (Good gd : list) {
                    System.out.println(gd);
                }
                break;
            }

//            int id, String nameGood, int articleGood, int quantity, int phoneClient, String nameClient

            while (s.equals("5")) {
                System.out.println("Enter name of good");
                String nameGood = sc.nextLine();

                System.out.println("Enter article of good");
                int articleGood = Integer.valueOf( sc.nextLine());

                System.out.println("Enter quantity");
                int quantity = Integer.valueOf(sc.nextLine());

                System.out.println("Enter phone of client");
                int phoneClient = Integer.valueOf(sc.nextLine());

                System.out.println("Enter name of client");
                String nameClient = sc.nextLine();

                o.addOrder( nameGood,  articleGood, quantity, phoneClient, nameClient);


                System.out.println("Do you want enter new order? if yes enter 5" + System.lineSeparator());
                s = sc.nextLine();
                if (!(s.equals("5"))) {
                    s = "6";
                }
            }

            while (s.equals("6")) {

                List<Order> list = o.getAllOrders();
                for (Order or : list) {
                    System.out.println(or);
                }
                break;
            }




        }
    }

}
