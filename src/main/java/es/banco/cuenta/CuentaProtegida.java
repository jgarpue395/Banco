package es.banco.cuenta;

import es.banco.Operaciones.Operacion;
import es.banco.persona.Persona;
import es.banco.utils.Constantes;

public class CuentaProtegida extends Cuenta 
{
	public CuentaProtegida(Persona owner, String numero)
	{
		super(owner, numero);
	}

	public CuentaProtegida(Persona owner, String numero, float balance) 
	{
		super(owner, numero, balance);
	}
		
	/** Metodo - que resta al balance de la cuneta una cantidad introducida siempre que esa cantidad supere el minimo */
	@Override
	public void sacar (float dineroSacado)
	{
		if(dineroSacado<=0)
		{
			throw new RuntimeException("ERROR!! Cantidad no valida");
		}
		if(dineroSacado>balance)
		{
			throw new RuntimeException("ERROR!! No puedes sacar mas dinero del que tienes");
		}
		if(dineroSacado>=Constantes.LOWERBOUND)
		{
			balance=balance-dineroSacado;
			System.out.println("Has sacado "+dineroSacado+" euros y tienes un saldo de "+balance);
			Operacion operacion=new Operacion(dineroSacado,"devito");
			theOperations.add(operacion);
		}
		else
		{
			System.out.println("Has intentado sacar "+dineroSacado+" euros y lo minimo que puedes sacar es "+Constantes.LOWERBOUND);
		}
	}
}
