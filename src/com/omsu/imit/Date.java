package com.omsu.imit;

import java.util.Objects;

public class Date {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (!isDateCorrect(day, this.month, this.year )) {
            throw new IllegalArgumentException("Некорректно введена дата");
        }

            this.day = day;
    }
    public void setMonth(int month) {
        if (!isDateCorrect(this.day,month,this.year)) {
            throw new IllegalArgumentException("Некорректно введена дата");
        }

        this.month = month;
    }

    public void setYear(int year) {
        if (!isDateCorrect(this.day,this.month,year)) {
            throw new IllegalArgumentException("Некорректно введена дата");
        }
            this.year = year;
    }

    /**
     * Год високосный, если он делится на четыре без остатка, 
     * но если он делится на 100 без остатка, это не високосный год. 
     * Однако, если он делится без остатка на 400, это високосный год. 
     * 
     * Таким образом, 2000 г. является особым високосным годом, 
     * который бывает лишь раз в 400 лет.
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        boolean leap;
        if (year % 400 == 0) return true;
        if(year % 100 == 0) return false;
        return (year % 4 == 0);        
    }

    public static boolean isDateCorrect(int theday, int themonth, int theyear) {
        boolean leap = isLeapYear(theyear);
        int[] daysNotLeap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 30, 30, 31};
        int[] daysLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 30, 30, 31};

        if (1 > themonth || themonth > 12) {
           return false;
        }

        return (1 <= theday &&
                (!leap || theday <= daysLeap[themonth - 1]) &&
                (leap || theday <= daysNotLeap[themonth - 1]));
    }

    public Date(int theday, int themonth, int theyear) {
        if (!isDateCorrect(theday, themonth, theyear) ) {
            throw new IllegalArgumentException("Некорректно введена дата");
        }
        year = theyear;
        month = themonth;
        day = theday;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return  "day=" + day +
                ", month=" + month +
                ", year=" + year;
    }
}


//Date(Date)
//Date(String)  -- не обязательно

