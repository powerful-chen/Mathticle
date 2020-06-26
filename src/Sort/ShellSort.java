package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 5, 6, 1, 134, -1, 34, 0, 1};
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

//        shellSort(arr);
        shellSort2(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素（共gap组），步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }

    // 对交换式的希尔排序进行优化-> 移位法

    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int count = 0;
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while ((j - gap >= 0 && temp < arr[j - gap])) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
//                System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
            }

        }
    }
}
