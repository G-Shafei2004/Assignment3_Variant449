import java.util.Arrays;

public class B1BinarySearch {

    public static void main(String[] args) {

        int[] arr = {93, 42, 70, 64, 40, 39, 88, 43, 25, 22};

        // Step 1: sort array
        Arrays.sort(arr);

        System.out.print("Sorted Array: ");
        print(arr);

        int target = 88;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            System.out.println("Low=" + low + " High=" + high + " Mid=" + mid);

            if (arr[mid] == target) {
                System.out.println("Found " + target + " at index " + mid);
                return;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found");
    }

    static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}