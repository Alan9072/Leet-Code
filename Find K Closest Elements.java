class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            int a = Math.abs(arr[left] - x);
            int b = Math.abs(arr[right] - x);
            
            if (a < b) {
                right--;
            } else if (a > b) {
                left++;
            } else {
                if (arr[left] < arr[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        Collections.sort(result);
        return result;
    }
}
