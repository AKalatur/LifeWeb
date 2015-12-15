package com.Life.Round;

//wrapper class
public class RoundOfLife{
    public final int[][] lArray;

    public RoundOfLife(int[][] lArray) {
        this.lArray = lArray;
    }

    //construction of a new round from previous round
    public RoundOfLife(RoundOfLife oldRound) {
        int[][] newRound = new int[oldRound.lArray.length][oldRound.lArray[0].length];
        for (int i = 0; i < oldRound.lArray.length; i++) {
            for (int j = 0; j < oldRound.lArray[0].length; j++) {
                if (oldRound.lArray[i][j] == 0 && neighborhoodQuantity(oldRound.lArray, i, j) == 3)
                    newRound[i][j] = 1;
                else if (oldRound.lArray[i][j] == 1 && (neighborhoodQuantity(oldRound.lArray, i, j) < 2 || neighborhoodQuantity(oldRound.lArray, i, j) > 3))
                    newRound[i][j] = 0;
                else newRound[i][j] = oldRound.lArray[i][j];
            }
        }
        this.lArray = newRound;
    }

    //filling array with random value (0,1)
    public void fillRandom() {
        for (int i = 0; i < this.lArray.length; i++) {
            for (int j = 0; j < this.lArray[i].length; j++) {
                lArray[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    // counting live neighbors of a point (i,j)
    public static int neighborhoodQuantity(int[][] array, int i, int j) {
        int count = 0;
        if (elemExist(i - 1, j - 1, array.length, array[i].length)) {
            if (array[i - 1][j - 1] == 1)
                count++;
        }
        if (elemExist(i - 1, j, array.length, array[i].length)) {
            if (array[i - 1][j] == 1)
                count++;
        }
        if (elemExist(i - 1, j + 1, array.length, array[i].length)) {
            if (array[i - 1][j + 1] == 1)
                count++;
        }
        if (elemExist(i, j - 1, array.length, array[i].length)) {
            if (array[i][j - 1] == 1)
                count++;
        }
        if (elemExist(i, j + 1, array.length, array[i].length)) {
            if (array[i][j + 1] == 1)
                count++;
        }
        if (elemExist(i + 1, j - 1, array.length, array[i].length)) {
            if (array[i + 1][j - 1] == 1)
                count++;
        }
        if (elemExist(i + 1, j, array.length, array[i].length)) {
            if (array[i + 1][j] == 1)
                count++;
        }
        if (elemExist(i + 1, j + 1, array.length, array[i].length)) {
            if (array[i+1][j+1] == 1)
                count++;
        }
        return count;
    }

    // check if the element (i,j) exist in array  n*k
    public static boolean elemExist(int i, int j, int n, int k) {
        return (i >= 0 && j >= 0) && (i < n && j < k);
    }

    //print in console
    public void print() {
        StringBuilder row = new StringBuilder();
        for (int[] aLArray : this.lArray) {
            for (int anALArray : aLArray) {
                row = row.append(anALArray).append(" ");
            }
            System.out.println(row);
            row.delete(0, row.length());
        }
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        RoundOfLife otherRound = (RoundOfLife) obj;
        for (int i = 0; i < this.lArray.length; i++) {
            for (int j = 0; j < this.lArray[i].length; j++) {
                if (this.lArray[i][j] != otherRound.lArray[i][j]) return false;
            }
        }
        return true;
    }

    //hash code
    @Override
    public int hashCode() {
        int res = 0;
        for (int i = 0; i < this.lArray.length; i++) {
            for (int j = 0; j <this.lArray[i].length; j++) {
                res += (i + 1) * (j + 1) * this.lArray[i][j];
            }
        }
        return res;
    }
}