package com.Life;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntryPoint implements Runnable{
    public static int n, k = 0;
    public static int count = 1;
    public static int count1;
    public static String mes = "";
    public static Map<RoundOfLife, Integer> lifeMap = new LinkedHashMap<RoundOfLife, Integer>(100);

    public void run() {
        //вставка нулевого раунда - массив из нулей
        lifeMap.put(new RoundOfLife(new int[n][k]), 0);

        //создание ссылки на текущий раунд
        RoundOfLife round = new RoundOfLife(new int[n][k]);
        round.fillRandom();

        while (true) {
            //если такой ключ(раунд) есть тогда проверяем с на каком раунде был такой массив и останавливаем
            if (lifeMap.containsKey(round)) {
                count1 = lifeMap.get(round);
                //int count1 = lifeMap.put(round, count);
                //проверка на совпадение с нулевым раундом (массив из нулей)
                if (count1 == 0) {
                    lifeMap.put(round,count);
                    //System.out.println("Round " + count);
                    //round.print();
                    mes = "Life ends";
                    //System.out.println("Life ends");
                    //System.out.println(lifeMap);
                }
                //проверка на совпадение с нулевым не прошла значит имеем стабильное состояние
                else {
                    lifeMap.put(round,count1);
                    //round.print();
                    mes = "Stable stance after round " + count1;
                    //System.out.println("Stable stance after round " + count1);
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
