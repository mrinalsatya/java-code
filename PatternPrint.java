import java.util.*;
public class PatternPrint{
    public static void rightHalfPyramid(){
        System.out.println("Pattern 1:");
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void reverseRightHalfPyramid(){
        System.out.println("Pattern 2:");
        for(int i = 1; i <= 5; i++){
            for(int j = 5; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void leftHalfPyramid(){
         System.out.println("Pattern 3:");
         int j = 1;
         for(int i = 5; i > 0; i--){
            int k = i-1;
            while(k > 0){
                System.out.print(" ");
                k = k-1;
            }
            k = j;
            while(k > 0){
                System.out.print("*");
                k = k-1;
            }
            System.out.println();
            j++;
         }
    }
    public static void main(String args[]){
        rightHalfPyramid();
        reverseRightHalfPyramid();
        leftHalfPyramid();
    }
}