//package test;
//
//
//
//
//import org.junit.Test;
//import service.Calculator;
//
//import static org.junit.Assert.*;
//
//
//public class TestCalculator {
//
//    final String cadetship = "Cadetships";
//    final int value = 100;
//
//
//    @Test //anitation? annotation?
//    public void testAdd(){
//        Calculator calc = new Calculator();
//        Calculator calc_2 = calc;
//        Calculator calc_3 = calc;
//
//        assertEquals(-22, Calculator.add(-12,-1,-3,-4,-2));
//        assertEquals(10, Calculator.add(1,3,4,2));
//        assertEquals("Cadetships", cadetship);
//        assertFalse(value < 6);
//        assertNotNull(calc);
//
//    }
//
//}