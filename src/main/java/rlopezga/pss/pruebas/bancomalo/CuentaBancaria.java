package rlopezga.pss.pruebas.bancomalo;

public class CuentaBancaria {
	
	protected String numeroCuenta;
	
	protected double saldo;
	
	public CuentaBancaria(String numeroCuenta, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	private void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public double ingresar(double cuanto) {
		saldo += cuanto;
		return saldo;
	}
	
	public double retirar(double cuanto)
	throws IllegalArgumentException {
		saldo -= cuanto;
		return saldo;
	}
}
