package ex01;

public class Program {
    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            throw new Exception("Invalid number arguments");
        if (args[0] != null && !args[0].isEmpty()) {
            int count;
            if (args[0].startsWith("--count=")) {
                count = Integer.parseInt(args[0].substring(8));
                if (count < 0)
                    throw new Exception("Invalid input");

                ThreadFunEgg egg = new ThreadFunEgg();
                ThreadFunHen hen = new ThreadFunHen();

                egg.startThread(count, "Egg");
                hen.startThread(count, "Hen");
                egg.start();
                hen.start();
                egg.join();
                hen.join();
            }
        }
    }
    public static synchronized void printThread(String name) {
        Program.class.notify();
        System.out.println(name);
        try {
            Program.class.wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Program.class.notify();
    }

    static class ThreadFunEgg extends Thread {
        private int count;
        private String name;

        public void startThread(int count, String name) {
            this.count = count;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++)
                printThread(this.name);
        }
    }
    static class ThreadFunHen extends Thread {
        private int count;
        private String name;

        public void startThread(int count, String name) {
            this.count = count;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++)
                printThread(this.name);
        }
    }
}
