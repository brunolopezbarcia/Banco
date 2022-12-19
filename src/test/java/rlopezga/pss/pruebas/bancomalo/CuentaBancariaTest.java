package rlopezga.pss.pruebas.bancomalo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {

    CuentaBancaria cuentaBancaria1;
    CuentaBancaria cuentaBancaria2;

    @BeforeEach
    void setUp() {
        cuentaBancaria1 = new CuentaBancaria("1111", 500.0);
        cuentaBancaria2 = new CuentaBancaria("2222", 12000.0);
    }

    @AfterEach
    void tearDown() {
        cuentaBancaria1 = null;
        cuentaBancaria2 = null;
    }

    @Test
    void getNumeroCuentaBancaria() {
        Assertions.assertEquals("1111", cuentaBancaria1.getNumeroCuenta());
        Assertions.assertEquals("2222", cuentaBancaria2.getNumeroCuenta());
    }

    @Test
    void getSaldo() {
        Assertions.assertEquals(500.0, cuentaBancaria1.getSaldo());
        Assertions.assertEquals(12000.0, cuentaBancaria2.getSaldo());
    }

    @Test
    void cuentaBancariaingresar() {
        // Ingresaremos 100€
        Double pre_ingreso_cuenta_bancaria1 = cuentaBancaria1.getSaldo();
        cuentaBancaria1.ingresar(100);
        Assertions.assertTrue(pre_ingreso_cuenta_bancaria1 <= cuentaBancaria1.getSaldo());
        Assertions.assertEquals(600.0, cuentaBancaria1.getSaldo());

        //Ingresamos una cantidad negativa(utilizaremos la cuenta2)
        double pre_ingreso_cuenta_bancaria_2 = cuentaBancaria2.getSaldo();
        cuentaBancaria2.ingresar(-1000.0);
        Assertions.assertEquals(12000.0, cuentaBancaria2.getSaldo());
        Assertions.assertTrue(pre_ingreso_cuenta_bancaria_2 == cuentaBancaria2.getSaldo());
    }

    @Test
    void retirar() {
        // Retiraremos 100 €
        double pre_retirada_cuenta_bancaria_1 = cuentaBancaria1.getSaldo();
        cuentaBancaria1.retirar(100);
        Assertions.assertTrue(pre_retirada_cuenta_bancaria_1 >= cuentaBancaria1.getSaldo());
        Assertions.assertEquals(400.0, cuentaBancaria1.getSaldo());

        // Retiraremos -1000€
        double pre_retirada_cuenta_bancaria_2 = cuentaBancaria2.getSaldo();
        Exception exception = assertThrows(IllegalArgumentException.class,() -> cuentaBancaria2.retirar(-1000.0));
        Assertions.assertEquals("No se puede retirar una cantidad de dinero negativa", exception.getMessage());
        Assertions.assertEquals(12000.0, cuentaBancaria2.getSaldo());
        Assertions.assertTrue(pre_retirada_cuenta_bancaria_2 == cuentaBancaria2.getSaldo());

        // Retirar mas dinero del disponible en la cuenta
        double pre_retirada_cuenta_bancaria_3 = cuentaBancaria2.getSaldo();
        cuentaBancaria2.retirar(13000.0);
        Assertions.assertEquals(-1000.0, cuentaBancaria2.getSaldo());
        Assertions.assertTrue(pre_retirada_cuenta_bancaria_3 >= cuentaBancaria2.getSaldo());
    }
}