package rlopezga.pss.pruebas.bancomalo;

public class CuentaAhorro extends CuentaBancaria {

	public CuentaAhorro(String numeroCuenta, double saldo) {
		super( numeroCuenta, saldo);
	}
	
	@Override
	public double retirar(double cuanto)
	throws IllegalArgumentException {
		double saldoActual = super.getSaldo();
		if (cuanto <= saldoActual) {
			if (cuanto >= 0) {
				double nuevoSaldo = super.retirar(cuanto);
				return nuevoSaldo;
			} else {
				throw new IllegalArgumentException("No se puede retirar una cantidad de dinero negativa");
			}
		} else {
			throw new IllegalArgumentException("No se puede dejar una cuenta de ahorro en números rojos");
		}
	}
}
