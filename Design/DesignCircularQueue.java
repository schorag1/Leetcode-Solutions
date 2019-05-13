class MyCircularQueue {
    int a[];
    int front;
    int rear;
    int len;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.a = new int[k];
        this.rear = -1;
        this.len = 0; 
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        
        rear = (rear + 1) % a.length;
        a[rear] = value;
        len++;
        
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        
        front = (front + 1) % a.length;
        len--;
        
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        
        return a[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        
        return a[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == a.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */