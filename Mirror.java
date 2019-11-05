import java.io.*;
import java.util.*;
public class Mirror{
    public static void main(String[] args) throws Exception{
        Scanner s= new Scanner(new File("Mirror.txt"));
        int limit = s.nextInt();
        s.nextLine();
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < 7; j++) {
                String line = s.nextLine();
                String mod = line+"|";
                ArrayList<String> reverse = new ArrayList<String>(Arrays.asList(line.split("")));
                Collections.reverse(reverse);
                String mirror = "";
                for (int k = 0; k < reverse.size(); k++) {
                    mirror+=reverse.get(k);
                }
                System.out.println(mod+mirror);

            }
            System.out.println("***");
        }
        s.close();

    }
}