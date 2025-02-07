public class kSorting {


    public static void KSorted(int[] array) {
        int n = array.length;
        //random numbers
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        //10 gap
        int gap = 10;
        for (int i = gap; i < n; i++) {
            int temp = array[i];
            int j = i;
            while (j >= gap && array[j - gap] > temp) {
                array[j] = array[j - gap];
                j -= gap;
            }
            array[j] = temp;
        }
    }
}
