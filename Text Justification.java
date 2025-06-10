class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        LinkedList<String> q = new LinkedList<>();

        int index = 0;
        while (index < words.length) {
            int word = 0;
            int length = 0;

            while (index < words.length && (length + word - 1) < maxWidth) {

                String curr = words[index];
                q.add(curr);
                length += curr.length();
                word++;
                index++;
            }

            StringBuilder sb = new StringBuilder();
            if ((length + word - 1) >= maxWidth) {
                //in between
                if ((length + word - 1) > maxWidth) {
                    index--;
                    word--;
                    length -= words[index].length();
                    q.removeLast();
                }
                
                int rem = maxWidth - length;
                int extra = 0;
                int space = 0;

                if (word >= 2) {
                    space = rem / (word - 1);
                    extra = rem % (word - 1);

                    int limit = word - 1;
                    while (limit > 0) {
                        String curr = q.remove();
                        sb.append(curr);
                        int val = space;
                        while (val > 0) {
                            sb.append(" ");
                            val--;
                        }
                        if (extra > 0) {
                            sb.append(" ");
                            extra--;
                        }
                        limit--;
                    }
                    sb.append(q.remove());

                } else {
                    sb.append(q.remove());
                    int start = length;

                    while (start < maxWidth) {
                        sb.append(" ");
                        start++;
                    }
                }
            } else if (index >= words.length) {
                while (!q.isEmpty()) {
                    sb.append(q.remove());
                    if (sb.length() + 1 <= maxWidth) {
                        sb.append(" ");
                    }
                }
                int start = sb.length();
                while (start < maxWidth) {
                    sb.append(" ");
                    start++;
                }

            }
            result.add(sb.toString());
        }
        return result;
    }
}
