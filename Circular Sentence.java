class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            String current = arr[i];
            String next = arr[(i + 1) % n];
            if (current.charAt(current.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        
        return true;
    }
}
