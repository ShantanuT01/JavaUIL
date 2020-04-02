import java.io.*;
import java.util.*;
import java.awt.*;
public class Transposition{
    public static void main(String[] args) throws Exception{
        Scanner s= new Scanner(new File("Transposition.txt"));
        int limit = s.nextInt();
        s.nextLine();
        for (int i = 0; i < limit; i++) {
            String word = s.nextLine();
           
            int d = squareMatrix(word);
            String[][] matrix = new String[d][d];
            String[] parts = word.split("");
            int index = 0;
            for (int j = 0; j < d; j++) {
                for (int j2 = 0; j2 < d; j2++) {
                    if(index < parts.length){
                    matrix[j][j2] = parts[index];
                    index++;}
                    else{
                        matrix[j][j2] = "*";
                    }
                }
            }
            String scrambled = "";
            for (int j = d-1; j >= 0; j--) {
                Point p = new Point(0, j);
                scrambled+=iterateD(matrix, p);
            }
            for(int k = 1; k < d; k++){
                scrambled+=iterateD(matrix, new Point(k,0));
            }

            System.out.println(scrambled);

        }
        s.close();
    }
    public static int squareMatrix(String word){
        int n = word.length();
        int d = 1;
        while(Math.pow(d,2) <= n){
            d++;
        }
        return d;
    }
    public static String iterateD(String[][] arr, Point p){
        String ret = "";
        int r = p.x;
        int c = p.y;
        while(r < arr.length && c < arr[0].length){
            ret+=arr[r][c];
            r++;
            c++;
           
        }
        return ret;
    }

}
