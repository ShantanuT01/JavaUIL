import java.util.*;
import java.io.*;
public class Cognates{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("Cognates.txt"));
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            int x = findCommon(s.nextLine(),s.nextLine());
            
            System.out.println(x);
        }
        s.close();

    }
    public static int findCommon(String a, String b){
        int ret = 0;
       
        ArrayList<String> ax = new ArrayList<>(Arrays.asList(a.split("")));
        ArrayList<String> bx = new ArrayList<>(Arrays.asList(b.split("")));
        for (int i = ax.size()-1; i >= 0; i--) {
            String letter = ax.get(i);
            if(bx.contains(letter)){
                ret++;
                ax.remove(letter);
                bx.remove(letter);
            }
        }
        return ret;
    }
}