class Bank {
    Map<Integer,Long> map;
    public Bank(long[] balance) {
        map = new HashMap<>();

        for(int i=0;i<balance.length;i++){
            map.put(i+1,balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(isValid(account1) && isValid(account2)){
            if(map.get(account1) >= money){
                map.put(account1,map.get(account1) - money);
                map.put(account2,map.get(account2) + money);
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(isValid(account)){
            map.put(account,map.get(account) + money);
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(isValid(account)){
            if(map.get(account) >= money){
                map.put(account,map.get(account) - money);
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean isValid(int acc){
        return map.containsKey(acc);
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
