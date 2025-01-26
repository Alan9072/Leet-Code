///////////////////////just a recursion solution , /////////////////////TLE
class Solution {
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        find(triangle,0,0,sum);
        return min;
    }
    public void find(List<List<Integer>> triangle,int level,int index,int sum){
        if(level == triangle.size()){
            min = Math.min(min,sum);
            return;
        }

        for(int i=index;i<index+2 && i<triangle.get(level).size();i++){
            sum += triangle.get(level).get(i);
            find(triangle,level+1,i,sum);
            sum -= triangle.get(level).get(i);
        }
    }
} 
///////////////////////////////////Recursion ///////////////////////////////////////////////
class Solution {
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp= new ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            List<Integer> level = new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++){
                level.add(Integer.MAX_VALUE);
            }
            dp.add(level);
        }

        int sum = 0;
        return find(triangle,0,0,sum,dp);
        
    }
    public int find(List<List<Integer>> triangle,int level,int index,int sum,List<List<Integer>> dp){
        if(level == triangle.size()){
            return Integer.MAX_VALUE;
        }
        if(dp.get(level).get(index) != Integer.MAX_VALUE){
            return dp.get(level).get(index);
        }
         
        int down = find(triangle,level + 1,index,sum,dp);
        int angled = find(triangle,level + 1,index + 1,sum,dp);

        if(down == Integer.MAX_VALUE && angled == Integer.MAX_VALUE){
            dp.get(level).set(index, triangle.get(level).get(index));
            return triangle.get(level).get(index);
        }
        
        int val = Math.min(triangle.get(level).get(index) + down , triangle.get(level).get(index) + angled);
        dp.get(level).set(index, val);
        return val;
    }
}
