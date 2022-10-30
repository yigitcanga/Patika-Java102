package ThreadRace;

import java.util.ArrayList;

public class ThreadSet extends Thread {

    private final Object LOCK = new Object();

    private ArrayList<Integer> temp = new ArrayList<>();
    private ArrayList<Integer> odd = new ArrayList<>();
    private ArrayList<Integer> even = new ArrayList<>();


    public ThreadSet(ArrayList<Integer> general) {
        this.temp = general;
    }

    public synchronized void printOdd() {
        System.out.println(this.odd);

    }

    public synchronized void printEven() {
        System.out.println(this.even);
    }

    @Override
    public void run() {

        for (int i = 0; i < temp.size(); i++) {

            if (temp.get(i) % 2 == 1) {
                odd.add(temp.get(i));
            } else {
                even.add(temp.get(i));
            }

        }

        printEven();

        printOdd();

    }


}
