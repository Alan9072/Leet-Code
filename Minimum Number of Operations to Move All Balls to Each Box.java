//////////////////N^2 Solution //////////////////////////
class Solution {
    public int[] minOperations(String boxes) {
    int[] result = new int[boxes.length()];
    HashSet<Integer> set1 = new HashSet<>();
    for(int i=0;i<boxes.length();i++){
        if(boxes.charAt(i) == '1')set1.add(i);
    }
    for(int i=0;i<boxes.length();i++){
        int sum = 0;
        for(int index : set1){
            if(i == index)continue;
            sum += Math.abs(i-index);
        }
        result[i] = sum;
    }
    return result;
}
}
/////////////////O(n) solution ////////////////////////////
class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];

        int sumLeft = 0;
        int leftCount = 0;
        int sumRight = 0;
        int rightCount = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (i == 0)
                continue;
            if (boxes.charAt(i) == '1') {
                rightCount++;
                sumRight += i;
            }
        }

        for (int i = 0; i < boxes.length(); i++) {

            result[i] = sumLeft + sumRight;

            if (boxes.charAt(i) == '1') {
                leftCount++;
            }

            sumLeft += leftCount;

            if (i + 1 < boxes.length() && boxes.charAt(i + 1) == '1') {
                sumRight -= rightCount;
                rightCount--;
            } else {
                sumRight -= rightCount;
            }
        }

        return result;
    }
}
