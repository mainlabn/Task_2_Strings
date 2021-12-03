package com.omsu.imit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.omsu.imit.String_Proccessor.*;
import static org.testng.Assert.*;

public class StringProcessorTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
//                {"", "aaa", 0},
//                {"", "", 0},
                {"asdf", "", -1},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {"  1 ", "  один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }

    @DataProvider
    public static Object[][] swapWordsProvider() {
        return new Object[][]{
                {"", ""},
                {" qq ", " qq "},
                {" aaa bbb cc dd", " dd cc bbb aaa"}
        };
    }
    @DataProvider
    public static Object[][] hexAgeToIntProvider() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"Васе 0x00000010 лет, Андрею 0x00000011 лет", "Васе 16 лет, Андрею 17 лет"},
                {"Васе 16 лет", "Васе 16 лет"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) throws IllegalArgumentException {
        assertEquals(copy(str, N), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyExc() throws IllegalArgumentException {
        copy("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected) throws IllegalArgumentException {
        assertEquals(getCountSubs(big, small), expected);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class})
    public void testFindExc() throws IllegalArgumentException {
        getCountSubs( "gdywu", "");
        fail();
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(replace(source), expected);
    }

    @Test
    public void testDeleteEvenSymbol() {
        StringBuilder  stringBuffer = new StringBuilder("1234567");
        deleteSymbol(stringBuffer);
        assertEquals(stringBuffer.toString(), "1357");
        deleteSymbol(stringBuffer);
        assertEquals(stringBuffer.toString(), "15");
        deleteSymbol(stringBuffer);
        assertEquals(stringBuffer.toString(), "1");
        deleteSymbol(stringBuffer);
        assertEquals(stringBuffer.toString(), "1");
    }

   // @Test(dataProvider = "swapWordsProvider")
    // public void testSwapWords(String source, String expected) {
     //   assertEquals(swapWords(source), expected);
   //}


/*
    @Test(dataProvider = "hexAgeToIntProvider")
    public void testHexAgeToInt(String source, String expected) {
        assertEquals(hexAgeToInteger(source), expected);
    }
 */
}