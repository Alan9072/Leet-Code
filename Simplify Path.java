class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String arr[] = path.split("/");

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("") || arr[i].equals("."))continue;
            if(arr[i].equals("..")){
                if(!stk.isEmpty()){
                    stk.pop();
                }
            }else{
                stk.push(arr[i]);
            }
        }

        while(!stk.isEmpty()){
            String curr = stk.pop();
            sb.insert(0,curr);
            sb.insert(0,"/");
        }
        
        if(sb.length() == 0)sb.append("/");
        return sb.toString();
    }
}
