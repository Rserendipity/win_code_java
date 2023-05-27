package lesson1;

import java.util.Arrays;

public class Lesson7 {
    public static void main(String[] args) {
        /*
         * Java的数组，全是引用类型
         * 有三种方式定义
         *
         * T[] name = new T[]
         * T为类型
         * name为变量名
         *
         * 数组的默认值，都为0
         * boolean的值为 false
         * */
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6}; // 上面的定义方式本质是下面这种的简写
        int[] arr3 = new int[10];  // 不能进行初始化
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = i + 1;
        }
        for (int n : arr3) {
            System.out.println(n + " ");
        }
        String s = Arrays.toString(arr3);
        System.out.println(s);
    }
}
