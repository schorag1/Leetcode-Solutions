class RandomizedCollection {
    Map<Integer, Set<Integer>> hash;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        hash = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        
        if(!hash.containsKey(val)){
            hash.put(val, new HashSet<Integer>());
            hash.get(val).add(list.size()-1);
            return true;
        }
        
        else{
            hash.get(val).add(list.size()-1);
            return false;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!hash.containsKey(val))
            return false;
        
        int index = hash.get(val).iterator().next();
        hash.get(val).remove(index);
        
        if(index < list.size() - 1){
            int lastNum = list.get(list.size() - 1);
            list.set(index, lastNum);
            
            hash.get(lastNum).remove(list.size() - 1);
            hash.get(lastNum).add(index);
        }
        
        list.remove(list.size() - 1);
        
        if(hash.get(val).isEmpty())
            hash.remove(val);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */