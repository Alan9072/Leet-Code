class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Arrays.sort(folder);

        for(int i=0;i<folder.length;i++){
            String curr = folder[i];
            result.add(curr);

            int idx = i + 1;
            while(idx < folder.length && folder[idx].length() >= curr.length()){
                String next = folder[idx] + "/";
                if(next.substring(0,curr.length() + 1).equals(curr + "/")){
                    i++;
                    idx++;
                }else{
                    break;
                }
            }
        }
        return result;

        

    }
}
