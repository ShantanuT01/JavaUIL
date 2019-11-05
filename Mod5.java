import java.util.*;
import java.io.*;
public class Mod5{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("Mod5.txt"));
        int j = s.nextInt();
        for(int i = 0; i < j;i++){
            int m = s.nextInt();
            ArrayList<Integer> x = new ArrayList<>();

            for(int k =0; k < m; k++){
                x.add(s.nextInt());
            }
            ArrayList<Integer> sorted = new ArrayList<>();
            while(!x.isEmpty()){
                int biggest = findLargest(x);
                sorted.add(biggest);
                x.remove(Integer.valueOf(biggest));
            }
            Collections.reverse(sorted);
            for(Integer n: sorted){
                System.out.print(n.intValue() + " ");
            }
            System.out.println();
        }
        s.close();
    }
    public static int max(int a, int b){
        if(a%5==0 && b%5==0){
            return Math.max(a,b);
        }
        else if(a%5==0 && b%5!=0){
            return a;
        }
        else if(a%5!=0 && b%5==0){
            return b;
        }
        else{
            return Math.max(a,b);
        }
    }
    public static int findLargest(ArrayList<Integer> nums){
        int big = nums.get(0);
        for(int i = 0; i < nums.size();i++){
            big=max(nums.get(i),big);
        }    
        return big; 
    }
}