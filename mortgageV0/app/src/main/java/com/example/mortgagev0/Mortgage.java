package com.example.mortgagev0;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Mortgage {

        public final DecimalFormat MONEY
                = new DecimalFormat("$#,##0.00");

        private float amount;
        private int years;
        private float rate;

        public Mortgage() { //Why is this not being used right now?
            setAmount(10000.0f);
            setYears(30);
            setRate(0.035f);
        }//end of Mortgage

        public void setAmount(float newAmount) {
            if(newAmount>= 0)
                amount = newAmount;
        }//end of setAmount
        public void setYears(int newYears){
            if(newYears>= 0)
                years = newYears;
        }//end of setYears

        public void setRate(float newRate) {
            if (newRate >= 0)
                rate = newRate;
        }//end of setRate

        public float getAmount() {
            return amount;
        }//end of getAmount

        public String getFormattedAmount(){
            return MONEY.format(amount);
        }//end of setRate

        public int getYears(){
            return years;
        }//end of getYears

        public float getRate(){
            return rate;
        }//end of getRate

        public float monthlyPayment() {
            float mRate = rate / 12; //monthly interest rate
            double temp = Math.pow(1 / (1 + mRate), years * 12);
            return amount * mRate / (float) (1 - temp);
        }//monthlyPayment

        public String formattedMonthlyPayment() {
            return MONEY.format(monthlyPayment());
        }//end of formattedMonthlyPayment

        public float totalPayment(){
            return monthlyPayment()*years*12;
        }//totalPayment

        public String formattedTotalPayment(){
            return MONEY.format(totalPayment());
        }//end of formattedTotalPayment

    }//end of Main
}
