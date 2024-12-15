class newType {
    double change;
    int pass;
    int total;

    newType(double change, int pass, int total) {
        this.change = change;
        this.pass = pass;
        this.total = total;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<newType> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.change - a.change > 0)
                return 1;
            else if (b.change - a.change < 0)
                return -1;
            else {
                return 0;
            }
        });
        for (int arr[] : classes) {
            double change = calculateChange(arr[0], arr[1]);
            maxHeap.add(new newType(change, arr[0], arr[1]));
        }
        while (extraStudents > 0) {
            newType val = maxHeap.poll();
            double newChange = calculateChange(val.pass + 1, val.total + 1);
            val.change = newChange;
            val.pass = val.pass + 1;
            val.total = val.total + 1;
            maxHeap.add(val);
            extraStudents--;
        }
        double sum = 0;
        while(!maxHeap.isEmpty()){
            newType curr = maxHeap.poll();
            sum += (curr.pass/(double)curr.total);
        }
        return sum/(double)classes.length;
        
    }

    public double calculateChange(int val1, int val2) {
        return ((val1 + 1) / (double) (val2 + 1)) - (val1 / (double) val2);
    }
}
