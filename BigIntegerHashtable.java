import java.math.BigInteger;
import java.util.Hashtable;

public class BigIntegerHashtable implements Runnable {

    private static final Hashtable<BigInteger, BigInteger> fiboMem = new Hashtable<>();
    private final BigInteger fi;
    private final int num;

    static {
        fiboMem.put(BigInteger.ZERO, BigInteger.ZERO);
        fiboMem.put(BigInteger.ONE, BigInteger.ONE);
    }

    public FibonacciThreadsBigInteger(int n, BigInteger f) {
        this.num = n;
        this.fi = f;
    }

    @Override
    public void run() {
        System.out.println("Iniciando hilo #" + num);
        BigInteger res = fibonacci(fi);
        System.out.println("Hilo " + num + " - fibonacci(" + fi + ") = " + res);
    }

    private BigInteger fibonacci(BigInteger f) {
        if (fiboMem.containsKey(f)) {
            return fiboMem.get(f);
        }

        BigInteger f1 = fibonacci(f.subtract(BigInteger.ONE));
        BigInteger f2 = fibonacci(f.subtract(BigInteger.TWO));

        BigInteger value = f1.add(f2);
        fiboMem.put(f, value);
        return value;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long n = (long) (Math.random() * 15000) + 1;
            threads[i] = new Thread(
                new FibonacciThreadsBigInteger(i, BigInteger.valueOf(n))
            );
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}

/// Eckhardt Alvarez Ian. 12/11/2025
