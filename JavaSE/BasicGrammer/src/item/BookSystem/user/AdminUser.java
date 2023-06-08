package item.BookSystem.user;

import java.util.Scanner;

/**
 * @projectName: BasicGrammer
 * @package: item.BookSystem.user
 * @className: AdminUser
 * @author: cjj
 * @description: TODO
 * @date: 2023/6/8 19:23
 */
public class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
    }

    @Override
    public int menu() {
        System.out.println("==================");
        System.out.println("this is admin user menu");
        System.out.println("==================");
        Scanner cin = new Scanner(System.in);
        return cin.nextInt();
    }
}
