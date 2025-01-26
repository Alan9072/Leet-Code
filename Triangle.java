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
