class Solution {
    List<List<String>> mainList = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        List<String> sub = new ArrayList<>();
        part(s,sub,new StringBuilder(""));
        return mainList;
    }
    public void part(String s,List<String> sub,StringBuilder subS){
        if(s.length() == 0){
            mainList.add(new ArrayList<>(sub));
            return;
        }
        for(int i=0;i<s.length();i++){
            subS.append(s.charAt(i));
            String newString = s.substring(i+1);
            if(isPal(subS.toString())){
                sub.add(subS.toString());
                part(newString,sub,new StringBuilder(""));
                sub.remove(sub.size() - 1);
                
            }
        }
    }
    public boolean isPal(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
