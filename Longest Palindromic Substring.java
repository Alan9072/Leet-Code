class Solution {
    public String longestPalindrome(String s) {
       
        String longestString = "";
        for(int i = 0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                String abc = s.substring(i,j+1);
                int length = abc.length();
                int condition = 0;
                for(int k=0;k<length/2;k++)
                {
                    if(abc.charAt(k)!=abc.charAt(length-k-1))
                    {
                        condition++;
                        break;
                    }

                }
                if(condition == 0)
                {
                     if (abc.length() > longestString.length()) {
                            longestString = abc;
                        }
                }
            }
        }
        
       return longestString; 
    }
}
