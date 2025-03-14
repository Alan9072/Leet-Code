class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        int potionLen = potions.length;
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int curr = spells[i];

            int left = 0;
            int right = potionLen - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                
                if((long)curr * (long)potions[mid] >= success){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            
            int count = potionLen  - (right + 1);
            result[i] = count;
        }
        return result;
    }
}
