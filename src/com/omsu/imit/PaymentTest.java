package com.omsu.imit;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.fail;
import static com.omsu.imit.FinanceReportProcessor.*;

public class PaymentTest {

    @Test
    public void testCopyTrue() throws IllegalArgumentException {
        Payment a = new Payment("Аржановский Марк Михайлович", 23, 12, 2001, 1000.1);
        Payment b = new Payment("Аржановский Марк Михайлович", 23, 12, 2001, 1000.1);
        assertEquals(a, b);

    }

    @Test
    public void testCopyF() throws IllegalArgumentException {
        Payment a1 = new Payment("Аржановский Марк Михайлович", 23, 12, 2001, 1000.1);
        Payment b1 = new Payment("Аржановский Марк Михайлович", 22, 11, 2000, 1000.0);
        assertNotEquals(a1, b1);

        Payment a3 = new Payment("Аржановский Марк Михайлович", 23, 12, 2001, 1000.1);
        Payment b3 = new Payment("Аржановский Марк Михайлович", 23, 12, 2000, 1000.1);
        assertNotEquals(a3, b3);

        Payment a2 = new Payment("Аржановский Марк Михайлович", 23, 12, 2001, 1000.1);
        Payment b2 = new Payment("Аржановская Вероника ", 20, 11, 2000, 999.0);
        assertNotEquals(a2,b2);

        Payment a4 = new Payment("", 23, 12, 2001, 1000.1);
        Payment b4 = new Payment("Аржановский Марк Михайлович", 23, 12, 2000, 1000.1);
        assertNotEquals(a4, b4);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyFalse() throws IllegalArgumentException {

        Payment c = new Payment("Аржановский Марк Михайлович", -23, 12, 1231, 2000.1);
        Payment d = new Payment("", -10, 12, 1231, 2000.1);
        fail();

        Payment e = new Payment("Аржановский Марк Михайлович", 23, -12, 1231, 2000.1);
        Payment f = new Payment("AAAAAAA", 10, 12, 1231, -2000.1);
        fail();

        Payment g = new Payment("Аржановский Марк Михайлович", -23, 12, -1231, 123.1);
        Payment h = new Payment("MMMMMM", 10, 12, -1231, 2000.1);
        fail();

    }


    @Test
    public void testToString()
    {
        Payment a = new Payment("Аржановский Марк Михайлович", 12, 11, 2001, 2000.1);
        assertEquals(
                a.toString(),
                "Payment{fio='Аржановский Марк Михайлович', day=12, month=11, year=2001, sumPayment=2000.1}"
                );

    }


    @Test
    public void testHashCode()
    {
        Payment a = new Payment("Аржановский Марк Михайлович", 12, 11, 2001, 1000.1);
        assertEquals(a.hashCode(), 723671950);
    }

    @Test
    public void testFinanceReportToString()
    {
        int n = 3;
        FinanceReport b = new FinanceReport(
                "Асаевич Никита Сергеевич",
                23, 11, 2001,
                n
        );
        Payment a1 = new Payment("Аржановский Марк Михайлович", 22, 12, 2001, 1000.1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 2001, 1000.1);
        Payment a3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 2002, 1200.1);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        assertEquals(b.toString(), "Фио = Аржановский Марк Михайлович, day = 22, Mounth = 12, year = 2001, sumPayment = 1000,100000 Фио = Асаевич Никита Сергеевич, day = 23, Mounth = 11, year = 2001, sumPayment = 1000,100000 Фио = Раховецкий Андрей Олегович, day = 23, Mounth = 12, year = 2002, sumPayment = 1200,100000");
    }
    @Test
    public void testFinanceReportProcessor()
    {

        FinanceReport b = new FinanceReport(
                "Асаевич Никита Сергеевич",
                23, 11, 2001,
                3
        );
        Payment a1 = new Payment("Романовский Иван Владимирович", 22, 10, 2018, 1230.1);
        Payment a2 = new Payment("Аржановский Марк Михайлович", 23, 11, 2020, 1250.1);
        Payment a3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 2021, 1240.1);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        char a = 'А';
        FinanceReport actual = charReport(b, a);
        Payment a4 = actual.getReports(0);
        assertEquals(a4, a2);
        assertEquals(actual.getLength(), 1);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testFinanceReportProcessorNone()
    {
        FinanceReport b = new FinanceReport(
                "Асаевич Никита Сергеевич",
                23, 11, 2001,
                3
        );
        Payment a1 = new Payment("Романовский Иван Владимирович", 22, 10, 2018, 1230.1);
        Payment a2 = new Payment("Аржановский Марк Михайлович", 23, 11, 2020, 1250.1);
        Payment a3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 2021, 1240.1);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        char a = 'M';
//        Payment a4 = charReport(b, a);
        assertEquals(charReport(b, a).getLength(), 0 );
    }


    @Test
    public  void testDemension() {
        FinanceReport b = new FinanceReport(
                "Асаевич Никита Сергеевич",
                23, 11, 2001,
                3
        );
        Payment a1 = new Payment("Аржановский Марк Михайлович", 22, 12, 1231, 12200);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 23, 11, 1231, 12300);
        Payment a3 = new Payment("Раховецкий Андрей Олегович", 23, 12, 1234, 12300);
        b.setReports(a1, 0);
        b.setReports(a2, 1);
        b.setReports(a3, 2);
        Payment a4 = DemensionReports(b, 12201).getReports(0);
        assertEquals(a4,  a1 );
    }




}


