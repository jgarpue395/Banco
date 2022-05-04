package es.banco;

import java.util.Calendar;
import es.banco.Operaciones.Operacion;
import es.banco.cuenta.Cuenta;
import es.banco.cuenta.CuentaBonus;
import es.banco.cuenta.CuentaProtegida;
import es.banco.cuenta.CuentaStandard;
import es.banco.persona.Persona;

public class Main {

	public static void main(String[] args) 
	{
		try
		{
			/** Instanciamos la clase Banco */
			Banco bank=new Banco();
			/** Creamos un atributo Calendar*/
			Calendar time;
			/** Creamos 3 instancias de la clase persona */
			Persona p1=new Persona("Jose",40,"masculino");
			Persona p2=new Persona("Maria",35,"femenino");
			Persona p3=new Persona("Jose",33,"masculino");
			/** Creamos 3 instancias de las Cuentas */
			Cuenta c1=new CuentaProtegida(p1,"number1",100);
			Cuenta c2=new CuentaBonus(p2,"number2",1500);
			Cuenta c3=new CuentaStandard(p3,"number3",1000);
			/** creamos tres cuentas diferentes */
			bank.addAccount(c1);
			bank.addAccount(c2);
			bank.addAccount(c3);
			/** Variables para mostrar operaciones despues de una fecha */
			time=Calendar.getInstance();
			time.set(Calendar.HOUR,-2);
			/** diferentes operaciones */
			bank.creditAccount("number1", 1000);
			bank.depositAccount("number1", 100);
			bank.creditAccount("number2", 500);
			bank.withdraw("number3", 100);
			bank.transfer("number1", "number3", 100);
			/** mostramos las cuentas */
			System.out.println(bank.displayAccount("number1"));
			System.out.println(bank.displayAccount("number2"));
			System.out.println(bank.displayAccount("number3"));
			/** mostrar operaciones desde fecha para una cuenta */
			System.out.print("\nOperaciones de number1 desde "+time.getTime());
			for(Operacion o: bank.listOperationsAccount("number1", time))
			{
				System.out.print(o);
			}
		}
		catch (RuntimeException rte)
		{
			System.out.println(rte.getMessage());
		}
		finally
		{
			System.out.println("Fin del programa");
		}
	}

}
