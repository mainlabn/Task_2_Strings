package com.omsu.imit;

public class FinanceReportProcessor {
    public static FinanceReport charReport(FinanceReport reports, char a)
    {

        int j = 0;
        for(int i = 0; i<reports.getLength(); i++)
        {
            if(Character.toLowerCase(reports.getReports(i).getFio().charAt(0)) == Character.toLowerCase(a))  {
                j++;
            }

        }
        FinanceReport newPayments = new FinanceReport(
                reports.getFio(),
                reports.getDate().getDay(),reports.getDate().getMonth(),reports.getDate().getYear(),
                j
        );
        j = 0;
        for(int i = 0; i<reports.getLength(); i++)
        {
            if(Character.toLowerCase(reports.getReports(i).getFio().charAt(0)) == Character.toLowerCase(a))          {
                newPayments.setReports(reports.getReports(i), j);
                j++;

            }
        }
        return newPayments;

    }

    public static FinanceReport DemensionReports(FinanceReport reports, int a)
    {
        int amount = 0;
        for(int i = 0; i<reports.getLength(); i++)
        {
            if (reports.getReports(i).getSumPayment() < a)  {
                amount++;
            }

        }
        FinanceReport newPayments = new FinanceReport(
                reports.getFio(),
                reports.getDate().getDay(),reports.getDate().getMonth(),reports.getDate().getYear(),
                amount
        );
        int index = 0;
        for(int i = 0; i<reports.getLength(); i++)
        {
            if (reports.getReports(i).getSumPayment() < a)          {
                newPayments.setReports(reports.getReports(i), index);
                index++;
            }

        }
        return newPayments;
    }
}


