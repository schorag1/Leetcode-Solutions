class Vector2D {
    int[][] data;
    int rows, row, col;
    
    public Vector2D(int[][] v) {
        this.data = v;
        rows = v.length;
        row = 0;
        col = 0;
    }
    
    public int next() {
        if(hasNext()){
            return data[row][col++];
        }
        
        return -1;
    }
    
    public boolean hasNext() {
        while(row < rows){
            if(col < data[row].length)
                return true;
            
            row++;
            col = 0;
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */