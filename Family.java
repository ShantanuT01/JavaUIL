import java.util.*;
import java.io.*;

public class Family {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("Family.txt"));
        int limit = s.nextInt();

        for (int i = 0; i < limit; i++) {
            int members = s.nextInt();
            s.nextLine();
            HashMap<String, ArrayList<String>> familyTree = new HashMap<>();

            for (int j = 0; j < members; j++) {
                process(s.nextLine(), familyTree);
            }
            ArrayList<String> keys = new ArrayList<>(familyTree.keySet());
           
            Collections.sort(keys);
            ArrayList<String> visited = new ArrayList<String>();
             for(String key: keys){
                 if(isRoot(key, familyTree)){
                 iterateBranch(key, familyTree, 0,visited );
                }
             }
            System.out.println("***");
            
        }
        
        s.close();
    }

    public static void process(String phrase, HashMap<String, ArrayList<String>> tree) {
        String[] parts = phrase.split(" ");

        String relation = parts[1];
        
        switch (relation) {
        case "parent_of":
            ArrayList<String> children = tree.get(parts[0]);
            if (children == null) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(parts[2]);
                tree.put(parts[0], temp);
            } else {
                children.add(parts[2]);
                Collections.sort(children);
            }
            break;
        case "child_of":
            ArrayList<String> kids = tree.get(parts[2]);
            if (kids == null) {
                ArrayList<String> temp1 = new ArrayList<String>();
                temp1.add(parts[0]);
                tree.put(parts[2], temp1);
            } else {
                kids.add(parts[0]);
                Collections.sort(kids);
            }
            break;
        case "sibling_of":
            
            for (String parent : tree.keySet()) {
                
                if (tree.get(parent).contains(parts[0])) {
                    
                    tree.get(parent).add(parts[2]);
                    Collections.sort(tree.get(parent));
                    
                }
            }
            break;
        default:
            return;

        }
    }
    public static void iterateBranch(String parent, HashMap<String, ArrayList<String>> tree, int index, ArrayList<String> visited){
        ArrayList<String> branch = tree.get(parent);
        System.out.println(getLines(index)+parent);
        visited.add(parent);
        if(branch==null){
            return;
        }
       

       
        for (int i = 0; i < branch.size(); i++) {
            if(visited.contains(branch.get(i))){
                continue;
            }
            System.out.println(getLines(index+1)+branch.get(i));
            visited.add(branch.get(i));
            
            if(tree.keySet().contains(branch.get(i))){
               visited.add(branch.get(i));
                iterateBranch(tree.get(branch.get(i)).get(0), tree, index+2, visited);
            }
            else{
                continue;
            }
        }
    }
    public static String getLines(int index){
        if(index==0){
            return "";
        }
        else{
            String ret = "";
            for(int i = 0; i < index;i++){
                ret+="-";
            }
            return ret; 
        }
    }
    public static void getContents(HashMap<String, ArrayList<String>> x){
        for(String y: x.keySet()){
            System.out.println(y+ " " + Arrays.toString(x.get(y).toArray()));
        }
    }
    public static boolean isRoot(String root, HashMap<String, ArrayList<String>> x){
        boolean isKey = x.keySet().contains(root);
        boolean isValue = false;
        for (String key : x.keySet()) {
            if(x.get(key).contains(root)){
                isValue = true;
                break;
            }
        }
       return isKey && !isValue; 
    }
}
