public class A3QuickSort {

    public static void main(String[] args) {

        int[] arr = {93, 42, 70, 64, 40, 39, 88, 43, 25, 22};

        int pivot = arr[0]; // first element
        int i = 1;
        int j = arr.length - 1;

        System.out.println("Pivot = " + pivot);

        while (i <= j) {

            while (i < arr.length && arr[i] <= pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                System.out.println("Swapped " + arr[i] + " and " + arr[j]);
            }
        }

        // place pivot in correct position
        int temp = arr[0];
        arr[0] = arr[j];
        arr[j] = temp;

        System.out.println("Pivot placed at index: " + j);

        System.out.print("Array after partition: ");
        print(arr);
    }

    static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}