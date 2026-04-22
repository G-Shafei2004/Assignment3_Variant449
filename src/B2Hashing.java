public class B2Hashing {

    public static void main(String[] args) {

        int[] data = {93, 42, 70, 64, 40, 39, 88, 43, 25, 22};

        int M = 7;
        Integer[] table = new Integer[M];

        for (int key : data) {

            int index = key % M;

            int start = index;

            // Linear Probing
            while (table[index] != null) {
                index = (index + 1) % M;

                if (index == start) {
                    System.out.println("Table full, cannot insert: " + key);
                    break;
                }
            }

            if (table[index] == null) {
                table[index] = key;
                System.out.println("Inserted " + key + " at index " + index);
            }
        }

        System.out.println("\nFinal Hash Table:");
        for (int i = 0; i < M; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }
}