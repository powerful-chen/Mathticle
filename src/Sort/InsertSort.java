package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, 22, 14};

        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            int insertVal = arr[i];
            int inserIndex = i - 1;

            // 1、insertIndex >= 0 保证给insertVal 找插入位置，不越界
            // 2、insertVal < arr[insertIndex]待插入的数，还没有找到插入位置
            // 3、需要将arr[insertIndex]后移
            while (inserIndex >= 0 && insertVal < arr[inserIndex]) {
                arr[inserIndex + 1] = arr[inserIndex];
                inserIndex--;
            }

            // 当退出while 循环时，说明插入的位置找到，insertIndex + 1
            arr[inserIndex + 1] = insertVal;
//            System.out.println("第" + i + "次");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
