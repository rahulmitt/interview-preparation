package com.interviewpedia.preparation.akka.actor.racingsimulation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RacerMain {
    private static long start;

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> currentPositions = new ConcurrentHashMap<>();
        Map<Integer, Long> results = new ConcurrentHashMap<>();

        start = System.currentTimeMillis();
        int raceLength = 100;
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Racer h = new Racer(i, raceLength, currentPositions, results);
            currentPositions.put(i, 0);
            threadPool.execute(h);
        }

        boolean finished = false;
        while (!finished) {
            Thread.sleep(1000);
            displayRace(currentPositions);
            finished = results.size() == 10;
        }

        threadPool.shutdownNow();

        System.out.println("Results");
        results.values().stream().sorted().forEach(it -> {
            for (Integer key : results.keySet()) {
                if (results.get(key) == it) {
                    System.out.println("Racer " + key + " finished in " + ((double) it - start) / 1000 + " seconds.");
                }
            }
        });
    }

    private static void displayRace(Map<Integer, Integer> currentPositions) {
        int displayLength = 160;
        for (int i = 0; i < 50; ++i) System.out.println();
        System.out.println("Race has been running for " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
        System.out.println("    " + new String(new char[displayLength]).replace('\0', '='));
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " : " + new String(new char[currentPositions.get(i) * displayLength / 100]).replace('\0', '*'));
        }
    }
}
