class Solution {
    public boolean isPalindrome(int x) {
        String A=String.valueOf(x);
        int count=0;
        for(int i=0;i<A.length()/2;i++)
            {
                if(A.charAt(i)==A.charAt(A.length()-i-1))
                    {

                    }
                else
                    {
                        count++;
                    }
            
            }
        if(count==0)
            return true;
        else return false;
        
    }
}
