public class Main {
    public static void main(String[] args) {
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Antes da ordenação por inserção:");
        printArray(arr1);
        
        Algorithms.insertionSort(arr1);
        
        System.out.println("Depois da ordenação por inserção:");
        printArray(arr1);
        
        System.out.println();
        

        int[] arr2 = {5, 2, 8, 1, 9, 3};
        System.out.println("Antes da ordenação por bolha:");
        printArray(arr2);
        
        Algorithms.bubbleSort(arr2);
        
        System.out.println("Depois da ordenação por bolha:");
        printArray(arr2);
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

