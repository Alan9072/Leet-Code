class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int differences = 0;
        int pos1 = 0;
        int pos2 = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                differences++;

                if(differences > 2)return false;
                if(differences == 1)pos1 = i;
                if(differences == 2)pos2 = i;
            }
        }
        if(differences == 2){
            if(s2.charAt(pos1) == s1.charAt(pos2)  && s1.charAt(pos1) == s2.charAt(pos2) )return true;
        }else if(differences == 0)return true;
        return false;
    }
}
