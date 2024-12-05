class Solution {
    public boolean canChange(String start, String target) {
        int strt = -1;
        int targstrt = 0;

        int lcount = 0;
        int rcount = 0;
        for (int i = 0; i < start.length(); i++) {
            char ch = start.charAt(i);
            if (ch == 'L')
                lcount++;
            if (ch == 'R')
                rcount++;
            char dh = target.charAt(i);
            if (dh == 'L')
                lcount--;
            if (dh == 'R')
                rcount--;

        }

        if (lcount != 0 || rcount != 0)
            return false;
        while (targstrt < target.length()) {
            if (target.charAt(targstrt) == '_') {
                targstrt++;

            } else if (target.charAt(targstrt) == 'L') {
                boolean found = false;
                if (strt == start.length())
                    return false;
                if (strt < targstrt) {
                    strt = targstrt;

                }

                while (strt < target.length()) {

                    if (start.charAt(strt) == 'L') {
                        found = true;
                        strt++;
                        break;
                    }
                    if (start.charAt(strt) == 'R') {
                        return false;
                    }
                    strt++;
                }
                if (found == false)
                    return false;
                targstrt++;
                
            } else if (target.charAt(targstrt) == 'R') {
                boolean found = false;
                if (strt == -1) {
                    strt = 0;
                }
                while (strt <= targstrt) {
                    if (start.charAt(strt) == 'R') {
                        found = true;
                        strt++;
                        break;
                    }
                    if (start.charAt(strt) == 'L') {
                        return false;
                    }
                    strt++;
                }
                if (found == false)
                    return false;
                targstrt++;
            }

        }
        return true;
    }
}
