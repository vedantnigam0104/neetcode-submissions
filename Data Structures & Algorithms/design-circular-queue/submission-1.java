class MyCircularQueue {
    List<Integer> li;
    int size;
    public MyCircularQueue(int k) {
        li=new ArrayList<>(k);

        size=k;
    }
    
    public boolean enQueue(int value) {
        if(li.size()==size)
            return false;

        li.add(value);

        return true;    
    }
    
    public boolean deQueue() {
        if(li.isEmpty())
            return false;

        li.remove(0);

        return true;    
    }
    
    public int Front() {
        return li.isEmpty()?-1:li.get(0);
    }
    
    public int Rear() {
        return li.isEmpty()?-1:li.get(li.size()-1);
    }
    
    public boolean isEmpty() {
        return li.isEmpty();
    }
    
    public boolean isFull() {
        return li.size()==size;
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