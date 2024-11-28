package producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == max) {
            log("[put] Queue is full, producer waiting");
            try {
                wait(); // RUNNABLE -> WAITING, release lock
                log("[put] Producer wakes up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] Producer stores data, calling notify()");
        notify(); // Waiting thread, WAIT -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] Queue is empty, consumer waiting");
            try {
                wait();
                log("[take] Consumer wakes up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = queue.poll();
        log("[take] Consumer acquires data, calling notify()");
        notify(); // Waiting thread, WAIT -> BLOCKED
        return data;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
