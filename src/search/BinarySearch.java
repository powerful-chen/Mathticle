package search;

public class BinarySearch {
    public static void main(String[] args) {

        int arr[] = {1, 13, 23, 34, 45, 56, 67};
        int index = binarySearch(arr, 0, arr.length, 99);
        System.out.println("找到了下标" + index);
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
}
