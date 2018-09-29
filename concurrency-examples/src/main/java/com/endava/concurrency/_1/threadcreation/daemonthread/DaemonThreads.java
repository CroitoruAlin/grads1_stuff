package com.endava.concurrency._1.threadcreation.daemonthread;

public class DaemonThreads {

    static class MyThread extends Thread {
        private String threadName;
        private int max;

        public MyThread(String threadName, int max) {
            this.threadName = threadName;
            this.max = max;
        }

        @Override
        public void run() {
            for (int i = 0; i < max; i++) {
                System.out.println(threadName + " Thread Reached " + i);
            }
            System.out.println(threadName + " Thread finished");
        }
    }


    public static void main(String[] args) {
        Thread daemonThread = new MyThread("Daemon", 50000);
        daemonThread.setDaemon(true); // mark thread as daemon thread before starting it

        Thread regularThread = new MyThread("Regular", 4000);

        regularThread.start();
        daemonThread.start();


        // main thread is finished
        // will remain only Regular Thread to complete it's execution

        // the java program will stop when there are only daemon threads remaining
        // daemon threads will not be awaited by the JVM to complete their execution
    }
}
