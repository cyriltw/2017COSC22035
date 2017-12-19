package FIS;

/**
 * CalculatePrimes -- calculate as many primes as we can in ten seconds
 */

public class primeCalc extends Thread {

    public static final int MAX_PRIMES = 1000000;
    public static final int TEN_SECONDS = 100;

    public volatile boolean finished = false;
    public int startCount = 2;

    public void run() {
        int[] primes = new int[MAX_PRIMES];
        int count = 0;

        for (int i=startCount; count<MAX_PRIMES; i++) {

            // Check to see if the timer has expired
            if (finished) {
                break;
            }

            boolean prime = true;
            for (int j=0; j<count; j++) {
                if (i % primes[j] == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes[count++] = i;

                //System.out.println("Found prime: " + i);
            }

        }
        System.out.println("Final Count"+primes[count-1]);
        startCount = primes[count-1];
    }

    public static void main(String[] args) {
        primeCalc calculator = new primeCalc();
        calculator.start();
        try {
            Thread.sleep(TEN_SECONDS);
        }
        catch (InterruptedException e) {
            // fall through
        }

        //calculator.finished = true;
        System.out.println("Try 2");
        try {
            Thread.sleep(TEN_SECONDS);
        }
        catch (InterruptedException e) {
            // fall through
        }
        calculator.finished = true;
    }
}
