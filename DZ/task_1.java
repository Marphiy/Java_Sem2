import java.io.*;

//Дана строка sql-запроса: "select*from students where". Сформулируйте часть WHERE этого запроса, используя StringBuilder. 
//Разберите json-строку используя String.split. Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "countyry": "Russia", "city":"Moscow", "age":"null"}
public class task_1 {

    public static void main(String[] args) {
        
        String fileName = "sql_req.json";
      
        String key = "name";
        // String key = "country";
        // String key = "city";
        // String key = "age";
        
        String[] splitedStr = FileToString(fileName).split(",");
        System.out.println(GetValueByKey(splitedStr, key));
    }
    public static String GetValueByKey(String[] arr, String key){
        StringBuilder str = new StringBuilder();
        String outStr = new String();
        int x = 1;
        for(String word : arr) {
            System.out.println(word);
            if(word.lastIndexOf(key) >= 0) {            
                if(word.lastIndexOf("null") < 0) {
                    if(word.lastIndexOf("}") >= 0) x = 2;
                    char[] dst = new char[word.length() - x - 2 - word.lastIndexOf(":")];
                    word.getChars(word.lastIndexOf(":") + 2, word.length() - x, dst, 0);
                    for(char a : dst) {
                        str.append(a);
                    }
                    outStr = str.toString();
                }
                else outStr = "Пустое значение";
            }
        }
        System.out.println("\n");
        return outStr;
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
            for(char c : a) str.append(c);
            newStr = str.toString();        
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newStr;
    }    
}