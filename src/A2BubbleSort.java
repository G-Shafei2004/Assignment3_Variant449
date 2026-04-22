public class A2BubbleSort {

    public static void main(String[] args) {

        int[] arr = {93, 42, 70, 64, 40, 39, 88, 43, 25, 22};

        int n = arr.length;

        // Only first 3 passes
        for (int pass = 1; pass <= 3; pass++) {

            boolean swapped = false;

            for (int i = 0; i < n - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("After Pass " + pass + ": ");
            print(arr);

            // Early Exit
            if (!swapped) {
                System.out.println("No swaps → Early Exit");
                break;
            }
        }
    }

    static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}