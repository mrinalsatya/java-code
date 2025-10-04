package aToZStiverDSASheetJAVA.src._03_Arrays.Easy;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xr = 0;
        for(int n : nums){
            xr = xr^n;
        }

        return xr;
    }
}
