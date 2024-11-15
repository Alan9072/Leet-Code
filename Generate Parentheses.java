class Solution {
    List<String> mainList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("");
        generate(sb, n, n);
        return mainList;
    }

    public void generate(StringBuilder sb, int open, int close) {
        if (open == 0 && close == 0) {
            StringBuilder a = new StringBuilder(sb);
            mainList.add(a.toString());
            return;
        }
        if (open < close) {

            if (open != 0) {
                sb.append("(");
                generate(sb, open - 1, close);
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(")");
            generate(sb, open, close - 1);
            sb.deleteCharAt(sb.length() - 1);

        }

        if (open == close) {
            sb.append("(");
            generate(sb, open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
