package com.example.loginactivity;

public class GlobalVariable {
    private static String passNameToPageTwo;
    private static String passEmailToPageTwo;
    private static String passPasswordToPageTwo;

    public static String getPassNameToPageTwo() {
        return passNameToPageTwo;
    }

    public static void setPassNameToPageTwo(String passNameToPageTwo) {
        GlobalVariable.passNameToPageTwo = passNameToPageTwo;
    }

    public static String getPassEmailToPageTwo() {
        return passEmailToPageTwo;
    }

    public static void setPassEmailToPageTwo(String passEmailToPageTwo) {
        GlobalVariable.passEmailToPageTwo = passEmailToPageTwo;
    }

    public static String getPassPasswordToPageTwo() {
        return passPasswordToPageTwo;
    }

    public static void setPassPasswordToPageTwo(String passPasswordToPageTwo) {
        GlobalVariable.passPasswordToPageTwo = passPasswordToPageTwo;
    }

}
