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
        //������� �������� ������ - ������ �� �����
        lifeMap.put(new RoundOfLife(new int[n][k]), 0);

        //�������� ������ �� ������� �����
        RoundOfLife round = new RoundOfLife(new int[n][k]);
        round.fillRandom();

        while (true) {
            //���� ����� ����(�����) ���� ����� ��������� � �� ����� ������ ��� ����� ������ � �������������
            if (lifeMap.containsKey(round)) {
                count1 = lifeMap.get(round);
                //int count1 = lifeMap.put(round, count);
                //�������� �� ���������� � ������� ������� (������ �� �����)
                if (count1 == 0) {
                    lifeMap.put(round,count);
                    //System.out.println("Round " + count);
                    //round.print();
                    mes = "Life ends";
                    //System.out.println("Life ends");
                    //System.out.println(lifeMap);
                }
                //�������� �� ���������� � ������� �� ������ ������ ����� ���������� ���������
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
            //������� ����� ����� � ������ ������ ����
            round = new RoundOfLife(round);
            count++;
        }
    }
}
