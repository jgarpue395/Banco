package es.banco.Operaciones;

public enum ETipoOperaciones 
{
	DEBITO,DEPOSITO;
	
	public static ETipoOperaciones getStateEnumFromString(String typeString)
	{
		ETipoOperaciones tipo = null ;
							
		if ("debito".equalsIgnoreCase(typeString))
		{
			tipo = DEBITO ;
		}
		else if ("deposito".equalsIgnoreCase(typeString))
		{
			tipo = DEPOSITO ;
		}
		return tipo;
	}
}
