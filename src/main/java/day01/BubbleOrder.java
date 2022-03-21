package day01;

/**
 * 冒泡排序
 * @author 86185
 */
public class BubbleOrder {
    public static void main(String[] args) {
        int[] arr = {112,23,424,3341,33};
        printOrder(arr);
        bubbleOrder(arr);
        printOrder(arr);
    }

    private static void printOrder(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");

        }
        System.out.println();
    }

    private static void bubbleOrder(int[] arr) {
        /**
         * 遍历数组,比较相邻的两个数,将大的数移至最右边
         */
        if (arr.length<=0||arr == null){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    private static void swap(int[] arr, int mixValueIndex, int i) {
        int temp;
        temp =  arr[i];
        arr[i] = arr[mixValueIndex];
        arr[mixValueIndex] = temp;
    }
}
