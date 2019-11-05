import java.util.*;
import java.io.*;
public class Steganography{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("steganography.txt"));  
        int n = s.nextInt();
        s.nextLine();
        for(int i = 0; i  < n;i++){
            String line = s.nextLine();
            String[] parsed = line.split("");
            int index = 0;
            String ret = "";
            for (int j = 0; j < parsed.length; j++) {
                if(parsed[j].equals(" ")){
                    ret+=parsed[j];
                    index++;
                    continue;
                   
                }
                if(index %2!=1){
                    ret+=parsed[j];
                }
                index++;
                

            }
            System.out.println(ret);
        }
        s.close();  
    }

    
}