class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] list = new int[nums1.length + nums2.length];
        for(int i=0;i<nums1.length;i++)
        {
            list[i]=nums1[i];
        }
        int length = nums1.length;
         for(int i=0;i<nums2.length;i++)
        {

            list[length]=nums2[i];
            length++;
        }
       
        Arrays.sort(list);
        if(list.length%2 == 0)
        {
            return (double) (list[list.length/2] + list[list.length/2-1])/2;
        }
        else{
            return (double) list[list.length/2];
        }

    }
}
