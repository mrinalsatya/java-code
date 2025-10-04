package aToZStiverDSASheetJAVA.src._03_Arrays.Easy;
import java.util.ArrayList;
public class UnionOfArray {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< a.length; i++){
            set.add(a[i]);
        }
        for(int i = 0; i< b.length; i++){
            set.add(b[i]);
        }

        return new ArrayList<>(set);
    }
}
