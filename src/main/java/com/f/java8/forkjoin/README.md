ForkJoinPool 默认创建的线程池数量是 JVM 能够获得所有处理器线程数量

* 对一个任务调用 join 回阻塞调用方法，直到该任务结束
* 不应该在 RecursiveTask 内部使用 ForkJoinPool 的 invoke 方法。你应该直接调用 compute 或 fork，只有顺序代码才应该调用 invoke
* 对子任务调用 fork 方法能够把子任务压入 ForkJoinPool。同时对左右两边调用 fork 回降低速度，因为你回在线程池中多分配一个任务。  
应该只对其中一个调用 fork，另一个任务就用当前线程去执行，而不是再分配一个任务
