public class B3DivideConquer {

    public static void main(String[] args) {

        int[] arr = {93, 42, 70, 64, 40, 39, 88, 43, 25, 22};

        int[] result = findMinMax(arr, 0, arr.length - 1);

        int min = result[0];
        int max = result[1];

        System.out.println("Minimum = " + min);
        System.out.println("Maximum = " + max);
        System.out.println("Range (Max - Min) = " + (max - min));
    }

    static int[] findMinMax(int[] arr, int left, int right) {

        // Base case: one element
        if (left == right) {
            return new int[]{arr[left], arr[left]};
        }

        // Base case: two elements
        if (right == left + 1) {
            if (arr[left] < arr[right]) {
                return new int[]{arr[left], arr[right]};
            } else {
                return new int[]{arr[right], arr[left]};
            }
        }

        int mid = (left + right) / 2;

        int[] leftResult = findMinMax(arr, left, mid);
        int[] rightResult = findMinMax(arr, mid + 1, right);

        int min = Math.min(leftResult[0], rightResult[0]);
        int max = Math.max(leftResult[1], rightResult[1]);

        return new int[]{min, max};
    }
}