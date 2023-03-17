package Connection;

import Connection.ClientDaoreq;
import com.mysql.cj.xdevapi.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        choose2();
    }
    public static String choose1() throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            ClientDaoreq c = new ClientDaoreq(conn);
            c.createTable();
            System.out.println("Make your choose" + System.lineSeparator() + "1. Add new flat" + System.lineSeparator() +
                    "2. Show all flats" + System.lineSeparator() + "Enter your answer" + System.lineSeparator());
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            while (s.equals("1")) {
                System.out.println("Enter region");
                String region = sc.nextLine();

                System.out.println("Enter square");
                int square = Integer.valueOf(sc.nextLine());

                System.out.println("Enter adress");
                String adress = sc.nextLine();

                System.out.println("Enter rooms");
                int rooms = Integer.valueOf(sc.nextLine());

                System.out.println("Enter price");
                int price = Integer.valueOf(sc.nextLine());

                c.addFlats(region, 1, adress, rooms, price);
                System.out.println("Do you want enter new client? if yes enter 1" + System.lineSeparator());
                s = sc.nextLine();
                if (!(s.equals("1"))) {
                    s = "2";
                }
            }
            return s;
        }
    }

    public static void choose2() throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            ClientDaoreq c = new ClientDaoreq(conn);
            String s = Main.choose1();

            while (s.equals("2")) {

                List<Flat> list = c.getAll();
                for (Flat f : list) {
                    System.out.println(f);
                }
                break;
            }


        }
    }

}