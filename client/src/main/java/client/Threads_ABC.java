package client;

public class Threads_ABC {
    private final Object MON = new Object();
    private final int NUM = 5;
    private volatile char currentChar = 'A';

    public static void main(String[] args) {

        Threads_ABC abc = new Threads_ABC ();

        new Thread(() -> {
            abc.printA();
        }).start();
        new Thread(() -> {
            abc.printB();
        }).start();
        new Thread(() -> {
            abc.printC();
        }).start();
    }

    public void printA() {
        synchronized (MON) {
            try {
                for (int i = 0; i < NUM; i++) {
                    while (currentChar != 'A') {
                        MON.wait ();
                    }
                    System.out.print ("A");
                    currentChar = 'B';
                    MON.notifyAll ();
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    public void printB() {
        synchronized (MON) {
            try {
                for (int i = 0; i < NUM; i++) {
                    while (currentChar != 'B') {
                        MON.wait ();
                    }
                    System.out.print ("B");
                    currentChar = 'C';
                    MON.notifyAll ();
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
    public void printC() {
        synchronized (MON) {
            try {
                for (int i = 0; i < NUM; i++) {
                    while (currentChar != 'C') {
                        MON.wait ();
                    }
                    System.out.print ("C ");
                    currentChar = 'A';
                    MON.notifyAll ();
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }

    }
}
