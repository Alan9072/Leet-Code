class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        int size = matrix[0].length * matrix.length;

        while (true) {
            for (int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);

            }

            if (list.size() >= size)
                break;

            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);

            }
            if (list.size() >= size)
                break;
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                list.add(matrix[rowEnd][i]);

            }

            if (list.size() >= size)
                break;

            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                list.add(matrix[i][colStart]);

            }

            colStart++;

            if (list.size() >= size)
                break;
        }

        return list;

    }
}
