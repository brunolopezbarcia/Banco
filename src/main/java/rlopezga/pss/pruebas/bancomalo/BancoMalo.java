package rlopezga.pss.pruebas.bancomalo;

import java.util.ArrayList;
import java.util.List;

public class BancoMalo {
	
	String nombreBanco;
	
	List<CuentaBancaria> cuentas;

	public BancoMalo(String nombreBanco) {
		super();
		this.nombreBanco = nombreBanco;
		this.cuentas = new ArrayList<CuentaBancaria>();
	}

	public String getNombreBanco() {
		return nombreBanco;
	}
	
	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public CuentaBancaria getCuenta(String id) {
		for (int i = 0; i < cuentas.size(); i++) {
			CuentaBancaria cuentaActual = cuentas.get(i);
			if (cuentaActual.numeroCuenta.equals(id)) {
				return cuentaActual;
			}
		}
		
		return null;
	}
	
	public void agregarCuenta(CuentaBancaria cuentaBancaria) {
		cuentas.add(cuentaBancaria);
	}
	
	public boolean quitarCuenta(String id) {
		int posicion = -1;
		
		for (int i = 0; i < cuentas.size(); i++) {
			CuentaBancaria cuentaActual = cuentas.get(i);
			if (cuentaActual.numeroCuenta.equals(id)) {
				posicion = i;
				break;
			}
		}
		
		try {
			cuentas.remove(posicion);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
}
