import java.io.*;
import java.util.*;
public class Components{
    public static HashMap<String,LinkedList<String>> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("Components.txt"));
        
        int limit = s.nextInt();
        s.nextLine();
        for(int i = 0; i < limit; i++){
            String line = s.nextLine();
            String[] p0 = line.split(">>");
            String[] sub = p0[1].split(" ");
            LinkedList<String> value = new LinkedList<>(Arrays.asList(sub));
            for (int j = value.size()-1; j>=0; j--) {
                if(value.get(j).equals("") || value.get(j).equals(" ")){
                    value.remove(j);
                }
            }
            for (int j = 0; j < value.size(); j++) {
                value.set(j, value.get(j).trim());
            }
          
            map.put(p0[0].trim(), value); 
        }
      
        for (String string : map.keySet()) {
           
            simplifyList(map.get(string));
        }
        int cap = s.nextInt();
        s.nextLine();
       
        for (int i = 0; i < cap; i++) {
            HashSet<String> seen = new HashSet<>();
            String n = s.nextLine();
            n = n.trim();
            LinkedList<String> elements = map.get(n);
           
            Collections.sort(elements);
            for (String string : elements) {
                if(seen.contains(string)){
                    continue;
                }
                else{
                    System.out.println(string + " " + find(string, elements));
                    seen.add(string);
                }
            }
            System.out.println("***");
            
           
        }



        s.close();
    }
   public static boolean isSimplified(LinkedList<String> ingredients){
    for (String string : ingredients) {
        if(map.keySet().contains(string)){
            return false;
        }
        
    }
    return true; 
   }
   public static int find(String word, LinkedList<String> words){
    int ret = 0;
    for (int i = 0; i < words.size(); i++) {
        if(words.get(i).equals(word)){
            ret++;
        }
    }
    return ret; 
   }
   public static void simplifyList(LinkedList<String> ingredients){
       int index = 0;
       
       while(!isSimplified(ingredients)){
        if(index >= ingredients.size()){
            index=0;
        }
           if(!map.keySet().contains(ingredients.get(index))){
               index++;
               continue;
           }
           String ing = ingredients.get(index);
           LinkedList<String> subparts = map.get(ing);
          
           
           ingredients.remove(ing);
           ingredients.addAll(subparts);
           index++;
           
           if(index >= ingredients.size()){
               index=0;
           }

       }
       
       
   }
    

}