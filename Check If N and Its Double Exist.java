class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.isEmpty()){
                set.add(arr[i]);
            }else{
                if(set.contains(arr[i]*2)){
                    return true;
                }
                if(arr[i] % 2 == 0 && set.contains(arr[i]/2)){
                    return true;
                }
                set.add(arr[i]);
            }
            
        }
        return false;
    }
}
