class Solution {
    public int countLargestGroup(int n) {
        int maxSize = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            int num = i;
            int sum = 0;
            while(num > 0){
                sum += num % 10;
                num = num / 10;
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        for(int val : map.values()){
            maxSize = Math.max(maxSize,val);
        }
        for(int val : map.values()){
            if(val == maxSize)count++;
        }
        return count;
    }
}
