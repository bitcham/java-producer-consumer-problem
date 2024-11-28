package producerconsumer;

import static util.MyLogger.log;

public class ConsumerTask implements Runnable {

    private BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[Consumption attempt]     ? <- " + queue);
        String data = queue.take();
        log("[Consumption complete] " + data + " <- " + queue);
    }
}
