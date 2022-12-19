package rlopezga.pss.pruebas.bancomalo;

public class CuentaAhorro extends CuentaBancaria {

	public CuentaAhorro(String numeroCuenta, double saldo) {
		super("_" + numeroCuenta, saldo);
	}
	
	@Override
	public double retirar(double cuanto)
	throws IllegalArgumentException {
		double nuevoSaldo = super.retirar(cuanto);
		
		if (nuevoSaldo < 0) {
			throw new IllegalArgumentException("No se puede dejar una cuenta de ahorro en números rojos");
		} else {
			return nuevoSaldo;
		}
	}
}
