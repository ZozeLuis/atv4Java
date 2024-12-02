package atv4;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		int[] sizes = {100, 1000, 10000, 50000, 100000};
        sort sorter = new sort(); // Instance of the sort class

        // Names of sorting algorithms and their respective methods
        String[] algorithmNames = {
            "Bubble Sort", "Selection Sort", "Insertion Sort",
            "Merge Sort", "Quick Sort", "Heap Sort"
        };

        for (String algorithm : algorithmNames) {
            System.out.println("Testando: " + algorithm);
            for (int size : sizes) {
                int[] data = generateRandomArray(size);
                long start = System.nanoTime();
                switch (algorithm) {
                    case "Bubble Sort" -> sorter.bubbleSort(data);
                    case "Selection Sort" -> sorter.selectionSort(data);
                    case "Insertion Sort" -> sorter.insertionSort(data);
                    case "Merge Sort" -> sorter.mergeSort(data);
                    case "Quick Sort" -> sorter.quickSort(data);
                    case "Heap Sort" -> sorter.heapSort(data);
                }
                long end = System.nanoTime();
                System.out.printf("Tamanho: %d, Tempo: %.2f ms%n", size, (end - start) / 1_000_000.0);
            }
            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        return rand.ints(size, 0, 100000).toArray();
    }

	

}
