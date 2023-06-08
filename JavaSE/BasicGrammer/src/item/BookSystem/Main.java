package item.BookSystem;

import item.BookSystem.user.AdminUser;
import item.BookSystem.user.NormalUser;
import item.BookSystem.user.User;

import java.util.Scanner;

public class Main {

    public static User login() {
        Scanner cin = new Scanner(System.in);
        System.out.print("input your name:");
        String name = cin.next();
        System.out.print("input your identity:");
        int id = cin.nextInt();
        if (id == 1) {
            return new AdminUser(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        User user = login();
        int choice = user.menu();
    }
}
