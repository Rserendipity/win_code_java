package lesson;

import java.util.Arrays;

public class Lesson7 {

    public static int binarySearch(int[] arr, int n) {
        int begin = 0, end = arr.length - 1;
        while (begin <= end) {
            int mid = begin + end >> 1;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int ret = binarySearch(arr, 0);
        if (ret != -1) {
            System.out.println("find it and it's index is " + ret);
        } else {
            System.out.println("not find");
        }


        System.out.println();
    }

    public static void main5(String[] args) {
        int[][] arr1 = {{1}, {2}, {3}, {4}};
        int[][] arr2 = arr1.clone();
        System.out.println(arr1[0][0]);
        arr2[0][0] = 100;
        System.out.println(arr1[0][0]);
    }

    public static void main4(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = arr1.clone();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOfRange(arr2, 1, 4); // [1, 4) 左闭右开的区间
        System.out.println(Arrays.toString(arr3));
    }

    public static void main3(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOfRange(arr2, 1, 4); // [1, 4) 左闭右开的区间
        System.out.println(Arrays.toString(arr3));

    }

    public static void main2(String[] args) {
        /*
         * Java的数组是引用类型，所以肯定存在空引用这种东西
         * 即null
         * Java的引用，类似于C++中的指针
         * */
        int[] array = null;

        /*
         * 由于引用的实质是指针，所以，对应的拷贝，为浅拷贝
         * 即arr3 = arr2这样的语句，本质是使得arr3和arr2的指向相同
         * 所以通过arr3改变，arr2也会跟着改变
         * */
        int[] arr2 = {1, 2, 3, 4};
        arr2[0] = 10;
        int[] arr3 = arr2;
        arr3[0] = 20;
        System.out.println(Arrays.toString(arr2)); // 20, 2, 3, 4
        System.out.println(Arrays.toString(arr3)); // 20, 2, 3, 4

    }


    /*
     * @param args:
     * @return void
     * @author chang_jing_jing
     * {@code @description} TODO
     * {@code @date} 2023/5/28 18:48
     */
    public static void main1(String[] args) {
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

        // 三种打印的方式
        // 传统下标访问
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = i + 1;
        }
        // 迭代器/foreach 访问
        for (int n : arr3) {
            System.out.println(n + " ");
        }
        // Arrays类提供的 数组转字符串
        String s = Arrays.toString(arr3);
        System.out.println(s);
    }
}
