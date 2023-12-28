package me.vichea.corebaking.utils;

import java.time.Year;

public class AccountUtils {
    /**
     * 2023 + randomSixDigits
     */

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_EXISTS_MESSAGE = "Email already exists";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account successfully created";
    public static String generateAccountNumber(){
        /// generate a random number between min and max
        int MIN = 100000;
        int MAX = 999999;
        Year currentYear =Year.now();
        int randNumber =(int) Math.floor(Math.random() * (MAX - MIN+1) + MIN);
        // convert the currentYear to string
        String year = String.valueOf(currentYear);

        String randomNumber =  String.valueOf(randNumber);

        return year + randomNumber;
    }


}
