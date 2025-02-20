import java.util.ArrayList;
import java.util.List;

class Buffer {
    private final List<Integer> data = new ArrayList<>();
    private final Object lock = new Object();
    
    public  void put(int value) {
        synchronized (lock) {
            if(data.size()<=100){
                data.add(value);
                System.out.println("Inserted: " + value + " | Buffer size: " + data.size());
            }
        }
    }
    
    public synchronized int remove() {
        synchronized (lock) {
            if (!data.isEmpty()) {
                int value = data.remove(0);
                System.out.println("Removed: " + value + " | Buffer size: " + data.size());
                return value;
            }
            return -1;
        }
        
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
