package es.banco;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import es.banco.Operaciones.Operacion;
import es.banco.cuenta.Cuenta;

public class Banco 
{
	/** Atributo - mapa que coge como clave el numero de cuenta y tiene como valor clase Cuenta */
	Map<String,Cuenta>banco= new HashMap<String, Cuenta>();
	
	/** Metodo - introduce una nueva cuenta en el mapa */
	public void addAccount(Cuenta cuenta)
	{
		if(banco.containsKey(cuenta.getNumber()))
		{
			throw new RuntimeException("La cuenta que intenta crear ya existe");
		}
		banco.put(cuenta.getNumber(),cuenta);
	}
	
	/** Metodo - elimina del mapa una cuenta */
	public void removeAccount(Cuenta cuenta)
	{
		if(!banco.containsKey(cuenta.getNumber()))
		{
			throw new RuntimeException("La cuenta que intenta eliminar no existe");
		}
		banco.remove(cuenta.getNumber(),cuenta);
	}
	
	/** Metodo - Da un credito a una cuenta */
	public void creditAccount(String numero, float cantidad)
	{
		banco.get(numero).credit(cantidad);
	}
	
	/** Metodo - Saca una cantidad de una cuneta */
	public void withdraw(String numero, float cantidad)
	{
		banco.get(numero).sacar(cantidad);
	}
	
	/** Metodo - que aumenta el deposito de la cuenta */
	public void depositAccount(String numero, float cantidad)
	{
		banco.get(numero).depositar(cantidad);
	}
	
	/** Metodo - hace una transferencia de una cuenta a otra */
	public void transfer(String from, String to, float cantidad)
	{
		/** Reduce la cantidad indicada al dinero guardado en la primera cuenta */
		banco.get(from).sacar(cantidad);
		/** Aumenta la cantidad indicada al dinero guardado en la segunda cuenta */
		banco.get(to).depositar(cantidad);
	}
	
	/** Metodo - muestra por pantalla la informacion de una cuenta */
	public String displayAccount(String numero)
	{
		return banco.get(numero)+"";
	}
	
	public List<Operacion> listOperationsAccount(String numero, Calendar time)
	{
		return banco.get(numero).getOperationsAfter(time);
	}
}
