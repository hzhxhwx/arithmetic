package day01;

/**
 * 插入排序
 *
 * @author 86185
 */
public class InsertOrder {
    public static void main(String[] args) {
        int[] arr = {112, 23, 424, 3341, 33};
        printOrder(arr);
        insertOrder(arr);
        printOrder(arr);
    }

    private static void printOrder(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");

        }
        System.out.println();
    }

    private static void insertOrder(int[] arr) {
        /**
         * 遍历数组,依次排序0-arr.length,就像打牌摸牌后将牌插入到手牌中
         */
        if (arr.length <= 0 || arr == null) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            //从第一个开始排序,数组越界
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr,j - 1, j );
            }
        }

    }

    private static void swap(int[] arr, int mixValueIndex, int i) {
        int temp;
        temp = arr[i];
        arr[i] = arr[mixValueIndex];
        arr[mixValueIndex] = temp;
    }
}
