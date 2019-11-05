
import java.util.*;
import java.io.*;
public class Maze {

    public static void main(String[] args) throws Exception{
    
       Scanner s = new Scanner(new File("Maze.txt"));
       int l = s.nextInt();
       for(int i = 0; i < l; i++){
           int d= s.nextInt();
           String[][] arr = new String[d][d];
           s.nextLine();
           for(int k = 0; k <d;k++){
               String line = s.nextLine();
              
               arr[k]=line.split("");
           }
           Cell start = null; 
           for(int r = 0; r < d; r++){
               for(int c= 0; c<d; c++){
                if(arr[r][c].equals("S")){
                    start = new Cell(r,c);
                }
               }
           }
           if(getPath(start,arr) == 0){
            System.out.println("NOT POSSIBLE");
           }
           else{
               System.out.println(getPath(start,arr));
           }
       }
       s.close();
        
        

    }

    public static int getPath(Cell start,String[][] arr) {
        Queue<Cell> level1 = new LinkedList<>();
        level1.add(start);
        Queue<Cell> level2 = new LinkedList<>();
       
        int count = 0;
        while (level2.isEmpty() && !level1.isEmpty()) {
            level2.clear();
            
            while (!level1.isEmpty()) {
                Cell c = level1.remove();

                if (arr[c.x][c.y].equals("E")) {
                    return count;

                } else {

                    level2.addAll(getSpaces(c, arr));
                }

            }
            if(level2.isEmpty()){
                break;
            }
            else{
                count++;
                
                level1.addAll(level2);
                level2.clear();
            }

        }
        return 0; 

    }

    public static ArrayList<Cell> getSpaces(Cell p, String[][] arr) {
        Cell p1 = new Cell(p.x, p.y + 2);
        Cell p2 = new Cell(p.x, p.y + 1);
        Cell p3 = new Cell(p.x, p.y - 2);
        Cell p4 = new Cell(p.x - 2, p.y);
        Cell p5 = new Cell(p.x + 2, p.y);
        Cell p6 = new Cell(p.x - 1, p.y);
        ArrayList<Cell> ret = new ArrayList<>();
        ret.add(p1);
        ret.add(p2);
        ret.add(p3);
        ret.add(p4);
        ret.add(p5);
        ret.add(p6);
        for (int i = ret.size() - 1; i >= 0; i--) {
            if (!isValidCell(ret.get(i), arr)) {
                ret.remove(i);

            } else {
                ret.get(i).setCell(arr[ret.get(i).x][ret.get(i).y]);
            }
        }
        return ret;

    }

    public static boolean isValidCell(Cell p, String[][] arr) {
        if (p.x >= arr.length || p.x < 0) {
            return false;
        } else if (p.y >= arr[0].length || p.y < 0) {
            return false;
        } else if (arr[p.x][p.y].equals("#")) {
            return false;
        } else {
            return true;
        }
    }

    static class Cell {
        public int x;
        public int y;
        public boolean isVisited = false;
        public String content;

        public Cell(int a, int b) {
            x = a;
            y = b;
        }

        public void setCell(String s) {
            content = s;

        }

        public int compareTo(Cell other) {
            if (other.x == x && other.y == y) {
                return 0;
            }
            return 1;
        }

    }

}
