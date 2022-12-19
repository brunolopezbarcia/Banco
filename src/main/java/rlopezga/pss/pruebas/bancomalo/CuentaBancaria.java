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
		/* TODO corregir tras realizar el test de ingreso de CuentaAhorro. */
		saldo += cuanto;
		return saldo;
	}
	
	public double retirar(double cuanto)
	 {
		 if (cuanto >= 0) {
			 saldo -= cuanto;
		 } else {
			 throw new IllegalArgumentException("No se puede retirar una cantidad de dinero negativa");
		 }
		return saldo;
	}
}
