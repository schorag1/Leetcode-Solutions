public class ZigzagIterator {
    List<List<Integer>> list;
    Queue<Integer> buffer;
    int i;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        
        buffer = new LinkedList<>();
        i = 0;
    }

    public int next() {
        if(!hasNext())
            return -1;
        
        if(!buffer.isEmpty())
            return buffer.poll();
        
        for(List<Integer> temp: list){
            if(i < temp.size())
                buffer.add(temp.get(i));
        }
        
        i++;
        
        return next();
    }

    public boolean hasNext() {
        if(!buffer.isEmpty())
            return true;
        
        for(List<Integer> temp: list){
            if(i < temp.size())
                return true;
        }
        
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */