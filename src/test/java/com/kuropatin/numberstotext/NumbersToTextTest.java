package com.kuropatin.numberstotext;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumbersToTextTest extends NumbersToText {

    @Test
    void testConvertNumberToText() {

        //Ones
        assertEquals("Ноль", convertNumberToText(0));
        assertEquals("Минус один", convertNumberToText(-1));
        assertEquals("Один", convertNumberToText(1));
        assertEquals("Девять", convertNumberToText(9));

        //Tens
        assertEquals("Десять", convertNumberToText(10));
        assertEquals("Одиннадцать", convertNumberToText(11));
        assertEquals("Девятнадцать", convertNumberToText(19));
        assertEquals("Двадцать", convertNumberToText(20));
        assertEquals("Двадцать один", convertNumberToText(21));

        //Hundreds
        assertEquals("Сто", convertNumberToText(100));
        assertEquals("Сто один", convertNumberToText(101));
        assertEquals("Сто девять", convertNumberToText(109));
        assertEquals("Сто десять", convertNumberToText(110));
        assertEquals("Сто одиннадцать", convertNumberToText(111));
        assertEquals("Сто девятнадцать", convertNumberToText(119));
        assertEquals("Сто двадцать", convertNumberToText(120));
        assertEquals("Сто двадцать один", convertNumberToText(121));

        //Thousands
        assertEquals("Одна тысяча", convertNumberToText(1000));
        assertEquals("Две тысячи", convertNumberToText(2000));
        assertEquals("Пять тысяч", convertNumberToText(5000));
        assertEquals("Одиннадцать тысяч", convertNumberToText(11000));
        assertEquals("Двенадцать тысяч", convertNumberToText(12000));
        assertEquals("Пятнадцать тысяч", convertNumberToText(15000));
        assertEquals("Девятнадцать тысяч", convertNumberToText(19000));
        assertEquals("Двадцать одна тысяч", convertNumberToText(21000));
        assertEquals("Двести тысяч", convertNumberToText(200000));
        assertEquals("Одна тысяча один", convertNumberToText(1001));
        assertEquals("Одна тысяча одиннадцать", convertNumberToText(1011));
        assertEquals("Одна тысяча девятнадцать", convertNumberToText(1019));
        assertEquals("Одна тысяча двадцать", convertNumberToText(1020));
        assertEquals("Одна тысяча двадцать один", convertNumberToText(1021));
        assertEquals("Одна тысяча сто", convertNumberToText(1100));
        assertEquals("Одна тысяча сто одиннадцать", convertNumberToText(1111));
        assertEquals("Минус девятьсот девяносто девять тысяч девятьсот девяносто девять", convertNumberToText(-999999));

        //Millions
        assertEquals("Один миллион", convertNumberToText(1000000));
        assertEquals("Два миллиона", convertNumberToText(2000000));
        assertEquals("Пять миллионов", convertNumberToText(5000000));
        assertEquals("Одиннадцать миллионов", convertNumberToText(11000000));
        assertEquals("Двенадцать миллионов", convertNumberToText(12000000));
        assertEquals("Пятнадцать миллионов", convertNumberToText(15000000));
        assertEquals("Девятнадцать миллионов", convertNumberToText(19000000));
        assertEquals("Двадцать один миллион", convertNumberToText(21000000));
        assertEquals("Сто миллионов", convertNumberToText(100000000));

        //Billions
        assertEquals("Один миллиард", convertNumberToText(1000000000));
        assertEquals("Два миллиарда", convertNumberToText(2000000000));
    }
}