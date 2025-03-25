class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        //horizontal part
        System.out.println("Horizontal");
        Arrays.sort(rectangles,(a,b)->a[0] - b[0]);
        int laste = rectangles[0][2];
        int lastf = rectangles[0][0];
        int cut = 0;
        for(int i=1;i<rectangles.length;i++){
            int curre = rectangles[i][2];
            int currf = rectangles[i][0];
            if(laste <= curre && laste > currf || curre < laste && curre >= lastf){//overlaps
                System.out.println(i + "   overlaps");
                if(laste < curre){
                    lastf = currf;
                    laste = curre;
                }
            }else{
                System.out.println(i + "   cuts");
                cut++;
                lastf = currf;
                laste = curre;
                if(cut == 2)return true;
            }

        }
        //vertical
        System.out.println("Vertical");
        Arrays.sort(rectangles,(a,b)->a[1] - b[1]);
        laste = rectangles[0][3];
        lastf = rectangles[0][1];
        cut = 0;
        for(int i=1;i<rectangles.length;i++){
            int curre = rectangles[i][3];
            int currf = rectangles[i][1];
            if(laste <= curre && laste > currf || curre < laste && curre >= lastf){//overlaps
                System.out.println(i + "   overlaps");
                if(laste < curre){
                    lastf = currf;
                    laste = curre;
                }
            }else{
                System.out.println(i + "   cuts");
                cut++;
                lastf = currf;
                laste = curre;
                if(cut == 2)return true;
            }

        }
        return false;
    }
}
