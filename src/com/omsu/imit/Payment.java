package com.omsu.imit;

import java.util.Objects;

public class Payment {
    private String fio;
    private Date date;
    private double sumPayment;

    public Payment(String fio, int theday, int themonth, int theyear, double sum) {

            this.fio = fio;
            this.date = new Date(theday, themonth, theyear);
            if(Double.compare(sum, 0) >0 || Double.compare(sum, 0) ==0)
            {
                sumPayment = sum;
            } else
            {
                throw new IllegalArgumentException("Некорректно введена сумма");
            }
        }

        public Payment(Payment payment) {
            this(payment.getFio(), payment.getDay(), payment.getMonth(), payment.getYear(), payment.getSumPayment());
        }
        public int getDay() {
            return date.getDay();
        }

        public double getSumPayment() {
            return sumPayment;
        }

        public int getMonth() {
            return date.getMonth();
        }

        public int getYear() {
            return date.getYear();
        }

        public String getFio() {
            return fio;
        }

        public void setDay(int day) {
            this.date.setDay(day);
        }

        public void setFio(String fio) {
            this.fio = fio;
        }

        public void setMonth(int month) {
            this.date.setMonth(month);
        }

        public void setSumPayment(double sumPayment) {
            this.sumPayment = sumPayment;
        }

        public void setYear(int year) {
            this.date.setYear(year);
        }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.sumPayment, sumPayment) == 0 &&
                fio.equals(payment.fio) &&
                date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, date, sumPayment);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "fio='" + fio + "', " +
                date.toString() +
                ", sumPayment=" + sumPayment +
                '}';
    }
}
