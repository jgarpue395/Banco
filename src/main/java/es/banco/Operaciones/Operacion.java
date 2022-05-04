package es.banco.Operaciones;

import java.util.Date;

public class Operacion
{
	private float cantidad;
	private Date fecha;
	private ETipoOperaciones tipo;
	
	/**
	 * Contructor que recoge los datos:
	 * @param dineroDepositado que se mueve en la operacion.
	 * @param string indica si se trata de un debito o un deposito.
	 * Y ademas inicializa la fecha a la que esta en el momento de ejecucion.
	 */
	
	public Operacion(float cantidad, String tipo) 
	{
		this.cantidad = cantidad;
		this.fecha = new Date();
		this.tipo = ETipoOperaciones.getStateEnumFromString(tipo);
	}

	@Override
	public String toString()
	{
		return "Operacion [cantidad=" + cantidad + ", fecha=" + fecha + ", tipo=" + tipo + "]";
	}

	public Date getFecha()
	{
		return fecha;
	}
}
