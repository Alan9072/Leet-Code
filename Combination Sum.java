class Solution {
    List<List<Integer>> mainList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum(candidates,new ArrayList<>(),0,target,0);
        return mainList;
    }
    public void sum(int[] main,List<Integer> rslt,int sum,int target,int index){
        if(sum > target){
            return;
        }
        if(sum == target){
            mainList.add(new ArrayList<>(rslt));
            return;
        }
        for(int i=index;i<main.length;i++){
            sum += main[i];
            rslt.add(main[i]);

            sum(main,rslt,sum,target,i);
            sum -= rslt.remove(rslt.size() - 1);
        } 
    }
}
