class Solution {
    List<String> mainlist = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        if(digits.isEmpty()){
            return mainlist;
        }
        
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder sb = new StringBuilder("");
        letter(digits,map,sb);
        return mainlist;
    }
    public void letter(String digits,HashMap<Character,String> map,StringBuilder list){
        
        if(digits.length() == 0){
            mainlist.add(list.toString());
            return;
        }
        
        String word = map.get(digits.charAt(0));
        String newW = digits.substring(1);

        for(int i=0;i<word.length();i++){
            char sub = word.charAt(i);
            letter(newW,map,list.append(sub));
            list.deleteCharAt(list.length() - 1);
        }
    }
}
