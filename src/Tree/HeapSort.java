package Tree;

import java.util.Arrays;

//堆排序
public class HeapSort {


    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序");
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param lenght 表示对多少个元素继续调整，length是在逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int lenght) {

        //1、2 * i + 1 是 i 结点的左子结点
        int temp = arr[i];
        for (int k = 2 * i + 1; k < lenght; k = k * 2 + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) { //说明左子结点小于右子结点的值
                k++;// k 指向右子结点
            }
            if (arr[k] > temp) { // 如果子结点大于父结点
                arr[i] = arr[k];// 把较大的值赋给当前结点
                i = k;// i 指向k继续循环比较
            } else {
                break;
            }
        }
        //当 for循环结束后，我们已经将以 i 为父节点的树的最大值，放在了最顶端（局部）
        arr[i] = temp;// 将temp值放到调整后的位置
    }

}
