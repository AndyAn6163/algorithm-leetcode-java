package algorithm.training.helloalgo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Array {

    int randomAccess(int[] arr) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, arr.length);
        int value = arr[randomIndex];
        System.out.println(value);
        return value;
    }

    void insert(int[] arr, int value, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            // 依序向後 3 -> 4 、 2 -> 3
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        System.out.println(Arrays.toString(arr));
    }

    void remove(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            // 依序向前 3 -> 2 、 4 -> 3
            arr[i] = arr[i + 1];
        }
        System.out.println(Arrays.toString(arr));
    }

    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    int[] extend(int[] nums, int enlarge) {
        int[] res = new int[nums.length + enlarge];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {

        int[] arr = new int[5];
        int[] nums = {1, 3, 2, 5, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));

        Array array = new Array();

        System.out.println("================================================");
        array.randomAccess(nums);
        System.out.println("================================================");
        array.insert(nums, 9, 1);
        System.out.println("================================================");
        array.remove(nums, 1);
        System.out.println("================================================");
        array.traverse(nums);
        System.out.println("================================================");
        array.find(nums, 3);
        System.out.println("================================================");
        array.extend(nums, 9);
        System.out.println("================================================");

    }
}
