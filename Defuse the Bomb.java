class Solution {
    public int[] decrypt(int[] code, int k) {
        int result[] = new int[code.length];

        if(k > 0){
            int sum = 0;
            int pos = 0;
            for(int i=0;i<k;i++){
                sum += code[i];
                pos++;
            }
            for(int i=0;i<code.length;i++){
                sum += code[pos];
                sum -= code[i];
                result[i] = sum;
                pos = (pos + 1) % code.length;
            }
            
        }
        if(k < 0){
            int sum = 0;
            int pos = code.length - 1;
            for(int i=0;i<Math.abs(k);i++){
                sum+=code[pos];
                pos = (pos - 1 + code.length) % code.length;
            }
            pos = (pos + 1) % code.length;
 
            for(int i=0;i<code.length;i++){
                int val = code[i];
                
                result[i] = sum;
                sum += val;
                sum -= code[pos];
                pos = (pos + 1) % code.length;
            }
        }
        if( k == 0){
            for(int i=0;i<code.length;i++){
                result[i] = 0;
            }
        }
        return result;
    }
}
