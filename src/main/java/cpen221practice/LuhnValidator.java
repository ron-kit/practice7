package cpen221practice;

import java.security.InvalidParameterException;

class LuhnValidator {

    boolean isValid(String candidate) throws InvalidParameterException {
        String str = candidate.replaceAll(" ", "");
        if (str.matches("\\D") || str.length() <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = Character.getNumericValue(str.charAt(i));
            if ((i + str.length()) % 2 == 0) {
                sum += Math.max((digit * 2) % 10, digit * 2 - 9);
            } else {
                sum += digit;
            }
        }
        return (sum % 10 == 0);
    }
}