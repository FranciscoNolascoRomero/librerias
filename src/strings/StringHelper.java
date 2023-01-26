package strings;

import java.util.IllegalFormatCodePointException;
import java.util.Random;
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
    /**
     * Methols
     * @param number
     * @return
     * */
    public static boolean checkPhoneNumber(String number){
//        if (number.length()<9||number.length()>9) {
//            return false;
//        }
//        //6,7,9
//        if (!number.matches("[6,7,9][0-9]{8}")){
//            return false;
//        }


        return number.matches("[679][0-9]{8}");
    }
    //falta la documentacion
    public static boolean isValideID(String ID) {
        if (!ID.toLowerCase().matches("[0-9]{8}[a-z]")){
            return false;
        }
        char [] letrasID = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

        String numeroID=ID.substring(0,8);
        int numero = Integer.parseInt(numeroID);
        int resto = numero % 23;
        String idReal = numeroID + letrasID[resto];
        if (ID.toUpperCase().equals(idReal.toUpperCase())){
            return false;
        }

        return true;
    }
    public static String createSafePassword (int length){
        if (length < 4)
            return null;
        final String  FUENTE_CARACTERES =
                "abcdefghijklmnñopqrstuvwxyzABCDEFEGHIJKLMNÑOPQRSTUVWXYZ¿?()=@.:,;!¡&{}012456789";

        Random random = new Random();
        StringBuilder stringBuilder;
        do {
            stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int posicion = random.nextInt(FUENTE_CARACTERES.length());
                char caracter = FUENTE_CARACTERES.charAt(posicion);
                stringBuilder.append(caracter);
            }
        }while (!(isSafePassword(length,length,stringBuilder.toString())));

        return stringBuilder.toString();
    }
//    public static void main(String[] args) {
////      System.out.println(isSafePassword(8,12,"abcdefgha1Á_"));
////        System.out.println(isSafePasswordDefault("abcdefgha1Á_"));
////        System.out.println(checkPhoneNumber("678988989"));
////        System.out.println(77689287%23);
////        System.out.println(isValideID("77689287W"));
//        System.out.println(createSafePassword(4));
//    }
}

