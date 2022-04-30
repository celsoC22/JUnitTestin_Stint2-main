package sms;
import sms.model.Register;
import sms.model.SMS;
import sms.model.UserInformation;

import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;

public class SMSChecker {


    public static boolean check(HashMap<String, String> smsMap, SMS sms) {
        boolean result = false;
        if (smsMap.size() == 3) {
            String mobileNumber = smsMap.get("Mobile number");
            String message = smsMap.get("Message");
            String shortCode = smsMap.get("Short Code");

            if(shortCode.equals("12345555")){
                sms.setPromo("Piso Pizza");
                if (message.equals("PROMO") || message.equals("REGISTER")) {
                    result = true;
                    sms.setSuccess(true);
                } else {
                    sms.setSuccess(false);
                }
            }
        }
        return result;
    }

    //STINT TWO HOME WORK BEGIN HERE

    public static boolean checkRegister(HashMap<String, String> smsMap, Register sms) {
        boolean result = false;

        String message = smsMap.get("Message").toLowerCase().trim();


        if (message.equals("register")) {
            sms.setRegisterCode(message);
            result = true;
            sms.setSuccess(true);

        }else {
            sms.setSuccess(false);
        }
        return result;

    }

    public static boolean rightDateFormat(final String date){
        boolean res = false;

        try {


            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("uuuu-MM-dd")  //"uuuu-M-d"
                            .withResolverStyle(ResolverStyle.STRICT)
            );

            res = true;

        } catch (DateTimeParseException e) {
            e.printStackTrace();
            res = false;

        } finally {
            return res;
        }

    }



//    public static boolean rightDateFormat(final String date){
//        boolean res = true;
//
//        ParsePosition pp = new ParsePosition(0);
//
//        try {
//            TemporalAccessor t =
//                    DateTimeFormatter.ofPattern("uuuu-MM-dd")
//                            .withResolverStyle(ResolverStyle.STRICT)
//                            .parseUnresolved("2015-02-29", pp);
//            System.out.println("Info! " + t + "/" + pp); // note, no error in pp here!
//            // Info! {DayOfMonth=29, MonthOfYear=2, Year=2015},null,null/java.text.ParsePosition[index=10,errorIndex=-1]
//            boolean leapyear = Year.from(t).isLeap();
//            MonthDay md = MonthDay.from(t);
//            if (!leapyear && md.getDayOfMonth() == 29 && md.getMonth().getValue() == 2) {
//                System.out.println("Error!"); // hand-made validation covering a special case
//            }
//        } catch (RuntimeException e) {
//            e.printStackTrace(); // does not happen for given input
//
//        }finally {
//            return res;
//        }
//
//
//
//
//    }



    public static String[] stringArray(final String text) {

        String[] arrOfStr = text.split(" ", 0);
        return arrOfStr;

    }

    //function for whiteSpace

    public static boolean hasWhiteSpace(String text){
        if (Character.isWhitespace(text.charAt(0)) || Character.isWhitespace(text.charAt(text.length()-1))){
            return true;
        }
        return false;

    }

    public static boolean validtextFormat(final SMS sms){

//        String fname = "";
//        String Bdate = "";
//        String address = "";

        String text = sms.getMessage();


        boolean res = true;

        UserInformation ui = separator(text);


        //IF NULL

        if (ui==null){
            return false;
        }

//         INVALID DATE FORMAT
        if (!rightDateFormat(ui.getBdate())) {
            return false;
        }

        // ONE WORD IN NAME
        if (stringArray(ui.getFname()).length <= 1) {
            return false;
        }

        // ONE WORD IN CITY AND "CITY" IS NOT ENTERED
        if(stringArray(ui.getAddress()).length <= 1 || !ui.getAddress().toLowerCase().matches("(.*)city")){
            return false;
        }

        //IF THERE'S WHITE SPACE

        if(hasWhiteSpace(ui.getFname())|| hasWhiteSpace(ui.getBdate()) || hasWhiteSpace(ui.getAddress())){
            return false;
        }


        return res;

    }

    //COMMA AS SEPARATOR

    public static UserInformation separator (final String details) {

        String[] arrayOfString = details.split(", ", 3);

        if (arrayOfString.length == 3) {
            return new UserInformation (arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        } else {
            return null;
        }


    }

    public static void main(String[] args) {
        UserInformation ui = separator  ("   Marco Valmores   ,    1973-09-10    ,     Marikina City   ");
        System.out.println(stringArray("asdf jkl; 2qewq zxcvouio asdfasdf, asdfasdfasdf"));
        System.out.println(hasWhiteSpace(" aaa "));











    }


}