package item.BookSystem.user;

import java.util.Scanner;

/**
 * @projectName: BasicGrammer
 * @package: item.BookSystem.user
 * @className: NormalUser
 * @author: cjj
 * @description: TODO
 * @date: 2023/6/8 19:27
 */
public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
    }

    @Override
    public int menu() {
        System.out.println("==================");
        System.out.println("this is normal user menu");
        System.out.println("==================");
        Scanner cin = new Scanner(System.in);
        return cin.nextInt();
    }
}
