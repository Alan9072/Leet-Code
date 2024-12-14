class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> mainList = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }

        for(int key : map.keySet()){
            if(map.get(key).size() == key){
                mainList.add(map.get(key));
            }else{
                int index = 0;
                for(int i=0;i<map.get(key).size() / key;i++){
                    List<Integer> subList = new ArrayList<>();
                    while(index < key * (i+1)){
                        subList.add(map.get(key).get(index));
                        index++;
                    }
                    mainList.add(subList);
                    
                }
            }
        }
        return mainList;

    }
}
