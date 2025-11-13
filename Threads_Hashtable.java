import java.util.Hashtable;

public class Threads_Hashtable implements Runnable {

    private static final Hashtable<Long, Long> fiboMem = new Hashtable<>();
    private final long fi;
    private final int num;

    static {
        fiboMem.put(0L, 0L);
        fiboMem.put(1L, 1L);
    }

    public FibonacciThreads(int n, long f) {
        this.num = n;
        this.fi = f;
    }

    @Override
    public void run() {
        System.out.println("Iniciando hilo #" + num);
        long res = fibonacci(fi);
        System.out.println("Hilo " + num + " - fibonacci(" + fi + ") = " + res);
    }

    private long fibonacci(long f) {
        if (fiboMem.containsKey(f)) {
            return fiboMem.get(f);
        }

        long value = fibonacci(f - 1) + fibonacci(f - 2);
        fiboMem.put(f, value);
        return value;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long n = (long) (Math.random() * 50) + 1;
            threads[i] = new Thread(new FibonacciThreads(i, n));
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}
//Eckhardt Alvarez Ian. 12/11/2025
