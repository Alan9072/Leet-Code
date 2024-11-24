class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int size = s.length()/k;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i=i+0){
            for(int j=i;j<i+size;j++){
                sb.append(s.charAt(j));
                
            }
            sb.append(" ");
            i=i+size;
        }
        String[] arr1 = sb.toString().split(" ");
        System.out.println(sb.toString());
        sb.setLength(0);
        for(int i=0;i<t.length();i=i+0){
            for(int j=i;j<i+size;j++){
                sb.append(t.charAt(j));
                
            }
            sb.append(" ");
            i=i+size;
        }
        String[] arr2 = sb.toString().split(" ");
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String val : arr1){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        for(String val : arr2){
            map.put(val,map.getOrDefault(val,0)-1);
        }
        for(int val : map.values()){
            if(val != 0)return false;
        }
        return true;
    }
}
