package es.banco.persona;

public class Persona
{
	/** Atributo - nombre de la persona */
	private String nombre;
	/** Atributo - edad de la persona */
	private int edad;
	/** Atributo -  genero de la persona */
	private EGeneroPersona genero;
	/**
	 * Constructor que inicializa los valores de:
	 * @param nombre nombre de la persona
	 * @param apellido primer apellido de la persona
	 * @param edad de la persona
	 * @param genero de la persona
	 */
	public Persona(String nombre, int edad, String genero) 
	{
		this.nombre = nombre;
		this.edad = edad;
		this.genero = EGeneroPersona.getStateEnumFromString(genero);
	}
		
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + "]";
	}
}
