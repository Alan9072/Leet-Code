class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;
        
        int[] extendedColors = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            extendedColors[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            extendedColors[n + i] = colors[i];
        }
        
        int left = 0;
        for (int right = 1; right < extendedColors.length; right++) {

            if (extendedColors[right] == extendedColors[right - 1]) {
                left = right;
            }

            if (right - left + 1 == k) {
                count++;
                left++; 
            }
        }
        
        return count;
    }
}
