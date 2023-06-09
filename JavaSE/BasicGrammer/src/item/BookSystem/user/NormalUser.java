package item.BookSystem.user;

import item.BookSystem.operate.IOperate;
import item.BookSystem.operate.exitOperate;
import item.BookSystem.operate.showOperate;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
        this.iOperates = new IOperate[]{
                new exitOperate(),
                new showOperate(),
        };
    }

    @Override
    public int menu() {
        System.out.println("==================");
        System.out.println("this is normal user menu");
        System.out.println("0 exit");
        System.out.println("1 show");
        System.out.println("==================");
        Scanner cin = new Scanner(System.in);
        return cin.nextInt();
    }
}
