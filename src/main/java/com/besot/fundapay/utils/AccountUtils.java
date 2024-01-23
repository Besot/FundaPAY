package com.besot.fundapay.utils;

import java.time.Year;

public class AccountUtils {

    public static String ACCOUNT_EXISTS_CODE = "001";
    public static String ACCOUNT_EXISTS_MESSAGE = "THIS USER ALREADY HAS AN EXISTING ACCOUNT";
    public static String ACCOUNT_CREATION_SUCCESS = "002";
    public static String ACCOUNT_CREATION_MESSAGE = "ACCOUNT HAS BEEN SUCCESSFULLY CREATED!";

    public static String generateAccountNumber() {
        Year currentYear = Year.now();

        int min = 10000;
        int max = 99999;

        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);

        return year + randomNumber;
    }

}
