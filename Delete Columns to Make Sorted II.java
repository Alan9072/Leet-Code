class Solution {
    public int minDeletionSize(String[] strs) {
        
        int ans = 0;

        String[] dummy = new String[strs.length];

        for(int i=0;i<strs[0].length();i++){

            String[] arr = Arrays.copyOf(dummy,strs.length);

            for(int j=0;j<strs.length;j++){
                arr[j] += strs[j].charAt(i);
            }

            if(isSorted(arr)){
                dummy = arr;
            }else{
                ans++;
            }    
        }
        return ans;
    }

    public boolean isSorted(String[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i].compareTo(arr[i-1]) < 0)return false;
        }
        return true;
    }
}
