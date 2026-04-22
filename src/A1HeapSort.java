public class A1HeapSort {

    public static void main(String[] args) {

        int[] arr = {93, 42, 70, 64, 40, 39, 88, 43, 25, 22};

        int n = arr.length;

        // Build max heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.print("After Heapify: ");
        print(arr);

        // First extract max
        int temp = arr[0];
        arr[0] = arr[n-1];
        arr[n-1] = temp;

        heapify(arr, n-1, 0);

        System.out.print("After First Extract: ");
        print(arr);
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void print(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}