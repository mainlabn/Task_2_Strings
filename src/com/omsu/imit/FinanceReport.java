package com.omsu.imit;

import java.util.Arrays;

public class FinanceReport {
    private final Payment[] reports;
    private final String fio;
    private final Date date;


    public FinanceReport(String author, int day, int month, int year, Payment ... payments)
    {
        if (author == null) {
            throw new IllegalArgumentException("author is null");
        }
        fio = author;
        date = new Date(day, month, year);
        reports = payments;
    }
    public FinanceReport(String author, int day, int month, int year, int size)
    {
        if (author == null) {
            throw new IllegalArgumentException("author is null");
        }
        fio = author;
        date = new Date(day, month, year);
        if(size<=0){
            throw new IllegalArgumentException("size is < or = 0");
        }
        reports = new Payment[size];
    }

    public FinanceReport(FinanceReport financeReport) {
        this.fio=financeReport.fio;
        this.date=financeReport.date;
        this.reports=financeReport.reports;

    }


    public Payment getReports(int i) {
        return reports[i];
    }

    public void setReports(Payment payment, int i) {
        this.reports[i] = new Payment(payment);
    }

    public int getLength()
    {
        return reports.length;
    }

    public Payment[] getReports() {
        return reports;
    }

    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        String t = "Фио = %s, day = %d, Mounth = %d, year = %d, sumPayment = %f ";
        String t_last = "Фио = %s, day = %d, Mounth = %d, year = %d, sumPayment = %f";

        for(int i = 0; i< reports.length; i++)
        {
            if(i == reports.length-1) {
                n.append(String.format(t_last, reports[i].getFio(), reports[i].getDay(), reports[i].getMonth(), reports[i].getYear(), reports[i].getSumPayment()));
            }else{
                n.append(String.format(t, reports[i].getFio(), reports[i].getDay(), reports[i].getMonth(), reports[i].getYear(), reports[i].getSumPayment()));
            }
        }
        return n.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return Arrays.equals(reports, that.reports) && getFio().equals(that.getFio());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(reports);
    }

    public String getFio() {
        return fio;
    }

    public Date getDate() {
        return date;
    }
}


