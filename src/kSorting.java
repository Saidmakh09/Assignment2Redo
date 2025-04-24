public class kSorting {
    public static void KSorted(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        int k = 10;
        for (int i = 0; i < n; i++) {
            int swapDistance = (int)(Math.random() * (k + 1));
            boolean swapForward = Math.random() > 0.5;

            int swapPos = swapForward ? i + swapDistance : i - swapDistance;

            if (swapPos >= 0 && swapPos < n) {
                int temp = array[i];
                array[i] = array[swapPos];
                array[swapPos] = temp;
            }
        }
    }

    public static void KSortedWithRandomValues(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 100);
        }

        int[] sorted = array.clone();
        java.util.Arrays.sort(sorted);

        java.util.HashMap<Integer, Integer> positionMap = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            positionMap.put(sorted[i], i);
        }

        for (int i = 0; i < n; i++) {
            int originalPos = positionMap.get(array[i]);
            int maxDistance = 10;

            int minPos = Math.max(0, originalPos - maxDistance);
            int maxPos = Math.min(n - 1, originalPos + maxDistance);

            int newPos = minPos + (int)(Math.random() * (maxPos - minPos + 1));

            if (newPos != i) {
                int temp = array[i];
                array[i] = array[newPos];
                array[newPos] = temp;

                positionMap.put(array[i], i);
                positionMap.put(temp, newPos);
            }
        }
    }

    public static boolean isKSorted(int[] array, int k) {
        int[] sorted = array.clone();
        java.util.Arrays.sort(sorted);

        java.util.HashMap<Integer, Integer> sortedPos = new java.util.HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            sortedPos.put(sorted[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            int correctPos = sortedPos.get(array[i]);
            if (Math.abs(i - correctPos) > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] testArray = new int[20];
        KSorted(testArray);

        System.out.println("Generated 10-sorted array:");
        for (int value : testArray) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Is array 10-sorted? " + isKSorted(testArray, 10));
    }
}