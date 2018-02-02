package sample;

public class player {

    private static double cash;

    public int apples;

    public int oranges;

    public int bananas;

    public int grapes;






    public player(double cash, int apples, int oranges, int bananas, int grapes) {
        this.cash = cash;
        this.apples = apples;
        this.oranges = oranges;
        this.bananas = bananas;
        this.grapes = grapes;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getApples() {
        return apples;
    }

    public void setApples(int apples) {
        this.apples = apples;
    }

    public int getOranges() {
        return oranges;
    }

    public void setOranges(int oranges) {
        this.oranges = oranges;
    }

    public int getBananas() {
        return bananas;
    }

    public void setBananas(int bananas) {
        this.bananas = bananas;
    }

    public int getGrapes() {
        return grapes;
    }

    public void setGrapes(int grapes) {
        this.grapes = grapes;
    }
}
