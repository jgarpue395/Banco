package es.banco.cuenta;

import es.banco.Operaciones.Operacion;
import es.banco.persona.Persona;
import es.banco.utils.Constantes;

public class CuentaStandard extends Cuenta
{

	public CuentaStandard(Persona owner, String numero) 
	{
		super(owner, numero);
	}
	
	public CuentaStandard(Persona owner, String numero, float balance) 
	{
		super(owner, numero, balance);
	}
	
	/** Metodo - que resta al balance de la cuneta una cantidad introducida mas una comision */
	@Override
	public void sacar(float dineroSacado)
	{
		if(dineroSacado<=0)
		{
			throw new RuntimeException("ERROR!! Cantidad no valida");
		}
		if(dineroSacado>balance)
		{
			throw new RuntimeException("ERROR!! No puedes sacar mas dinero del que tienes");
		}
		balance=balance-(dineroSacado*Constantes.INTERES_APLICABLE);
		System.out.println("Has sacado "+dineroSacado+" euros y tienes un saldo de "+balance);
		Operacion operacion=new Operacion(dineroSacado,"devito");
		theOperations.add(operacion);
	}
}
