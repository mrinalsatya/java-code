package aToZStiverDSASheetJAVA.src._07_Recursion.Basics;

public class BasicsOfRecursion {
    public static void printName(String name, int count){
        if(count == 0)
            return;
        System.out.println(name);
        count--;
        printName(name,count);
    }

    public static void printNto1(int num){
        if(num == 0)
            return;
        System.out.println(num);

        printNto1(num-1);
    }

    public static void print1toN(int num){
        if(num < 1)
            return;

        print1toN(num-1);

        System.out.println(num);
    }

    public static void main(String[] args) {
        printName("Mrinal", 5);
        printNto1(5);
        print1toN(5);
    }
}
