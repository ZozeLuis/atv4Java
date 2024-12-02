package atv4;

public class sort {
	
	public void bubbleSort(int[] vet) {
        int n = vet.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    int temp = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = temp;
                }
            }
        }
    }
	
	public void selectionSort(int[] vet) {
        int n = vet.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (vet[j] < vet[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = vet[minIdx];
            vet[minIdx] = vet[i];
            vet[i] = temp;
        }
    }
	
	public void insertionSort(int[] vet) {
        int n = vet.length;
        for (int i = 1; i < n; i++) {
            int key = vet[i];
            int j = i - 1;
            while (j >= 0 && vet[j] > key) {
                vet[j + 1] = vet[j];
                j = j - 1;
            }
            vet[j + 1] = key;
        }
    }
	
	  public void mergeSort(int[] vet) {
	        if (vet.length < 2) return;
	        int mid = vet.length / 2;

	        int[] left = new int[mid];
	        int[] right = new int[vet.length - mid];

	        System.arraycopy(vet, 0, left, 0, mid);
	        System.arraycopy(vet, mid, right, 0, vet.length - mid);

	        mergeSort(left);
	        mergeSort(right);
	        merge(vet, left, right);
	    }

	    private void merge(int[] arr, int[] left, int[] right) {
	        int i = 0, j = 0, k = 0;
	        while (i < left.length && j < right.length) {
	            if (left[i] <= right[j]) {
	                arr[k++] = left[i++];
	            } else {
	                arr[k++] = right[j++];
	            }
	        }
	        while (i < left.length) arr[k++] = left[i++];
	        while (j < right.length) arr[k++] = right[j++];
	    }
	
	    public void quickSort(int[] arr) {
	        quick(arr, 0, arr.length - 1);
	    }

	    private void quick(int[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            quick(arr, low, pi - 1);
	            quick(arr, pi + 1, high);
	        }
	    }

	    private int partition(int[] arr, int low, int high) {
	        int pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (arr[j] <= pivot) {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i + 1];
	        arr[i + 1] = arr[high];
	        arr[high] = temp;
	        return i + 1;
	    }
	    
	    public void heapSort(int[] arr) {
	        int n = arr.length;
	        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
	        for (int i = n - 1; i >= 0; i--) {
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	            heapify(arr, i, 0);
	        }
	    }

	    private void heapify(int[] arr, int n, int i) {
	        int largest = i;
	        int left = 2 * i + 1;
	        int right = 2 * i + 2;

	        if (left < n && arr[left] > arr[largest]) largest = left;
	        if (right < n && arr[right] > arr[largest]) largest = right;

	        if (largest != i) {
	            int temp = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = temp;
	            heapify(arr, n, largest);
	        }
	    }



}
