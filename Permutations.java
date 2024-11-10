class Solution {
    List<List<Integer>> mainList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> arr = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for( int val : nums){
            arr.add(val);
        }
        findP(arr,curr);
        return mainList;

    }
    public void findP(List<Integer> main,List<Integer> sub){
        if(main.size() == 0){
            mainList.add(new ArrayList<>(sub));
            return;
        }
        for(int i=0;i<main.size();i++){
            int currChar = main.get(i);

            List<Integer> submain = new ArrayList<>(main);
            submain.remove(i);

            sub.add(currChar);

            findP(submain,sub);

            sub.remove(sub.size() - 1);

        }

    }
}
