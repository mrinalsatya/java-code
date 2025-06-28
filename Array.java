import java.util.*;

class Array{
    public static void main(String args[]){
        System.out.println("Enter the size fo the array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("you have entered: " + n);
        System.out.println("Enter the values of the array: ");
        int[] nums = new int[n];
        for(int i =0 ; i< n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Values of the array that you entered are: ");
        for(int i =0 ; i< n ; i++){
            System.out.print(nums[i] + ", ");
        }
    }
}