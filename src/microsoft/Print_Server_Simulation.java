package microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Print_Server_Simulation {
    /**
     * You are writing a simulation for a print server. This print server can accept jobs from 3 places
     * - network, USB, or operator.
     * It can dispatch only one job at a time. Each input job should contain an integer t which is the time in seconds
     * it will take to process the job. Write a multi-threaded program to simulate the server and provide some
     * simulated load with jobs. Think, of some interesting statistics your program should emit and code them in.
     */

    enum Source {
        USB,
        NETWORK,
        OP
    }

    public static class Job implements Runnable {
        Source source;
        int time;
        public Job(Source source, int time) {
            this.source = source;
            this.time = time;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("executed job: " + source);
        }
    }

    public static class Server {
//        Queue<Job> queue;
        Map<Source, Integer> stats;
        ExecutorService executorService;

        public Server () {
//            queue = new LinkedList<>();
            stats = new ConcurrentHashMap<>();
        }

        public void start() {
            System.out.println("started");
            executorService = Executors.newFixedThreadPool(3);
        }

        public void addJob(Job job) {
            int cnt = stats.getOrDefault(job.source, 0);
            stats.put(job.source, cnt + 1);
            executorService.submit(job);
        }

        public void printStats() {
            for (Source s : stats.keySet()) {
                System.out.println(s + " total: " + stats.get(s));
            }
        }

        public void stop() {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
        s.start();
        Job j1 = new Job(Source.USB, 100);
        Job j2 = new Job(Source.USB, 150);
        Job j3 = new Job(Source.NETWORK, 150);
        Job j5 = new Job(Source.OP, 150);
        Job j4 = new Job(Source.USB, 150);

//            Thread.sleep(1000);
            s.addJob(j1);
//            Thread.sleep(1000);
            s.addJob(j2);
            s.addJob(j3);
            s.addJob(j4);
            s.addJob(j5);

        s.printStats();
        s.stop();

    }
}
