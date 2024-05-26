class Solution {
    public boolean checkIfPangram(String sentence) {
        ArrayList<Character> abc = new ArrayList<>();
        int sum = 0;
        abc.add(sentence.charAt(0));
        sum = sum + (int) sentence.charAt(0);
        for(int i = 0;i<sentence.length();i++)
        {
            if(!abc.contains(sentence.charAt(i)))
            {
                abc.add(sentence.charAt(i));
                sum+=(int) sentence.charAt(i);
            }
        }
        if(sum == 2847){
             return true;
        }
            
       return false;
    }
}