
    public class Performance {
        public static void main(String[] args) {

            Tester bubbleTester = new Tester(new BubbleSort());
            Tester insertionTester = new Tester(new InsertionSort());
            Tester selectionTester = new Tester(new SelectionSort());
            Tester shellTester = new Tester(new ShellSort());
            Tester quick = new Tester(new QuickSort());
            Tester merge = new Tester(new MergeSort());


            int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

            // Test BubbleSort
            System.out.println("Sorting algorithm - BubbleSort");
            for (int size : sizes) {
                bubbleTester.test(20, size);
            }
            System.out.println();


            // Test InsertionSort
            System.out.println("Sorting algorithm - InsertionSort");
            for (int size : sizes) {
                insertionTester.test(20, size);
            }
            System.out.println();

            // Test SelectionSort
            System.out.println("Sorting algorithm - SelectionSort");
            for (int size : sizes) {
                selectionTester.test(20, size);
            }
            System.out.println();

            // Test ShellSort
            System.out.println("Sorting algorithm - ShellSort");
            for (int size : sizes) {
                shellTester.test(20, size);
            }
            System.out.println();

            System.out.println("Sorting algorithm - QuickSort");
            for (int size : sizes) {
                quick.test(20, size);
            }
            System.out.println();

            System.out.println("Sorting algorithm - MergeSort");
            for (int size : sizes) {
                merge.test(20, size);
            }
            System.out.println();

        }
    }


