class Spreadsheet {
    HashMap<Character,int[]> map;
    public Spreadsheet(int rows) {
        map = new HashMap<>();
        for(char i = 'A';i <= 'Z' ;i++){
            map.put(i,new int[rows + 1]);
            Arrays.fill(map.get(i),0);
        }
    }
    
    public void setCell(String cell, int value) {
        char curr = cell.charAt(0);
        int val = Integer.parseInt(cell.substring(1));
        int[] arr = map.get(curr);
        arr[val] = value;
    }
    
    public void resetCell(String cell) {
        char curr = cell.charAt(0);
        int val = Integer.parseInt(cell.substring(1));
        int[] arr = map.get(curr);
        arr[val] = 0;
    }
    
    public int getValue(String formula) {
        String sub = formula.substring(1);
        String[] arr = sub.split("\\+");
        int sum = 0;
        for(String val : arr){
            if(Character.isLetter(val.charAt(0))){
                sum += findVal(val);
            }else{
                sum += Integer.parseInt(val);
            }
        }
        return sum;
    }
    public int findVal(String val){
        char curr = val.charAt(0);
        int value = Integer.parseInt(val.substring(1));
        int[] arr = map.get(curr);
        return arr[value];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */©leetcode
