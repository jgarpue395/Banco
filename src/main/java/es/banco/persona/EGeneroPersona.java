package es.banco.persona;

public enum EGeneroPersona 
{
	MASCULINO,FEMENINO;
	
	public static EGeneroPersona getStateEnumFromString(String typeString)
	{
		EGeneroPersona genero = null ;
							
		if ("maculino".equalsIgnoreCase(typeString))
		{
			genero = MASCULINO ;
		}
		else if ("femenino".equalsIgnoreCase(typeString))
		{
			genero = FEMENINO ;
		}
		return genero;
	}
}
