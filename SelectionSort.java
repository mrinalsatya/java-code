import java.util.*;

class SelectionSort{
    public static void main(String args[]){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size for the array: ");
        n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int arr[] = new int[n];
        for(int i = 0; i<n ;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Array before sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ ", ");
        }

        for(int i=0;i <n-1; i++){
            int min = i;
            for(int j = i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println();
        System.out.println("Array after sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ ", ");
        }

    }
}