package de.telran;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
//    @Spy
//    Main main;
    Main main = Mockito.mock(Main.class);
    @Test
    void mainTest() {
        Mockito.when(main.makePaymentTest()).thenReturn(true);
        boolean actualResult = main.makePaymentTest();
        Assertions.assertTrue(actualResult);
        Mockito.verify(System.out,Mockito.times(5)).println(Mockito.anyString());
    }
}