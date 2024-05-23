class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=left;i<=right;i++)
        {
            int number = i;
            int realnumber = number;
            boolean isSelf = true;
            int rem;
            while(number>0)
            {   
                
                rem = number%10;
                if(rem<=0)
                {
                    isSelf = false;
                    break; 
                }
                   
                if((realnumber%rem)!= 0)
                {
                    isSelf = false;
                    break;
                }
              
                number=number/10;
            }
         if(isSelf)
         {
             list.add(i);
         }
 
        }
    return list;
    }
}
