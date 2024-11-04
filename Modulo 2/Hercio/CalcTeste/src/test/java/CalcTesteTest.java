/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.calcteste.CalcTeste;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author GUILHERMEMATHIACK
 */
public class CalcTesteTest {
    
    public CalcTesteTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSoma() {
        CalcTeste calculadora = new CalcTeste();
        
        int resultado = calculadora.soma(5, 3);
        assertEquals(8,resultado,"5 + 3 = 8");
    }
    
    @Test
    public void testSubtrai() {
        CalcTeste calculadora = new CalcTeste();
        
        int resultado = calculadora.subtrai(5, 3);
        assertEquals(2,resultado,"5 - 3 = 2");
    }
    
    @Test
    public void testMult() {
        CalcTeste calculadora = new CalcTeste();
        
        int resultado = calculadora.mult(5, 3);
        assertEquals(15,resultado,"5 * 3 = 15");
    }
    
    @Test
    public void testDiv() {
        CalcTeste calculadora = new CalcTeste();
        
        int resultado = calculadora.div(5, 5);
        assertEquals(1,resultado,"5/5 = 1");
    }
}
