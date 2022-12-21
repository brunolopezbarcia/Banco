package rlopezga.pss.pruebas.bancomalo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaAhorroTest {

    CuentaAhorro cuentaAhorro1;
    CuentaAhorro cuentaAhorro2;

    @BeforeEach
    void setUp() {
        cuentaAhorro1 = new CuentaAhorro("a1111", 500.0);
        cuentaAhorro2 = new CuentaAhorro("a2222", 1000.0);
    }

    @AfterEach
    void tearDown() {
        cuentaAhorro1 = null;
        cuentaAhorro2 = null;
    }


@Test
void getNumeroCuentaAhorro(){
    Assertions.assertEquals("a1111", cuentaAhorro1.getNumeroCuenta());
    Assertions.assertEquals("a2222", cuentaAhorro2.getNumeroCuenta());
}

@Test
void getSaldoCuentaAhorro(){
    Assertions.assertEquals(500.0, cuentaAhorro1.getSaldo());
    Assertions.assertEquals(1000.0, cuentaAhorro2.getSaldo());
}

@Test
void ingresarCuentaAhorro(){
    // Ingresaremos 100€
    Double pre_ingreso_cuenta_ahorro1 = cuentaAhorro1.getSaldo();
    cuentaAhorro1.ingresar(100);
    Assertions.assertTrue(pre_ingreso_cuenta_ahorro1 <= cuentaAhorro1.getSaldo());
    Assertions.assertEquals(600.0, cuentaAhorro1.getSaldo());
}

@Test
void cuentaAhorro_ingresar_negativo() {
    //Ingresamos una cantidad negativa(utilizaremos la cuenta2)
    double pre_ingreso_cuenta_ahorro_2 = cuentaAhorro2.getSaldo();
    Exception exception = assertThrows(IllegalArgumentException.class,() -> cuentaAhorro2.ingresar(-1000.0));
    Assertions.assertEquals("No se puede ingresar una cantidad de dinero negativa", exception.getMessage());
    Assertions.assertEquals(1000.0, cuentaAhorro2.getSaldo());
    Assertions.assertTrue(pre_ingreso_cuenta_ahorro_2 == cuentaAhorro2.getSaldo());
}

@Test
void retirar() {
    // Retiraremos 100 €
    double pre_retirada_cuenta_ahorro_1 = cuentaAhorro1.getSaldo();
    cuentaAhorro1.retirar(100);
    Assertions.assertTrue(pre_retirada_cuenta_ahorro_1 >= cuentaAhorro1.getSaldo());
    Assertions.assertEquals(400.0, cuentaAhorro1.getSaldo());
}

@Test
void retirar_cantidad_negativa(){
    // Retiraremos -1000€
    double pre_retirada_cuenta_ahorro_2 = cuentaAhorro2.getSaldo();
    Exception exception = assertThrows(IllegalArgumentException.class,() -> cuentaAhorro2.retirar(-1000.0));
    Assertions.assertEquals("No se puede retirar una cantidad de dinero negativa", exception.getMessage());
    Assertions.assertEquals(1000.0, cuentaAhorro2.getSaldo());
    Assertions.assertTrue(pre_retirada_cuenta_ahorro_2 == cuentaAhorro2.getSaldo());
}

@Test
void retirar_mas_de_lo_que_tiene() {
// Retirar mas dinero del disponible en la cuenta
double pre_retirada_cuenta_ahorro_3 = cuentaAhorro2.getSaldo();
Exception exception = assertThrows(IllegalArgumentException.class,() -> cuentaAhorro2.retirar(2000.0));
Assertions.assertEquals("No se puede dejar una cuenta de ahorro en números rojos", exception.getMessage());
Assertions.assertEquals(1000.0, cuentaAhorro2.getSaldo());
Assertions.assertTrue(pre_retirada_cuenta_ahorro_3 >= cuentaAhorro2.getSaldo());
}

}

