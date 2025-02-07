
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

class QuickSort implements SortingAlgorithm{

    public int[] sorty(int[] input){

        if(input.length <= 1){
        return input;
        }





        return input;
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












