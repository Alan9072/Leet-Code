class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> mainList = new ArrayList<>();
        
        mainList.add(new ArrayList<>(Arrays.asList(1)));
        int curr = 2;
        while(curr <= rowIndex + 1){
            List<Integer> sub = new ArrayList<>();
            List<Integer> prev = mainList.get(mainList.size() - 1);
            for(int i=0;i<curr;i++){
                if(i == 0 || i == curr - 1){
                    sub.add(1);
                }
                else{
                    int sum = prev.get(i - 1)+prev.get(i);
                    sub.add(sum);
                }
            }
            mainList.add(sub);
            curr++;
        }
        return mainList.get(mainList.size() - 1);
    }
}
