
class Solution {
    public int maxCoins(int[] piles) {
        int length = piles.length;
        int sum = 0;
        Arrays.sort(piles);
        // for(int i = 0;i<piles.length;i++)
        // {
        //     for(int j = 0;j<piles.length;j++)
        //     {
        //         if(i==j)continue;
        //         if(piles[i]>piles[j])
        //         {
        //             int temp = piles[i];
        //             piles[i] = piles[j];
        //             piles[j] = temp;
        //         }

        //     }
        // }
        for(int i=0;i<(length/3);i++)
        {
            sum+=piles[length - (2*(i+1))];
        }
        return sum;
    }
}
