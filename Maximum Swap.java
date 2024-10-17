class Solution {
    public int maximumSwap(int num) {
        char arr[] = String.valueOf(num).toCharArray();
        int greatest = num;
        for(int i=0;i<arr.length;i++){
            int currval = num;
            for(int j=arr.length - 1;j>i;j--){
                if(Integer.parseInt(String.valueOf(arr[i])) < Integer.parseInt(String.valueOf(arr[j]))){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    if(Integer.parseInt(String.valueOf(arr)) > currval){
                        currval = Integer.parseInt(String.valueOf(arr));
                    };

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
            if(currval > greatest){
                greatest = currval;
            }
        }
        return greatest;
    }
}
