class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);  
        int median=arr[(arr.length-1)/2];
        int i=0;
        int j=arr.length-1;
        int res=0;
        int[] result=new int[k];
        while(res<k)
        {
		//while loop will stop after we hace chosen the k greatest elements.
            if(Math.abs(arr[i]-median)>Math.abs(arr[j]-median))
            {
                result[res]=arr[i];
                i++;
                res++;
            }
            else{
                result[res]=arr[j];
                j--;
                res++;
            }
        }
        return result;
        
    }
}
