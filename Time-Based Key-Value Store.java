class Pair{
    String val;
    int time;
    Pair(String val,int time){
        this.val = val;
        this.time = time;
    }
}
class TimeMap {
    HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";

        List<Pair> list= map.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time == timestamp) {
                return list.get(mid).val; // exact match
            } else if (list.get(mid).time < timestamp) {
                result = list.get(mid).val; // possible candidate
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
