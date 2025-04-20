class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
        }

        int[] count = new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) != guess.charAt(i)){
                char ch = secret.charAt(i);
                count[ch - '0']++;
            }
        }
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) != guess.charAt(i)){
                char ch = guess.charAt(i);
                if(count[ch - '0'] > 0){
                    count[ch - '0']--;
                    cows++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }
}
