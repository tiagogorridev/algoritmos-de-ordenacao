public class Algorithms {
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) { return; }

        bubbleSort(arr, arr.length);
    }
    
    private static void bubbleSort(int[] arr, int size) {
        if (size == 1) { return; }
        
        boolean swapped = false;
        
        for (int j = 0; j < size - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                swapped = true;
            }
        }
        
        if (!swapped) { return; }
        
        bubbleSort(arr, size - 1);
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) { return; }
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) { return; }
        
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
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
}