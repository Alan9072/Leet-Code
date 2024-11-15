class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> sub = new ArrayList<>();
        for(int val : nums){
            sub.add(val);
        }
        permute(sub,new ArrayList<>(),nums.length);
        return mainList;
    }
    public void permute(List<Integer> main,List<Integer> rslt,int length){
        if(main.size() == 0){
            mainList.add(new ArrayList<>(rslt));
            return;
        }

        for(int i=0;i<main.size();i++){
            if( i > 0 &&  main.get(i) == main.get(i - 1)){
                continue;
            }
            int val = main.remove(i);
            rslt.add(val);
            permute(main,rslt,length);
            int val2 = rslt.remove(rslt.size() - 1);
            main.add(i,val2);
        }
    }
}
