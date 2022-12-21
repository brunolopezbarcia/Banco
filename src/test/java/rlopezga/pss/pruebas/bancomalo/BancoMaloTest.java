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
    void getCuenta() {
        Assertions.assertEquals(cuenta1, banco1.getCuenta("1111"));
        Assertions.assertEquals(null, banco1.getCuenta("2222"));
    }

    @Test
    void agregarCuenta_que_no_existe() {
        Assertions.assertEquals(1, banco1.getCuentas().size()); // Debido cuando iniciamos los test añadimos una
        banco1.agregarCuenta(cuenta2); // No estaba añadida anteriormente
        Assertions.assertEquals(2, banco1.getCuentas().size());
    }
    @Test
    void agregarCuenta_que_si_existe() {
        Assertions.assertEquals(1, banco1.getCuentas().size()); // Debido cuando iniciamos los test añadimos una
        Exception exception = assertThrows(IllegalArgumentException.class, () -> banco1.agregarCuenta(cuenta1)); // Si estaba añadida anteriormente)
        Assertions.assertEquals("Ese numero de cuenta ya existe", exception.getMessage());
        Assertions.assertEquals(1, banco1.getCuentas().size());
    }

    @Test
    void quitarCuenta_que_si_existe() {
        Assertions.assertTrue(banco1.quitarCuenta("1111"));
        Assertions.assertEquals(0, banco1.getCuentas().size());

    }
    @Test
    void quitarCuenta_que_no_existe() {
        Assertions.assertFalse(banco1.quitarCuenta("CuentaQueNoExiste"));
        Assertions.assertEquals(1, banco1.getCuentas().size());

    }
}