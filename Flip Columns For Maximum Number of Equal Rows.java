class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int max = 0;
        HashMap<String,Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        StringBuilder sbr = new StringBuilder();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                sb.append(matrix[i][j]);
            }
            for(int j=0;j<sb.length();j++){
                if(sb.charAt(j)=='1'){
                        sbr.append('0');
                }else{
                        sbr.append('1');
                }
            }
            String key = sb.toString();
            String keyr = sbr.toString();

            if(!map.containsKey(key)){
                if(!map.containsKey(keyr)){
                    map.put(key,map.getOrDefault(key,0) + 1);
                }else{
                    map.put(keyr,map.getOrDefault(keyr,0) + 1);
                }
            }else{
                 map.put(key,map.getOrDefault(key,0) + 1);
            }
            sb.setLength(0);
            sbr.setLength(0);
        }
        for(int val : map.values()){
            max = Math.max(val,max);
        }
        return max;
        
    }
}
