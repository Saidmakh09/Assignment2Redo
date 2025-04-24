
public interface SortingAlgorithm{
     int[] sorty(int[] input);
}


class BubbleSort  implements SortingAlgorithm{


    public int[] sorty(int[] input){
    int n = input.length;

    int temp;

    for(int i = 0; i < n -1; i++){
        for(int j = 0; j < n-1-i; j++){
        if(input[j+1] < input[j]){
            temp = input[j];
            input[j] = input[j+1];
            input[j+1] = temp;
        }
        }
    }
        return input;
    }
}


class InsertionSort implements SortingAlgorithm{

    public int[] sorty(int[] input){
        int temp;

        for(int i  = 1; i < input.length; i++){

            temp = input[i];

            int j;

            for( j = i; j > 0 && temp < input[j - 1]; j--){
                input[j] = input[j-1];
            }
            input[j] = temp;
        }
        return input;
    }
}

class SelectionSort implements SortingAlgorithm {

    public int[] sorty(int[] input) {

    for(int i = 0; i < input.length; i++){
        int minIndex = i;
        for(int j = i; j < input.length; j++){
            if(input[j] < input[minIndex]){
                minIndex = j;
            }
        }
        int temp = input[i];
        input[i] = input[minIndex];
        input[minIndex] = temp;
    }

        return input;
    }
}

class QuickSort implements SortingAlgorithm {

    public int[] sorty(int[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class MergeSort implements SortingAlgorithm {

    public int[] sorty(int[] input) {
        mergeSort(input, 0, input.length - 1);
        return input;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}


class ShellSort implements SortingAlgorithm{

    public int[] sorty(int[] input){
        int n = input.length;


        for(int gap = n/2; gap > 0; gap /= 2 ){
            for(int i = gap; i < n; i++){
                int tmp = input[i];
                int j;

                for(j = i; j >= gap && tmp < input[j - gap]; j -= gap){

                        input[j] = input[j-gap];
                }

                input[j] = tmp;
            }



        }

        return input;
    }

}












