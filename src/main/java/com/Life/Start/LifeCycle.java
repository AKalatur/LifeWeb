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
            //если такой ключ(раунд) есть тогда проверяем с на каком раунде был такой массив и останавливаем
            if (lifeMap.containsKey(round)) {
                //проверка на совпадение с нулевым раундом (массив из нулей)
                if (round.equals(new RoundOfLife(new int[n][k]))) {
                    mes = "Life ends";
                    //System.out.println("Round " + count);
                    //round.print();
                    //System.out.println("Life ends");
                }
                //проверка на совпадение с нулевым не прошла значит имеем стабильное состояние
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
            //создаем новый раудн с учетом правил игры
            round = new RoundOfLife(round);
            count++;
        }
    }
}
