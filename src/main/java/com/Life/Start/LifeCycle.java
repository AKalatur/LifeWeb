package com.Life.Start;

import com.Life.Round.RoundOfLife;

import java.util.LinkedHashMap;
import java.util.Map;

public class LifeCycle implements Runnable{
    public static int arrN, arrK;
    public int n, k;
    public String mes = "";
    public Map<RoundOfLife, Integer> lifeMap = new LinkedHashMap<RoundOfLife, Integer>(100);
    private int count = 1;

    public LifeCycle(int k, int n) {
        this.k = k;
        this.n = n;
    }

    public void run() {

        //Create a reference to the current round
        RoundOfLife round = new RoundOfLife(new int[n][k]);
        round.fillRandom();

        while (true) {
            //check matches
            if (lifeMap.containsKey(round)) {
                //check: equals to zero
                if (round.equals(new RoundOfLife(new int[n][k]))) {
                    mes = "Life ends";
                    //System.out.println("Round " + count);
                    //round.print();
                    //System.out.println("Life ends");
                }
                //equals to zero = false -> Stable stance
                else {
                    mes = "Stable stance after round " + (count -1);
                    //System.out.println("Stable stance after round " + count);
                    //System.out.println(lifeMap);
                }
                break;
            }

            lifeMap.put(round, count);
            //System.out.println("Round " + count);
            //round.print();
            //construct new round
            round = new RoundOfLife(round);
            count++;
        }
    }
}
