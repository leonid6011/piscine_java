package ex02;

public class Program {

    private static int[] resultOfThreads;
    public static void calcutateArraySolo(int[] array) {
        long mainResult = 0;
        for (int j : array) {
            mainResult += j;
        }
        System.out.println("Sum: " + mainResult);
    }
    public static class ThreadCount extends Thread {
        int start;
        int last;
        int i;
        int[] array;

        public ThreadCount(int start, int last, int i, int[] array) {
            this.start = start;
            this.last = last;
            this.i = i;
            this.array = array;
        }

        @Override
        public void run() {
            int indexStart = start;
            int indexStop = start + last;
            for (int j = indexStart; j < indexStop; j++) {
                resultOfThreads[i] += array[j];
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.err.println("Invalid arguments! (!= 2)");
            return;
        }
        int arraySize = 0;
        if (args[0].startsWith("--arraySize="))
            arraySize = Integer.parseInt(args[0].substring(12));
        else {
            System.err.println("Invalid array size!");
            return;
        }
        if (arraySize > 2000000 || arraySize < 0) {
            System.err.println("Invalid array size!");
            return;
        }
        int threadsCount = 0;
        if (args[1].startsWith("--threadsCount="))
            threadsCount = Integer.parseInt(args[1].substring(15));
        else {
            System.err.println("Invalid threads count!");
            return;
        }
        if (threadsCount > arraySize || threadsCount < 0) {
            System.err.println("Invalid threads count!");
            return;
        }

        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int)(Math.random() * 10);
        }

        calcutateArraySolo(array);

        int countSubArrays = arraySize / threadsCount;
        int correct = arraySize % threadsCount;
        int lastSubArrays = countSubArrays + correct;

        int sumSubArrays = 0;
        resultOfThreads = new int[threadsCount];
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            if (i + 1 != threadsCount) {
                threads[i] = new Thread(new ThreadCount(sumSubArrays, countSubArrays, i, array));
                sumSubArrays += countSubArrays;
            }
            else
                threads[i] = new Thread(new ThreadCount(sumSubArrays, lastSubArrays, i, array));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int finalResult = 0;
        int start = 0;
        for (int k = 0; k < resultOfThreads.length; k++) {
            finalResult += resultOfThreads[k];
            if (k + 1 != resultOfThreads.length)
                System.out.println("Thread " + (k + 1) + ": from " + start + " to " +  (start + countSubArrays) + " sum is " + resultOfThreads[k]);
            else {
                System.out.println("Thread " + (k + 1) + ": from " + start + " to " + (start + lastSubArrays - 1) + " sum is " + resultOfThreads[k]);
                break;
            }
            start += countSubArrays;
        }
        System.out.println("Sum by threads: " + finalResult);
    }
}
