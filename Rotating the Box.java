class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] result = new char[box[0].length][box.length];
        for(int i=0;i<box.length;i++){
            for(int j=box[0].length - 1;j>=0;j--){
                if(box[i][j] == '.' && j>0){
                    int left = j;
  
                    while(left > 0 ){
                        left --;
                        if(box[i][left] =='*'){
                            j = left;
                            break;
                        }
                        else if(box[i][left] == '#'){
                            char temp = box[i][j];
                            box[i][j] = box[i][left];
                            box[i][left] = temp;
                            j--;

                        }
                    }
                }
            }
        }
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                result[i][j] = box[box.length-1-j][i];
            }
        }
       return result;
    }
}

/////////////////////////////////////////////////////////////////////////////////////


class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] result = new char[box[0].length][box.length];
        for(int i=0;i<box.length;i++){
            int right = -1;
            int left = box[0].length - 1;
            while(left >= 0){

                if(box[i][left] == '.' && right < 0){
                    right = left;
                }else if(box[i][left] == '#' && right >= 0){
                    box[i][left] = '.';
                    box[i][right] = '#';
                    right--;
                }else if(box[i][left] == '*'){
                    right = -1;
                }
                left--;
            }
        }
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                result[i][j] = box[box.length-1-j][i];
            }
        }
       return result;
    }
}
