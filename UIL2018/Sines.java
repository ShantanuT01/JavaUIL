import java.io.*;
import java.util.*;
public class Sines{
    public static void main(String[] args) throws Exception{
        
        Scanner s = new Scanner(new File("Sines.txt"));
        int n = s.nextInt();
        
        for (int i = 0; i < n; i++) {
            int a=s.nextInt();
            int aa = s.nextInt();
            int ba = s.nextInt();
            
            System.out.printf("%.1f", a*Math.sin(degreesToRadians(ba))/Math.sin(degreesToRadians(aa)));
            System.out.println();
        }
        s.close();
    }
    public static double degreesToRadians(int d){
        return d *Math.PI/180.0;
    }
}
