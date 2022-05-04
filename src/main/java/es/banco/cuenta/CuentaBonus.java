package es.banco.cuenta;

import es.banco.Operaciones.Operacion;
import es.banco.persona.Persona;
import es.banco.utils.Constantes;

public class CuentaBonus extends Cuenta 
{
	public CuentaBonus(Persona owner, String numero) 
	{
		super(owner, numero);
	}
	
	public CuentaBonus(Persona owner, String numero, float balance) 
	{
		super(owner, numero, balance);
	}
	
	/** Metodo - que resta al balance de la cuneta una cantidad introducida y el banco te da una comision */
	@Override
	public void credit (float credito)
	{
		if(balance<=0)
		{
			throw new RuntimeException("Lo sentimos pero no te damos el credito, y que no creemos que lo vaya a devolver");
		}
		if(credito<=0)
		{
			throw new RuntimeException("ERROR!! Cantidad no valida");
		}
		balance=balance+credito*Constantes.BONUSRATE;
		System.out.println("Has sacado "+credito*Constantes.BONUSRATE+" euros y tienes un saldo de "+balance);
		Operacion operacion=new Operacion(credito*Constantes.BONUSRATE,"deposito");
		theOperations.add(operacion);
	}
}
