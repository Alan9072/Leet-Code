class Solution {
    public int lengthOfLastWord(String s) {
        int length=s.length();
        int start=0;
        int stop=0;
        int count=0;
        
        for(int i=length-1;i>=0;i--)
            {
                if(s.charAt(i)== ' ')
                {
                    }
                else
                    { start=i;
                    break;
                    }
            }
        for(int i=start;i>=0;i--)
            {
                if(s.charAt(i)!= ' ')
                    count++;
                else
                    break;

            }
        return count;
        
    }
}
