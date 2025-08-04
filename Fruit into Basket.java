class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxC = 0;

        int left = 0;
        for(int right = 0;right < fruits.length ;right++){
            int curr = fruits[right];
            

            map.put(curr,map.getOrDefault(curr,0) + 1);
            while(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0)map.remove(fruits[left]);

                left++;
            }

            maxC = Math.max(maxC,right - left + 1);
        }
        return maxC;
    }
}
