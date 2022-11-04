package ex00;

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

                ThreadFun egg = new ThreadFun();
                ThreadFun hen = new ThreadFun();

                egg.startThread(count, "Egg");
                hen.startThread(count, "Hen");
                egg.start();
                hen.start();

                try {
                    egg.join();
                    hen.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < count; i++)
                    System.out.println("Human");
            }
        }
    }
    static class ThreadFun extends Thread {
        private int count;
        private String name;

        public void startThread(int count, String name) {
            this.count = count;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++)
                System.out.println(this.name);
        }
    }

}
