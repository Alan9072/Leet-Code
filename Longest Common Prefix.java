class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs[0].length();
        for(int i = 0;i<strs.length;i++)
        {
          if(strs[i].length() < length)
              length = strs[i].length();
        }
        String common="";
        int b = 0;
        if(strs.length == 0)
        {
            return common;
        }
        else{
            
             for(int i=0;i<length;i++)
            {
                 char abc = strs[0].charAt(i);
                for(int j = 0;j<strs.length;j++)
                {
                    if(strs[j].charAt(i)==abc)
                    {
                        continue;
                    }
                    else{
                        b = 1;
                        break;
                    }
                       
                }
                 if(b == 1)
                     break;
                 else{
                     common+=abc;
                 }
            }
        }
       return common;
    }
}
