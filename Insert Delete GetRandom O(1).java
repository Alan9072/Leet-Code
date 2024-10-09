import java.util.*;

class RandomizedSet {
    private HashSet<Integer> set;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            list.add(val);  
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            list.remove((Integer) val); 
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
