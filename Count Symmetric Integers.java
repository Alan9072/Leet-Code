class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low;i<=high;i++){
            
            String curr = String.valueOf(i);
            if(curr.length() % 2 == 0){
                int mid = curr.length() / 2;
                String first = curr.substring(0,mid);
                String second = curr.substring(mid);
                int firstV = 0;
                for(int j=0;j<first.length();j++){
                    firstV += Integer.valueOf(first.charAt(j));
                }

                int secondV = 0;
                for(int j=0;j<second.length();j++){
                    secondV += Integer.valueOf(second.charAt(j));
                }
               
                if(firstV == secondV)count++;
            }

        }
        return count;
    }
}
