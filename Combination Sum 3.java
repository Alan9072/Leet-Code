class Solution {
    List<List<Integer>> mainList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinate( k, n, 0, new ArrayList<>(),1);
        return mainList;
    }

    public void combinate( int k, int n, int sum, List<Integer> subList,int number) {
        if (subList.size() == k && sum == n) {
            mainList.add(new ArrayList<>(subList));
            return;
        }

        for (int i = number; i <= 9; i++) {
            int val = i;
            if (sum + val > n) {
                break;
            }
   
            subList.add(i);
            combinate( k, n, sum + i, subList,i + 1);
            subList.remove(subList.size() - 1);
   
        }
    }
}
/////////////////////////////////////////////////


class Solution {
    List<List<Integer>> mainList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        combinate(list, k, n, 0, 0, new ArrayList<>());
        return mainList;
    }

    public void combinate(List<Integer> list, int k, int n, int sum, int index, List<Integer> subList) {
        if (subList.size() == k && sum == n) {
            mainList.add(new ArrayList<>(subList));
            return;
        }
        if(sum > n && subList.size() == k)return;

        for (int i = index; i < list.size(); i++) {
            int val = list.get(i);
            if (sum + val <= n) {
                subList.add(val);
                sum += val;
            }else{
                break;
            }

            list.remove(i);
            combinate(list, k, n, sum, i, subList);
            sum -= subList.remove(subList.size() - 1);
            list.add(i, val);
        }
    }
}
