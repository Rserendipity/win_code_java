package lesson;

class Animal {
    public String name;
    public int age;

    public void jiao() {
        System.out.println(name + "正在叫");
    }
}

class Dog extends Animal {
    @Override
    public void jiao() {
        System.out.println(name + "正在旺旺");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void jiao() {
        System.out.println(name + "正在喵喵");
    }
}

public class Lesson9 {

    public static int val = 0;

    public static void main(String[] args) {
        /*
         * Java的继承和C++很像，继承关键字为 extends
         * 重载、重写，都是一致的
         * 同名变量，发生隐藏，优先用子类自己的
         * 同名函数，不构成重写的时候，也是隐藏，想调用父类的时候，加上前缀super
         * 同名函数且参数个数、顺序相同，则发生重写，使用父类的引用，可以调用到子类重写后的函数
         *
         * 若父类只有带参构造，那么子类必须在自己的构造函数内显示的调用super()进行对父类的初始化
         * 且super()要在第一行，原因是必须初始化完毕父类，子类才可以初始化
         * */
        Animal miaomiao = new Cat("小菊", 10);
        miaomiao.jiao();
    }
}
