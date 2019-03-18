package com.st.uil;

public class Diya{
  public static int x = 1;
  public static int[][] arr = new int[4][4];
  public static void main(String[] args){
	  createSpiralMatrix(6);
  }
  
  public static void LR(int row, int startC, int finalC){
    for(int i = startC; i <= finalC; i++){
        arr[row][i] = x;
        x++;
        
    
    }
  
  }
  
  public static int[][] returnSpiralMatrix(int n){
	  System.out.println("size: " + n);
	  createSpiralMatrix(n);
	  return arr;
  }
  public static void createSpiralMatrix(int n){
	  x=1;
  arr = new int[n][n];
  populate(0,n,1);
  toConsole();
  
  }
  public static void RL(int row, int startC, int finalC){
    for(int i = startC; i >= finalC; i--){
        arr[row][i] = x;
        x++;
        
    
    }
  
  }
  public static void UD(int col, int startR, int finalR){
    for(int i = startR; i <= finalR; i++){
        arr[i][col] = x;
        x++;
        
    
    }
  
  }
  public static void DU(int col, int startR, int finalR){
    for(int i = startR; i >= finalR; i--){
        arr[i][col] = x;
        x++;
        
    
    }
  
  }
  public static boolean isValid(int r, int c){
  return r >= 0 && r < arr.length && c <= 0 && c < arr.length;
  }
  public static void populate(int start, int n, int d){
    while( x <= (arr.length*arr.length)){
      
    LR(start,start,n-d);
    UD(n-d,d,n-d);
    RL(n-d, n-(d+1), d-1);
    DU(d-1, n-(d+1), d);
    populate(++start, n, ++d);
    }
    
  
  }
  public static void toConsole(){
    for(int[] a: arr){
      for(int val:a){
        if(val < 10){
        System.out.print(val + "  ");
        }
        else{
          System.out.print(val + " ");}
      }
      System.out.println();
    }
     String z = "";
     for(int i = 0; i < arr.length; i++){
     z+="===";
     }
     System.out.println(z);
  }
  public static boolean isFull(){
    for(int[] a: arr){
      for(int val: a){
        if(val==0){return false;}
      }
    }
    return true; 
  }
}