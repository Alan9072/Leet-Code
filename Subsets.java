class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> submain = new ArrayList<>();
        for(int val:nums){
            submain.add(val);
        }
        findSubset(submain,new ArrayList<>(),0);
        mainList.add(new ArrayList<>());
        return mainList;
    }
    public void findSubset(List<Integer> submain,List<Integer> result,int index){
        if(submain.size() == 0||submain.size() == index){
            return;
        }

        for(int i=index;i<submain.size();i++){
            int curr = submain.get(i);
            submain.remove(i);
            

            result.add(curr);
            mainList.add(new ArrayList<>(result));


            findSubset(submain,result,i);

            int val = result.remove(result.size() - 1);
            submain.add(i,val);

        }
    }
}
