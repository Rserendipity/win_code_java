package item.BookSystem.user;

import item.BookSystem.operate.*;

import java.util.Scanner;

public class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
        this.iOperates = new IOperate[]{
                new exitOperate(),
                new addOperate(),
                new delOperate(),
                new showOperate(),
        };
    }

    @Override
    public int menu() {
        System.out.println("==================");
        System.out.println("this is admin user menu");
        System.out.println("0 exit");
        System.out.println("1 add");
        System.out.println("2 del");
        System.out.println("3 show");
        System.out.println("==================");
        Scanner cin = new Scanner(System.in);
        return cin.nextInt();
    }
}
