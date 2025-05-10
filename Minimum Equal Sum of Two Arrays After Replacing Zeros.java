class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long suma = 0;
        int zeroa = 0;
        for(int val : nums1){
            if(val == 0){
                zeroa++;
                suma++;
            }else{
                suma += (long) val;
            }
        }

        long sumb = 0;
        int zerob = 0;
        for(int val : nums2){
            if(val == 0){
                zerob++;
                sumb++;
            }else{
                sumb += (long) val;
            }
        }

        if(zeroa == 0 && zerob == 0){
            if(suma > sumb || sumb > suma){
                return -1;
            }else{
                return suma;
            }
        }else if(zeroa == 0){
            if(sumb > suma){
                return -1;
            }
        }else if(zerob == 0){
            if(suma > sumb){
                return -1;
            }
        }
        return Math.max(suma,sumb);
    }
}
