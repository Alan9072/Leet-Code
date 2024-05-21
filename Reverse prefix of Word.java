class Solution 
{
    public String reversePrefix(String word, char ch) 
    {
        int length = word.length();
        String remain = "";
        String frontportion = "";
        int location;
        int present = 0;

        char abc[] = word.toCharArray();
        for (int i = 0; i < length; i++) 
        {
            if (abc[i] == ch) 
            {
                present = 1;
                location = i;
                for (int j = location + 1; j < length; j++) {
                    remain = remain + abc[j];
                }

                for (int j = 0; j <= location; j++) {
                    frontportion = frontportion + abc[location - j];

                }
                return frontportion + remain;

            } 
        }
    return word;
    }
}
