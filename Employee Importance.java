/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee val : employees){
            map.put(val.id,val);
        }

        return dfs(map,id);
    }
    public int dfs(HashMap<Integer,Employee> map,int id){

        Employee curr = map.get(id);
    
        int sum = 0;
        for(int val : curr.subordinates){
            sum += dfs(map,val);
        }
        return sum + curr.importance;
    }
}
