package es.banco.cuenta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import es.banco.Operaciones.Operacion;
import es.banco.interfaces.ICuentaBanco;
import es.banco.persona.Persona;

public abstract class Cuenta implements ICuentaBanco
{
	/** Atributo - Indica el titular de la cuenta */
	private Persona owner;
	/** Atributo - Numero de cuenta */
	private String numero;
	/** Atributo - Indica cantidad de dinero en la cuenta */
	protected float balance;
	/** Atributo - ArrayList donde se guardan las operaciones */
	List<Operacion>theOperations=new ArrayList<Operacion>();
	/**
	 * Constructor que recoge los parametros:
	 * @param owner datos del propietario
	 * @param numero de cuenta
	 * Ademas inicializa los valores por defecto de balance y de la lista de operaciones.
	 */
	public Cuenta(Persona owner, String numero) 
	{
		this.owner = owner;
		this.numero = numero;
		this.balance = 0;
		this.theOperations=null;
	}
	/**
	 * Constructor que recoge los parametros:
	 * @param owner datos del propietario
	 * @param numero de cuenta
	 * @param balance indicando si esta en positivo o en negativo
	 * Ademas inicializa los valores por defecto de la lista de operaciones.
	 */
	public Cuenta(Persona owner, String numero, float balance) 
	{
		this.owner = owner;
		this.numero = numero;
		this.balance = balance;
		this.theOperations=null;
	}
	
	/** Metodo - que muestra las operaciones realizadas despues de una fecha */
	public List<Operacion> getOperationsAfter(Calendar time)
	{
		List<Operacion>theOperationsAfter=new ArrayList<Operacion>();
		for(int i=0;i<this.theOperations.size();i++)
		{
			if((theOperations.get(i).getFecha()).after(time.getTime()))
			{
				theOperationsAfter.add(theOperations.get(i));
			}
		}
		return theOperationsAfter;
	}
	
	/** Metodo - da un credito a una cuneta */
	public void credit(float credito) 
	{
		if(this.balance<=0)
		{
			throw new RuntimeException("Lo sentimos pero no te damos el credito, y que no creemos que lo vaya a devolver");
		}
		if(credito<=0)
		{
			throw new RuntimeException("ERROR!! Cantidad no valida");
		}
		this.balance=this.balance+credito;
		System.out.println("Te han condedido un credito de "+credito+" euros");
		System.out.println("Tienes un saldo de "+this.balance+" euros");
		Operacion operacion=new Operacion(credito,"deposito");
		theOperations.add(operacion);
	}
	
	/** Metodo - saca dinero de la cuenta */
	public void sacar(float dineroSacado)
	{
		if(dineroSacado<=0)
		{
			throw new RuntimeException("ERROR!! Cantidad no valida");
		}
		if(dineroSacado>this.balance)
		{
			throw new RuntimeException("ERROR!! No puedes sacar mas dinero del que tienes");
		}
		balance=balance-dineroSacado;
		System.out.println("Has sacado "+dineroSacado+" euros y tienes un saldo de "+balance);
		Operacion operacion=new Operacion(dineroSacado,"devito");
		theOperations.add(operacion);
	}
	
	/** Metodo - Aumenta el balance en una cantidad introducida*/
	public void depositar(float dineroDepositado)
	{
		if(dineroDepositado<=0)
		{
			throw new RuntimeException("ERROR!! Cantidad no valida");
		}
		this.balance=this.balance+dineroDepositado;
		System.out.println("Has ingresado "+dineroDepositado+" euros y tienes un saldo de "+balance);
		Operacion operacion=new Operacion(dineroDepositado,"deposito");
		theOperations.add(operacion);
	}
	
	/** Metodo - Devuleve las operaciones realizadas por la cuenta */
	public String displayOperations()
	{
		return theOperations+", ";
	}
	
	@Override
	public String toString() 
	{
		return "Cuenta [owner=" + this.owner + ", numero=" + this.numero + ", balance=" + this.balance+"]";
	}
	
	public Persona getOwner() 
	{
		return this.owner;
	}
	public String getNumber()
	{
		return this.numero;
	}
	public float getBalanced()
	{
		return this.balance;
	}
	public void setBalanced(float balance)
	{
		this.balance = balance;
	}
	public List<Operacion> getTheOperations() 
	{
		return this.theOperations;
	}
}
