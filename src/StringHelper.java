/**
 * Helper class that affers helper methods related with Strings
 * @author Francisco NOlasco
 * @version 1.0.0
 * */
public class StringHelper {

    private StringHelper(){};
    /**
     * Methods that returns a boolean if the password contains at least a digit, a lowercase letter
     * a uppercase letter and a symbol, besides the length of the password has to be between minlen
     * and maxlen
     * @param minlen minimum length
     * @param maxlen maximum length
     * @param password password to check
     * @return true if the password has the conditions,false on the another case
     * */
    //wether
    public static boolean isSafePassword(int minlen, int maxlen, String password) {
        if (maxlen < minlen)
            return false;

        if (!(password.length() >= minlen && password.length() <= maxlen))
            return false;

        //password.matches no encaja con
        if (!password.matches(".*[a-záéíóúñÜ].*"))
            return false;

        if (!password.matches(".*[A-ZÁÉÍÓÚüÑ].*"))
            return false;

        if (!password.matches(".*[0-9].*"))//[\d]
            return false;

        if (!password.matches(".*[^A-Za-záéíóúÜüÁÉÍÓÚ0-9].*"))
            return false;



        return true;
    }
    /**
     * Methods that returns a boolean if the password contains at least a digit, a lowercase letter
     * a uppercase letter and a symbol, besides the length of the password has to be between 8
     * and 12, values inclued
     * @param password password to check
     * @return true if the password has the conditions,false on the another case
     * */
    public static boolean isSafePasswordDefault(String password){

        return isSafePassword(8,12,"abcdefgha1Á_");
    }
//    public static void main(String[] args) {
//        System.out.println(issafepassword(8,12,"abcdefgha1Á_"));
//        System.out.println(issafepasswordDefault("abcdefgha1Á_"));
//    }
}
