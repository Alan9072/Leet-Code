class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,n,list);
        }
        return list;
    }
    public void dfs(int val,int limit,List<Integer> list){
        if(val > limit)return;

        list.add(val);
        for(int i=0;i<=9;i++){
            dfs(val * 10 + i,limit,list);
        }
    }
}
