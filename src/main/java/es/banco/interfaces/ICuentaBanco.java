package es.banco.interfaces;

import java.util.Calendar;
import java.util.List;

import es.banco.Operaciones.Operacion;
import es.banco.persona.Persona;

public interface ICuentaBanco 
{
	/** Metodo - que pone un asigna un valor a credito */
	public void credit(float credito);
	/** Metodo - metodo que sirve para decrementar la cantidad de dinero en la cuneta */
	public void sacar(float dineroSacado);
	/** Metodo - metodo que sirve para incrementar la cantidad de dinero en la cuneta */
	public void depositar(float dineroDepositado);
	/** Metodo - Te devuelve la informacion de la persona propietaria de la cuenta */
	public Persona getOwner();
	/** Metodo - que devuelve el numero de cuenta */
	public String getNumber();
	/** Metodo - que devuelve el balance de la cuenta / hay que sumar y restar las transacciones para ver 
	 *  si es positivo o negativo
	 */
	public float getBalanced();
	/** Metodo - que devuelve el numero de operaciones a partir de la fecha de una cuenta */
	public List<Operacion> getOperationsAfter(Calendar time);
}
