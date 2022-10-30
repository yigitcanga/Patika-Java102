package ThreadRace;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRace {

    public static void main(String[] args) {

        ExecutorService execute = Executors.newFixedThreadPool(4);

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        ThreadSet threadRace = new ThreadSet(numbers);

        execute.execute(threadRace);



    }

}
