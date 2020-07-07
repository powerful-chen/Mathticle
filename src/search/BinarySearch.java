package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {

//        int arr[] = {1, 13, 23, 34, 45, 56, 67};
//        int index = binarySearch(arr, 0, arr.length, 99);
//        System.out.println("找到了下标" + index);

        int arr[] = {1, 1000, 1000, 1000, 1200, 1300, 1420};
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList=" + resIndexList);
    }

    /**
     * @param arr       数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 要找的数
     * @return 如果找到就返回下标，找不到就返回负数
     */
    public static int binarySearch(int[] arr, int left, int right, int findValue) {

        if (left > right) {
            return -1;
        }
        if (left < right) {
            return -2;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findValue > midVal) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findValue) {

        if (left > right) {
            return new ArrayList<>();
        }
//        if (left < right) {
//            return new ArrayList<>();
//        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findValue > midVal) {
            return binarySearch2(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binarySearch2(arr, left, mid - 1, findValue);
        } else {
            /**
             * 思路分析
             * 1、在找到 mid 索引值，不要马上返回
             * 2、向 mid 索引值的左边扫描，将所有满足 1000 的元素的下标，加入到ArrayList集合中
             * 3、向 mid 索引值的右边扫描，将所有满足 1000 的元素的下标，加入到ArrayList集合中
             * 4、将ArrayList返回
             */
            List<Integer> resIndexlist = new ArrayList<Integer>();
            // 向 mid 索引值的左边扫描，将所有满足 1000 的下标加入到集合ArrayList中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {// 退出
                    break;
                }
                // 否则，就temp放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1;// temp 左移
            }
            resIndexlist.add(mid);
            //向 mid 索引值的右边扫描，将所有满足 1000 的元素的下标，加入到ArrayList集合中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {// 退出
                    break;
                }
                // 否则，就temp放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1;// temp 左移
            }
            return resIndexlist;
        }
    }
}
