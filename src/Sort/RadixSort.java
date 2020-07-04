package Sort;

import java.util.Arrays;

// 基数排序
public class RadixSort {

    public static void main(String[] args) {
        int arr[] ={53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        // 1、得到数组中最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //得到最大的数
        int maxLength = (max + "").length();

        // 定义一个二维数组，表示10个桶，每一个桶就是一个一维数组
        // 说明
        // 1、二维数组包含10个一维数组
        // 2、为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定义为arr.length
        // 3、很明确，基数排序是使用空间换时间的经典算法

        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的次数
        int[] bucketElementCounts = new int[10];

        // 这里我们使用循环将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每一个元素的对应位进行排序处理)，第一次是个位，第二次是百位以此类推
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的排序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            // 遍历每一桶，并将桶中的数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶即第 k 个桶（即第 k 个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第 i+1 轮处理后，需要将每个 bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮，对个位的排序处理 arr=" + Arrays.toString(arr));
        }
    }

}
