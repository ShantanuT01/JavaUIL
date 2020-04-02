import java.io.*;
import java.util.*;
public class Lethologica{
    public static void main(String[] args) throws Exception{
       Scanner s = new Scanner(new File("Lethologica.txt"));
       int limit = s.nextInt();
       s.nextLine();
       for (int i = 0; i < limit; i++) {
           String sentence = s.nextLine();
           String word = s.nextLine();
           System.out.println(sentence.replaceAll("\\*", word));
       }
       s.close(); 
    }

}
