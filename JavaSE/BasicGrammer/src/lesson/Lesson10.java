package lesson;

import java.util.Arrays;

/*
 * 接口：更加纯粹的抽象
 * 本质和抽象类一致，但是抽象类内可以包含一些杂七杂八的属性，而抽象类不用
 * 抽象类为了实现“通用”规范而设计出来
 *
 * interface定义接口，class XXX implement IXXX 实现接口
 * interface的成员默认属性：public static final
 * interface的方法默认属性：public abstract
 * 其中的方法，是不能有实现的。但是在jdk8中提供了default修饰，可以作为默认实现
 * 可以有static方法
 * */
interface I_USB {
    void openDerive();

    void closeDerive();
}

class Mouse implements I_USB {

    @Override
    public void openDerive() {
        System.out.println("open mouse!");
    }

    @Override
    public void closeDerive() {
        System.out.println("close mouse!");
    }
}


abstract class AbstractAnimal {
    abstract public void eat();
}

class Bird extends AbstractAnimal {
    @Override
    public void eat() {
        System.out.println("Bird is eating");
    }
}

/*
 * Java没有多继承，但是可以多接口
 * 以下为表述：
 * 一个类 是 一个XXX，他具有XXX行为，这里的行为，可以抽象为接口
 * 例如，规定了“游泳”这个接口，那么，只要具有“游泳”这个行为的类，都可以来实现这个接口
 *
 * */

class Tmp implements Comparable<Tmp> {
    int a;
    int b;

    public Tmp(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Tmp obj) {
        if (this.a == obj.a)
            return 0;
        return this.a > obj.a ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Tmp{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

public class Lesson10 {
    public static void main(String[] args) {
        /*
         * Java的abstract类和C++中的纯虚类相似
         * 如果继承了abstract类，那么子类必须 重写其中的abstract方法 或者 子类自己也修饰为abstract类
         *
         * */
        AbstractAnimal bird = new Bird();
        bird.eat();

        Tmp[] tmps = new Tmp[]{new Tmp(1, 2), new Tmp(6, 4), new Tmp(2, 7)};
        Arrays.sort(tmps);
        System.out.println(Arrays.toString(tmps));

    }
}
