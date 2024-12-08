class word{
    String word;
    int val;

    word(String word,int val){
        this.word = word;
        this.val = val;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Queue<word> q = new LinkedList<>();
        q.add(new word(startGene,1));

        HashSet<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            word curr = q.remove();
            for(String val : bank){
                if(!visited.contains(val) && check(curr.word,val)){
                    if(val.equals(endGene))return curr.val;
                    q.add(new word(val, curr.val + 1));
                    visited.add(val);
                }
            }
        }
        return -1;
    }
    public boolean check(String curr,String val){
        int changes = 0;
        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i) != val.charAt(i)){
                changes++;
                if(changes > 1)return false;
            }
        }
        return true;
    }
}
