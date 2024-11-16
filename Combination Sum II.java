class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        for(int val : candidates){
            list.add(val);
        }

        cSum(list,new ArrayList<>(),0,target,0);
        return mainList;
    }
    public void cSum(List<Integer> main,List<Integer> rslt,int sum,int target,int index){
        
        if(sum == target){
            mainList.add(new ArrayList<>(rslt));
            return;
        }
        for(int i=index;i<main.size();i++){
            if(i > 0 && main.get(i) == main.get(i - 1)){
                continue;
            }
            if(sum + main.get(i) > target){
                break;
            }
            sum+=main.get(i);
            rslt.add(main.get(i));
            int val = main.remove(i);

            cSum(main,rslt,sum,target,i);
            main.add(i,val);
            sum -= rslt.remove(rslt.size() - 1);
            
        }

    }
}
