import java.util.*;
public class PatternPrint{
    public void rightHalfPyramid(){
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void reverseRightHalfPyramid(){

    }
    public void leftHalfPyramid(){
        
    }
    public static void main(String args[]){
        rightHalfPyramid();
        reverseRightHalfPyramid();
        leftHalfPyramid();
    }
}