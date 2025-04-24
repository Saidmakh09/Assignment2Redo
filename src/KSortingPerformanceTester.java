public class KSortingPerformanceTester {
    public static void main(String[] args) {
        Tester bubbleTester = new Tester(new BubbleSort());
        Tester insertionTester = new Tester(new InsertionSort());
        Tester selectionTester = new Tester(new SelectionSort());
        Tester shellTester = new Tester(new ShellSort());
        Tester quickTester = new Tester(new QuickSort());
        Tester mergeTester = new Tester(new MergeSort());

        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000};
        int iterations = 20;

        System.out.println("====== PERFORMANCE WITH RANDOM DATA ======");
        testAllAlgorithms(iterations, sizes, bubbleTester, insertionTester, selectionTester,
                shellTester, quickTester, mergeTester, false);

        System.out.println("\n====== PERFORMANCE WITH 10-SORTED DATA ======");
        testAllAlgorithms(iterations, sizes, bubbleTester, insertionTester, selectionTester,
                shellTester, quickTester, mergeTester, true);
    }

    private static void testAllAlgorithms(int iterations, int[] sizes,
                                          Tester bubbleTester, Tester insertionTester,
                                          Tester selectionTester, Tester shellTester,
                                          Tester quickTester, Tester mergeTester,
                                          boolean useKSorted) {

        for (int size : sizes) {
            System.out.println("\nArray size: " + size);

            double bubbleTime = testAlgorithm("BubbleSort", bubbleTester, iterations, size, useKSorted);
            double insertionTime = testAlgorithm("InsertionSort", insertionTester, iterations, size, useKSorted);
            double selectionTime = testAlgorithm("SelectionSort", selectionTester, iterations, size, useKSorted);
            double shellTime = testAlgorithm("ShellSort", shellTester, iterations, size, useKSorted);
            double quickTime = testAlgorithm("QuickSort", quickTester, iterations, size, useKSorted);
            double mergeTime = testAlgorithm("MergeSort", mergeTester, iterations, size, useKSorted);

            if (size >= 10000) {
                System.out.println("Skipping slower algorithms for large arrays");
            }
        }
    }

    private static double testAlgorithm(String name, Tester tester, int iterations, int size, boolean useKSorted) {
        if ((name.equals("BubbleSort") || name.equals("SelectionSort")) && size > 10000) {
            System.out.println(name + ": Skipped for large array");
            return -1;
        }

        double totalTime = 0;

        for (int i = 0; i < iterations; i++) {
            double time = useKSorted ? tester.singleTestTenSorted(size) : tester.singleTest(size);
            totalTime += time;
        }

        double averageTime = totalTime / iterations;
        System.out.println(name + ": " + averageTime + " ms (avg)");
        return averageTime;
    }
}
