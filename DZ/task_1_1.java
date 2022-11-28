import java.io.*;
import java.util.Arrays;

public class task_1_1 {
    public static void main(String[] args) {
        String fileName = "sql_req.json";
        String my_str = FileToString(fileName);
        System.out.printf("Исходная строка: %s\n", my_str.toString());
        my_str = my_str.replaceAll("[}{]", "");
        String[] splitedStr = my_str.split(","); 
        System.out.printf("Создаем массив: %s\n", Arrays.toString(splitedStr));
        String[][] dict = new String[splitedStr.length][2];
        for(int i = 0; i < splitedStr.length; i++){
            dict[i]= splitedStr[i].split(":");
        }
        System.out.printf("Разбиваем массив на массив массивов: %s\n", Arrays.deepToString(dict));
    }

    public static void StrToFile(String str, String fileName){
        try {
            File f_1 = new File(fileName);
            f_1.createNewFile();
            FileWriter writer = new FileWriter(f_1);
            writer.write(str);
            writer.flush();
            writer.close();
        } 
        catch (IOException e) {
                System.out.println(e.getMessage());
        }
    }

    public static String FileToString(String fileName) {
        StringBuilder str = new StringBuilder();
        String newStr = new String();
        
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            char [] a = new char[(int)file.length()];
            reader.read(a);
            reader.close();
            for(char c : a) {

                str.append(c);
            }
            newStr = str.toString();        
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newStr;
    }    
    
}
