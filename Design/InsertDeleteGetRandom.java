class RandomizedSet {

    Map<Integer,Integer> hash;
    List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hash.containsKey(val))
            return false;
        
        list.add(val);
        hash.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hash.containsKey(val))
            return false;
        
        int index = hash.get(val);
        Collections.swap(list, index, list.size()-1);
        
        int temp = list.get(index);
        hash.put(temp, index);
        
        list.remove(list.size()-1);
        hash.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */