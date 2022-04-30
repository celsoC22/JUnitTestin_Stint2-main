package test;

import org.junit.Test;
import sms.SMSChecker;
import sms.model.Register;
import sms.model.SMS;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSMSChecker {

//    @Test
//    public void testMapThreeEntries(){
//        HashMap<String, String> entry = new HashMap<>();
//        SMS sms = new SMS();
//        entry.put("Mobile number", "9055271234");
//        entry.put("Message", "PROMO");
//        entry.put("Short Code", "1234555");
//
//        HashMap<String, String> entryOne = new HashMap<>();
//        entryOne.put("Mobile number", "9055271234");
//
//
//        HashMap<String, String> entryFour = new HashMap<>();
//        entryFour.put("Mobile number", "9055271234");
//        entryFour.put("Message", "PROMO");
//        entryFour.put("Short Code", "1234555");
//        entryFour.put("Some Name", "1234555");
//
//        assertFalse(SMSChecker.check(entry, sms));
//        assertFalse(SMSChecker.check(entryOne, sms));
//        assertFalse(SMSChecker.check(entryFour, sms));
//
//    }

    @Test  //Testing Valid format (Register,REGISTER,register) without leading and trailing spaces

    public void validateRegister1() {

        Register sms = new Register();


        HashMap<String, String> entry1 = new HashMap<>();
        entry1.put("Message", "Register");

        HashMap<String, String> entry2 = new HashMap<>();
        entry2.put("Message", "REGISTER");

        HashMap<String, String> entry3 = new HashMap<>();
        entry3.put("Message", "register");

        assertTrue(SMSChecker.checkRegister(entry1, sms));
        assertTrue(SMSChecker.checkRegister(entry2, sms));
        assertTrue(SMSChecker.checkRegister(entry3, sms));
    }


    @Test //Testing Valid format (Register,REGISTER,register) with leading and trailing spaces

    public void validateRegister2() {

        Register sms = new Register();

        HashMap<String, String> entry4 = new HashMap<>();
        entry4.put("Message", " Register ");

        HashMap<String, String> entry5 = new HashMap<>();
        entry5.put("Message", " REGISTER ");

        HashMap<String, String> entry6 = new HashMap<>();
        entry6.put("Message", " register ");

        assertTrue(SMSChecker.checkRegister(entry4,sms));
        assertTrue(SMSChecker.checkRegister(entry5,sms));
        assertTrue(SMSChecker.checkRegister(entry6,sms));

    }


    @Test   //Testing inValid format (regi ster,r egister,r3g1$T3R)
    public void validateRegister3() {
        Register sms = new Register();

        HashMap<String , String> entry7 = new HashMap<>();
        entry7.put("Message","regi ster");

        HashMap<String , String> entry8 = new HashMap<>();
        entry8.put("Message","r egister");

        HashMap<String , String> entry9 = new HashMap<>();
        entry9.put("Message","r3g1$T3R");

        assertFalse(SMSChecker.checkRegister(entry7,sms));
        assertFalse(SMSChecker.checkRegister(entry8,sms));
        assertFalse(SMSChecker.checkRegister(entry9,sms));

    }

    @Test
    public void userInformationReceived() {

        // assert true
        SMS testSMS1 = new SMS();
        SMS testSMS2 = new SMS();
        SMS testSMS3 = new SMS();
        SMS testSMS4 = new SMS();
        SMS testSMS5 = new SMS();
        SMS testSMS6 = new SMS();

        testSMS1.setMessage("Marco Valmores, 1973-09-10, Marikina City");
        testSMS2.setMessage("  Marco Valmores  , 1973-09-10,   Marikina City  ");
        testSMS3.setMessage("MarcoValmores, 1973-09-10, Marikina City");
        testSMS4.setMessage("Marco Valmores, 1973-09-10, Marikina C");
        testSMS5.setMessage("Marco Valmores, -1973-09-10, Marikina City");

        assertTrue(SMSChecker.validtextFormat(testSMS1));
        assertFalse(SMSChecker.validtextFormat(testSMS2));
        assertFalse(SMSChecker.validtextFormat(testSMS3));
        assertFalse(SMSChecker.validtextFormat(testSMS4));
        assertTrue(SMSChecker.validtextFormat(testSMS5));


    }

}
