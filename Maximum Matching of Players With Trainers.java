class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        int start = 0;
        for(int i=0;i<players.length;i++){
            int curr = players[i];
            while(start < trainers.length && trainers[start] < curr){
                start++;
            }
            if(start != trainers.length){
                count++;
                start++;
            }
        }
        return count;
    }
}
