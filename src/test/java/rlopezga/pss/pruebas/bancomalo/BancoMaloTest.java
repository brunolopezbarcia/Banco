package rlopezga.pss.pruebas.bancomalo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BancoMaloTest {

    BancoMalo banco1;
    BancoMalo banco2;
    CuentaBancaria cuenta1;
    CuentaBancaria cuenta2;
    @BeforeEach
    void setUp() {
        banco1 = new BancoMalo("Banco1");
        banco2 = new BancoMalo("Banco2");
        cuenta1 = new CuentaBancaria("1111", 10);
        cuenta2 = new CuentaBancaria("2222", 20);
        banco1.agregarCuenta(cuenta1);
    }

    @AfterEach
    void tearDown() {
        banco1 = null;
        banco2 = null;
    }

    @Test
    void getNombreBanco() {
        Assertions.assertEquals("Banco1", banco1.getNombreBanco());
        Assertions.assertEquals("Banco2", banco2.getNombreBanco());
    }

    @Test
    void getCuentas() {
        Assertions.assertEquals(1, banco1.getCuentas());
    }

    @Test
    void getCuenta() {
        Assertions.assertEquals(cuenta1, banco1.getCuenta("1111"));
        Assertions.assertEquals(null, banco1.getCuenta("2222"));
    }

    @Test
    void agregarCuenta() {
    }

    @Test
    void quitarCuenta() {
    }
}