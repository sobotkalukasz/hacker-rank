package pl.lsobotka.hacker.rank.algorithms;

/*
 * https://www.hackerrank.com/challenges/taum-and-bday/problem
 */
public class TaumBDay {

    public long taumBday(int blackGiftQty, int whiteGiftQTY, int blackCost, int whiteCost, int transformCost) {

        long bCost = Math.min(blackCost, whiteCost + transformCost);
        long wCost = Math.min(whiteCost, blackCost + transformCost);
        return blackGiftQty * bCost + whiteGiftQTY * wCost;
    }
}
