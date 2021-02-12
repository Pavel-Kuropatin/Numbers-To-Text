package com.kuropatin.numberstotext;

public class NumbersToText {

    private static final NumbersToText INSTANCE = new NumbersToText();
    private final String[] ONES = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать"};
    private final String[] ONES_FOR_THOUSANDS = {"одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать", "двадцать"};
    private final String[] TENS = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private final String[] HUNDREDS = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private final String[] THOUSANDS = {"тысяча", "тысячи", "тысяч"};
    private final String[] MILLIONS = {"миллион", "миллиона", "миллионов"};
    private final String[] BILLIONS = {"миллиард", "миллиарда", "миллиардов"};

    public static NumbersToText getInstance() {
        return INSTANCE;
    }

    public static String convertNumberToText(int number) {
        try {
            return INSTANCE.numberToText(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private String getHundreds(long number) {
        if ((number / 100) % 10 != 0) return HUNDREDS[(int) (((number / 100) % 10) - 1)];
        else return "";
    }

    private String getTens(long number, int classNumber) {
        if (number % 100 >= 20) return TENS[(int) (((number / 10) % 10) - 2)];
        else if (number % 100 != 0 && (number / 10) % 10 != 0) return classNumber != 2 ? ONES[(int) (number % 100)] : ONES_FOR_THOUSANDS[(int) (number % 100 - 1)];
        else return "";
    }

    private String getOnes(long number, int classNumber) {
        if (number == 0) return ONES[0];
        else if ((number % 10) != 0 && ((number % 100) > 20 || (number % 100) < 10)) return classNumber != 2 ? ONES[(int) (number % 10)] : ONES_FOR_THOUSANDS[(int) ((number % 10) - 1)];
        else return "";
    }

    private String setPrefix(long number) {
        if (number < 0) return  "минус ";
        else return "";
    }

    private String classSpelling(long number, int classNumber) {
        if (classNumber == 1) return "";
        else {
            boolean ifAllowedIndex1 = (number / 10) % 10 != 1 && (number % 10 == 2 || number % 10 == 3 || number % 10 == 4);
            if (classNumber == 2) {
                if (number % 10 == 1 && number % 100 == 1) return THOUSANDS[0] + " ";
                else if (ifAllowedIndex1) return THOUSANDS[1] + " ";
                else if (number % 1000 != 0) return THOUSANDS[2] + " ";
                else return "";
            } else {
                boolean ifAllowedIndex0 = number % 10 == 1 && (number % 100 == 1 || number % 100 > 20);
                if (classNumber == 3) {
                    if (ifAllowedIndex0) return MILLIONS[0] + " ";
                    else if (ifAllowedIndex1) return MILLIONS[1] + " ";
                    else if (number % 1000 != 0) return MILLIONS[2] + " ";
                    else return "";
                }
                else if (classNumber == 4) {
                    if (ifAllowedIndex0) return BILLIONS[0] + " ";
                    else if (ifAllowedIndex1) return BILLIONS[1] + " ";
                    else if (number % 1000 != 0) return BILLIONS[2] + " ";
                    else return "";
                }
            }
        }
        return "";
    }

    private int getNumberOfClasses(long number) {
        int numberRank = 0;
        while (number != 0) {
            number /= 10;
            numberRank++;
        }
        return (numberRank == 0) ? 1 : (int) (Math.ceil(numberRank / 3.0));
    }

    private String getText(long number, int classNumber) {
        number = number / (long) Math.pow(1000, classNumber - 1.0);
        String outputString = "";
        String hundreds = getHundreds(number);
        String tens = getTens(number, classNumber);
        String ones = getOnes(number, classNumber);
        if(!hundreds.equals("")) outputString += hundreds + " ";
        if(!tens.equals("")) outputString += tens + " ";
        if(!ones.equals("")) outputString += ones + " ";
        outputString += classSpelling(number, classNumber);
        return outputString;
    }

    private String numberToText(int number) {
        StringBuilder outputString = new StringBuilder(setPrefix(number));
        long numberToText = Math.abs((long) number);
        int numberOfClasses = getNumberOfClasses(numberToText);
        for (int i = numberOfClasses; i > 0; i--) {
            outputString.append(getText(numberToText, i));
        }
        outputString = new StringBuilder(outputString.toString().trim());
        return outputString.substring(0, 1).toUpperCase() + outputString.substring(1);
    }
}