//Реализуйте алгоритм сортировки числового массива пузырьком
//Результат после каждой итерации запишите в лог-файл
import java.io.IOException;
import java.util.logging.*;
import java.util.*;
public class task_10 {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = rand.nextInt(10);
        int[] arr = new int[size];
        arr = getRandomIntArray(100, size);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(BubleSortArray(arr)));

    }

    public static int[] getRandomIntArray(int upperRange, int size){
        Random random = new Random();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(upperRange);
        }
        return arr;
    }

    public static int[] BubleSortArray(int[] arr){
        Logger log = Logger.getLogger("task_10");
            try {
                FileHandler handler = new FileHandler("task_10.log");
                log.addHandler(handler);
                
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        int temp = 0;
        boolean sorted = false;
        log.log(Level.INFO, String.format("Исходный массив: %s", Arrays.toString(arr)));
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    sorted = false;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp; 
                    log.log(Level.INFO, String.format("Итерация: %s", Arrays.toString(arr)));             
                }
            }
        }
        log.log(Level.INFO, String.format("Конечный массив: %s", Arrays.toString(arr)));
        return arr;
    }
}
