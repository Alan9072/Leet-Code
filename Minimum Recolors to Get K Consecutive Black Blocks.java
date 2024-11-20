class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = k, whiteCount = 0, left = 0;

        for (int right = 0; right < k; right++) {
            if (blocks.charAt(right) == 'W') whiteCount++;
        }

        for (int right = k; right <= blocks.length(); right++) {
            min = Math.min(min, whiteCount);

            if (right == blocks.length()) break;

            if (blocks.charAt(right) == 'W') whiteCount++;
            if (blocks.charAt(left) == 'W') whiteCount--;
            left++;
        }

        return min;
    }
}
