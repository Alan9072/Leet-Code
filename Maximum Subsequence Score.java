class Pair {
    int score;
    int min;
    Pair(int score, int min) {
        this.score = score;
        this.min = min;
    }
}

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums1[i], nums2[i]);
        }
        
        Arrays.sort(arr, (a, b) -> b.min - a.min); // sort by nums2 desc
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0, res = 0;
        
        for (Pair p : arr) {
            heap.offer(p.score);
            sum += p.score;
            
            if (heap.size() > k) {
                sum -= heap.poll();
            }
            
            if (heap.size() == k) {
                res = Math.max(res, sum * (long)p.min);
            }
        }
        
        return res;
    }
}
