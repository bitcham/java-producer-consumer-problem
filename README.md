# Producer-Consumer Pattern Implementation 🔄

A Java project demonstrating various implementations of the Producer-Consumer pattern using bounded queues, from basic synchronization to concurrent utilities. 💡

## Features 🛠️
* Multiple queue implementations showing different synchronization approaches
* Thread-safe operations with various waiting strategies 
* Comprehensive logging system
* Configurable execution patterns

## Implementation Versions ✨
1. **Basic Synchronization (V1)** 🔒
  * Uses synchronized methods
  * Implements data loss handling

2. **Wait-Notify Pattern (V2-V3)** ⏳
  * V2: Implements busy waiting
  * V3: Uses wait() and notify() mechanisms 

3. **Lock-Based Implementation (V4-V5)** 🔐
  * V4: Uses Lock and Condition
  * V5: Implements separate conditions for producers/consumers

4. **Modern Concurrent Utilities (V6)** ⚡
  * Uses BlockingQueue implementations
  * Includes timeout and non-blocking operations

## Usage 💻
```java
## Usage 💻
```java
// 1. Select BoundedQueue implementation
//BoundedQueue queue = new BoundedQueueV1(2);
//BoundedQueue queue = new BoundedQueueV2(2);
//BoundedQueue queue = new BoundedQueueV3(2);
//BoundedQueue queue = new BoundedQueueV4(2);
//BoundedQueue queue = new BoundedQueueV5(2);
//BoundedQueue queue = new BoundedQueueV6_1(2);
//BoundedQueue queue = new BoundedQueueV6_2(2);
//BoundedQueue queue = new BoundedQueueV6_3(2);
BoundedQueue queue = new BoundedQueueV6_4(2);

// 2. Choose execution order
producerFirst(queue);  // Producer first
//consumerFirst(queue); // Consumer first
```
## Structure📂

```java
src/
├── producerconsumer/
│   ├── BoundedQueue.java         # Main interface
│   ├── BoundedQueueV1-V6.java   # Different implementations
│   ├── ProducerTask.java        # Producer implementation
│   └── ConsumerTask.java        # Consumer implementation
└── util/
    ├── MyLogger.java            # Logging utility
    └── ThreadUtils.java         # Thread handling utilities
