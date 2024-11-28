package producerconsumer;

public interface BoundedQueue {
    void put(String data);

    String take();
}
