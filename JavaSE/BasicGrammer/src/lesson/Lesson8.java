package lesson;


class Person {
    /*
     * 静态成员块，用于初始化静态成员
     * 只会被执行一次
     * */
    static {
        System.out.println("this is static block");
    }

    /*  关于权限
     * private       仅自己类中可见
     * default       在本包内可见（就是本文件内）
     * protected     继承中子类可见
     * public        对全部可见
     *
     * */
    private String name;
    private int age;

    /*
     * 非静态代码块，用于非静态成员的初始化
     * 会拷贝到构造函数内
     * */ {
        this.name = "init"; // 如果构造函数又赋值了，这个值就会无效
        System.out.println("this is no-static block");
    }

    /*
     * Java有构造函数，其实就是和C++一致，但是没有初始化列表
     * 也可以进行函数重载
     * Java没有析构，jvm会自动析构
     * */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * Java的static方法和C++类似
     * 属于整个类，而不是成员，不能使用this指针
     * 成员可以引用，但是有警告
     * 最好是直接通过类名进行访问
     * */
    public static void print() {
        System.out.println("this is static func");
    }

    public void set(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("name : " + name + "age: " + age);
    }

    public void test() {
        System.out.println("this is a test");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Lesson8 {
    public static void main(String[] args) {
        /*
         * Java中的类和对象，和 C++类似。。。妈的，Java纯纯抄C++！！
         * C++中的成员变量，在Java中叫成员属性
         * C++中的成员函数，在Java中叫成员方法
         * 包括访问权限、this指针、权限是一样的
         * 多了一个default，不写任何权限的时候，默认是这个
         *
         * 区别：
         *      this指针在无参构造函数内，可以调用有参构造
         *      但是必须在第一行进行 this(...)调用
         **/
        Person p = new Person("zhangsan", 10);
        System.out.println(p);
        // Person p2 = null;
        // p2.test();

    }
}
