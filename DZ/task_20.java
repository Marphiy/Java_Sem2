import java.io.*;
import java.util.Arrays;

public class task_20 {
    public static void main(String[] args) {
    
        String fileName = "new_obj.json";
        String my_str = FileToString(fileName);
        System.out.printf("\nИсходная строка: %s\n\n", my_str.toString());
        my_str = my_str.replaceAll("[}{]", "");
        my_str = my_str.replace(":", ",");
        String[] splitedStr = my_str.split(","); 
        System.out.println("Результат:");
        int x = 1;
        for(int l = 0; l < splitedStr.length; l++){  
            String temp = new String();
            
            char c = splitedStr[l].charAt(0);
            if(l == splitedStr.length - 1) {
                x = 103;              
            }
            for(int k = 1; k < splitedStr[l].length() - x; k ++){
                temp += splitedStr[l].charAt(k);
            }
            splitedStr[l] = temp;
        }
        for(int i = 1; i < splitedStr.length - 4 ; i += 6)
        {
            System.out.printf("Студент %s получил оценку %s по предмету %s\n", 
            splitedStr[i], splitedStr[i + 2], splitedStr[i + 4]);
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
