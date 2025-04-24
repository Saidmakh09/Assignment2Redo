import static java.lang.Math.random;

public class Tester {
    private final SortingAlgorithm sa;


    public Tester(SortingAlgorithm algorithm) {
        this.sa = algorithm;
    }

    public double singleTest(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (random() * 100); // fills arry with random numbers
        }


        long startTime = System.nanoTime();
        sa.sorty(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000.0;
    }

    public double singleTestTenSorted(int size) {
        int[] arr = new int[size];

        kSorting.KSorted(arr);


        long startTime = System.nanoTime();
        sa.sorty(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000.0;
    }

    public void test(int iterations, int size) {
        double totalTime = 0;

        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size);
        }

        double averageTime = totalTime / iterations;
        System.out.println("Sorted " + size + " elements in " + averageTime + " ms (avg)");
    }


        public static void main(String[] args) {
            // Create testers for different sorting algorithms
            Tester bubbleTester = new Tester(new BubbleSort());
            Tester insertionTester = new Tester(new InsertionSort());
            Tester shellTester = new Tester(new ShellSort());
            Tester seleectionTester = new Tester((new SelectionSort()));
            Tester quck = new Tester((new QuickSort()));
            Tester merge = new Tester((new MergeSort()));


            System.out.println("Single test time BubbleSort: " + bubbleTester.singleTest(1000) + " ms"); //single test
            System.out.println("Single test time InsertionSort: " + insertionTester.singleTest(1000) + " ms");
            System.out.println("Single test time ShellSort: " + shellTester.singleTest(1000) + " ms");
            System.out.println("Single test time SelectionSort: " + seleectionTester.singleTest(1000) + " ms");
            System.out.println("Single test time QuickSort: " + quck.singleTest(1000) + " ms");
            System.out.println("Single test time MergeSort: " + merge.singleTest(1000) + " ms");


            System.out.println("Single test time ten sorted BubbleSort: " + bubbleTester.singleTestTenSorted(1000) + " ms"); //single test
            System.out.println("Single test time ten sorted InsertionSort: " + insertionTester.singleTestTenSorted(1000) + " ms");
            System.out.println("Single test time ten sorted ShellSort: " + shellTester.singleTestTenSorted(1000) + " ms");
            System.out.println("Single test time ten sorted SelectionSort: " + seleectionTester.singleTestTenSorted(1000) + " ms");
            System.out.println("Single test time ten sorted QuickSort: " + quck.singleTestTenSorted(1000) + " ms");
            System.out.println("Single test time ten sorted MergeSort: " + merge.singleTestTenSorted(1000) + " ms");


            // Test multiple iterations
            bubbleTester.test(100, 1000);    // 100 iterations with arrays of size 1000
            insertionTester.test(100, 1000);  // Same test with other algoriuthms
            shellTester.test(100, 1000);
            seleectionTester.test(100, 1000);
            quck.test(100, 1000);
            merge.test(100, 1000);

        }
    }
