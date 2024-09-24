class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        List<Integer> sublist2 = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }

        for(int val : set){
            if(!set2.contains(val)){
                sublist.add(val);
            }
        }
        for(int val : set2){
            if(!set.contains(val)){
                sublist2.add(val);
            }
        }
        
    list.add(sublist);
    list.add(sublist2);
    return list;
    }
}
