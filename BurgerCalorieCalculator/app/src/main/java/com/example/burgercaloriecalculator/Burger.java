package com.example.burgercaloriecalculator;

public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICH = 120;
    static final int PROSCIUTTO = 115;

    int mPattyCalorie;
    int mCheeseCalorie;
    int mproscuitto;
    int msauce;

    public void setPattyCalories(int calorie) {
        mPattyCalorie = calorie;
    }

    public void setCheeseCalories(int calorie) {
        mCheeseCalorie = calorie;
    }

    public void setProsciuttoCalories(int calorie) {
        mproscuitto = calorie;
    }

    public void clearProsciuttoCalories() {
        mproscuitto = 0;
    }

    public void setSauceCalories(int calorie) {
        msauce = calorie;
    }

    public int getTotalCalories() {
        return mPattyCalorie + mCheeseCalorie + mproscuitto + msauce;
    }
}