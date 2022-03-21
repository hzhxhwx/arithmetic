package day01;

/**
 *
 * @author 86185
 * 选择排序
 */
public class SelectOrder {

    public static void main(String[] args) {
        int[] arr = {112,23,424,3341,33};
        printOrder(arr);
        selectOrder(arr);
        printOrder(arr);
    }

    private static void printOrder(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");

        }
        System.out.println();
    }

    private static void selectOrder(int[] arr) {
        /**
         * 遍历数组,找到最小的与未排序的第一位交换
         */
        if (arr.length<0||arr == null){
            return;
        }
        int mixValueIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j =i+1; j <arr.length ; j++) {
                if (arr[j] < arr[mixValueIndex]){
                    mixValueIndex = j;
                }


            }

            //交换最小值到未排序的第一位
            swap(arr, mixValueIndex, i);
        }

    }

    private static void swap(int[] arr, int mixValueIndex, int i) {
        int temp;
        temp =  arr[i];
        arr[i] = arr[mixValueIndex];
        arr[mixValueIndex] = temp;
    }

}
