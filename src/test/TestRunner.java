//package test;
//
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import org.junit.runner.JUnitCore;
//
//
//
//
//public class TestRunner {
//
//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(TestCalculator.class);
//
//        for(Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(result.wasSuccessful());
//    }
//
//}