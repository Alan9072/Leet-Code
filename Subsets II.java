class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> submain = new ArrayList<>();
        for(int val:nums){
            submain.add(val);
        }
        Collections.sort(submain);
        findSubset(submain,new ArrayList<>(),0);
        mainList.add(new ArrayList<>());
        return mainList;
    }
    public void findSubset(List<Integer> submain,List<Integer> result,int index){
        if(submain.size() == 0){
            return;
        }

        for(int i=index;i<submain.size();i++){
            if(i > 0 && submain.get(i) == submain.get(i - 1)){
                continue;
            }

            int curr = submain.remove(i);
            
            result.add(curr);
            mainList.add(new ArrayList<>(result));

            findSubset(submain,result,i);
            
            submain.add(i,result.remove(result.size() - 1));
        }
    }
}
