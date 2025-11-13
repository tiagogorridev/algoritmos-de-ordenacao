import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    private static final String[] files = {
        "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
        "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
        "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
    };

    private static final String dataFolder = "data/";

    private static final String[] algorithms = {"bubble", "insertion", "quick"};

    public static void main(String[] args) {
        
        System.out.println("=".repeat(100));
        System.out.println("ALGORITMOS DE ORDENAÇÃO");
        System.out.println("=".repeat(100));
        System.out.printf("%-15s %-10s %-20s %-20s %-20s%n", 
            "Tipo de Dados", "Tamanho", "Bubble Sort (ms)", "Insertion Sort (ms)", "Quick Sort (ms)");
        System.out.println("=".repeat(100));
        
        for (String file : files) {
            
            int[] data = readCSV(dataFolder + file);
            
            if (data == null || data.length == 0) {

                System.err.println("Erro ao processar arquivo: " + file);
                continue;
            
            }
            
            String[] parts = file.replace(".csv", "").split("_");
            String tipo = capitalizeFirst(parts[0]);
            String tamanho = parts[1];
            
            System.out.printf("%-15s %-10s ", tipo, tamanho);
            
            for (String algo : algorithms) {

                long timeNano = measureSortTime(data, algo);
                double timeMs = timeNano / 1_000_000.0;
                System.out.printf("%-20.4f ", timeMs);
            
            }
            
            System.out.println();
        
        }
        
        System.out.println("=".repeat(100));
        
    }
    
    public static int[] readCSV(String filename) {

        int lineCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line = br.readLine();
            
            while ((line = br.readLine()) != null) {
                
                line = line.trim();

                if (!line.isEmpty()) {

                    lineCount++;
                
                }

            }

        } catch (IOException e) {

            System.err.println("Erro ao ler arquivo: " + filename);
            System.err.println("Certifique-se de que o arquivo está na pasta correta.");
            e.printStackTrace();
            return null;
        
        }
        
        int[] data = new int[lineCount];
        int index = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line = br.readLine();
            
            while ((line = br.readLine()) != null) {

                line = line.trim();
                
                if (!line.isEmpty()) {
                
                    data[index++] = Integer.parseInt(line);
                
                }

            }

        } catch (IOException e) {

            System.err.println("Erro ao ler arquivo: " + filename);
            e.printStackTrace();
            return null;
        
        } catch (NumberFormatException e) {
        
            System.err.println("Erro ao converter dados do arquivo: " + filename);
            e.printStackTrace();
            return null;
        
        }
        
        return data;
    
    }
    
    public static long measureSortTime(int[] arr, String algorithm) {

        int[] copy = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
        
            copy[i] = arr[i];
        
        }
        
        long startTime = System.nanoTime();
        
        switch (algorithm.toLowerCase()) {
            case "bubble":
                Algorithms.bubbleSort(copy);
                break;
            case "insertion":
                Algorithms.insertionSort(copy);
                break;
            case "quick":
                Algorithms.quickSort(copy);
                break;
            default:
                System.err.println("Algoritmo desconhecido: " + algorithm);
                return 0;
        }
        
        long endTime = System.nanoTime();
        
        return endTime - startTime;

    }
    
    private static String capitalizeFirst(String str) {
        
        if (str == null || str.isEmpty()) 
            return str;
        else
            return str.substring(0, 1).toUpperCase() + str.substring(1);
    
    }

}