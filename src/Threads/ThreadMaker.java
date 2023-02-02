package Threads;

public class ThreadMaker extends Thread {
    public static void behind(Runnable runnable) {
        Thread thread = new Thread();
        thread.start();
    }
}
