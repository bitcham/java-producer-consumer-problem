package producerconsumer;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMain {

    public static void main(String[] args) {
        // 1. Select BoundedQueue
        //BoundedQueue queue = new BoundedQueueV1(2);
        //BoundedQueue queue = new BoundedQueueV2(2);
        //BoundedQueue queue = new BoundedQueueV3(2);
        //BoundedQueue queue = new BoundedQueueV4(2);
        //BoundedQueue queue = new BoundedQueueV5(2);
        //BoundedQueue queue = new BoundedQueueV6_1(2);
        //BoundedQueue queue = new BoundedQueueV6_2(2);
        //BoundedQueue queue = new BoundedQueueV6_3(2);
        BoundedQueue queue = new BoundedQueueV6_4(2);

        // 2. Select execution order of producer and consumer, choose only one!
        producerFirst(queue); // Producer first
        //consumerFirst(queue); // Consumer first
    }

    private static void producerFirst(BoundedQueue queue) {
        log("== [ProducerFirst Execution] Start, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
        printAllState(queue, threads);
        startConsumer(queue, threads);
        printAllState(queue, threads);
        log("== [ProducerFirst Execution] End, " + queue.getClass().getSimpleName() + " ==");
    }

    private static void consumerFirst(BoundedQueue queue) {
        log("== [ConsumerFirst Execution] Start, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);
        printAllState(queue, threads);
        startProducer(queue, threads);
        printAllState(queue, threads);
        log("== [ConsumerFirst Execution] End, " + queue.getClass().getSimpleName() + " ==");
    }

    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("Producer Start");
        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("Consumer Start");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100);
        }
    }

    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("Current state output, queue data: " + queue);
        for (Thread thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }


}
