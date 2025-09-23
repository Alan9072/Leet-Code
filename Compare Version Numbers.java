class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");

        int min = Math.min(arr1.length,arr2.length);

        int i=0;
        for(i=0;i<min;i++){
            int a = Integer.parseInt(arr1[i]);
            int b = Integer.parseInt(arr2[i]);

            if(a > b)return 1;

            if(b > a)return -1;
        }

        while(i < arr1.length){// for arr1
            if(Integer.parseInt(arr1[i]) > 0)return 1;
            i++;
        }
        while(i < arr2.length){// for arr1
            if(Integer.parseInt(arr2[i]) > 0)return -1;
            i++;
        }

        return 0;


    }
}
