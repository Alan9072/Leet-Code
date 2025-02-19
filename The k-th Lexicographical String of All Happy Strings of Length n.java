class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a', 'b', 'c'};
        isHappy(sb,list,n,arr);
        if(k > list.size())return "";
        else{
            return list.get(k-1);
        }
    }
    public void isHappy(StringBuilder sb,List<String> list,int n,char[] arr){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != arr[i]){
                sb.append(arr[i]);
                isHappy(sb,list,n,arr);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
