class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        
        if (n.charAt(0) == '-') {  
            int flag = 0;
            sb.append('-'); 
            
            for (int i = 1; i < n.length(); i++) {  
                if (flag == 0 && n.charAt(i) - '0' > x) {  
                    sb.append(x);
                    flag = 1;
                }
                sb.append(n.charAt(i));
            }

            if (flag == 0) {  
                sb.append(x);
            }
            
            return sb.toString();
        } else {  
            int flag = 0;
            for (int i = 0; i < n.length(); i++) {
                if (flag == 0 && n.charAt(i) - '0' < x) {  
                    sb.append(x);
                    flag = 1;
                }
                sb.append(n.charAt(i));
            }

            if (flag == 0) {  
                sb.append(x);
            }

            return sb.toString();
        }
    }
}
