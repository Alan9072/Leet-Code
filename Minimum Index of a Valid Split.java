class Solution {
    public int minimumIndex(List<Integer> nums) {
        
        int dominant = nums.get(0);
        int frq = 1;
        for(int i=1;i<nums.size();i++){
           if(nums.get(i) != dominant){
            frq--;
            if(frq == 0){
                dominant = nums.get(i);
                frq = 1;
            }
           }else{
            frq++;
           }
        }
        int frequency = 0;
        int index = -1;
        boolean valid1 = false;
        boolean valid2 = false;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i) == dominant){
                frequency++;
            }
            if((i + 1)/2 < frequency){
                valid1 = true;
                index = i;
                break;
            }
        }

        frequency = 0;
        for(int i=index + 1;i<nums.size();i++){
            if(nums.get(i) == dominant){
                frequency++;
            }
        }
        if((nums.size() - index + 1)/2 <= frequency){
            valid2 = true;
        }

        return valid1 && valid2 ? index : -1;
    }
}
