package resol.SimilParcial1.EberhardtA;

import java.util.Scanner;
public class Principal {
	private static String eleccion="";
	private static void mostrarMenu()
	{
		System.out.println("Menu: ");
		System.out.println("1: Mostrar Informacion Obra Social");
		System.out.println("2: Registrar nuevo afiliado");
		System.out.println("3: Registrar nuevo empleado");
		System.out.println("4: Son estos 2 socios familiares?");
		System.out.println("5: Mostrar persona");
		System.out.println("6: ");
		System.out.println("7: ");
		System.out.println("8: ");
		System.out.println("9: ");
		System.out.println("10:");
		System.out.println("11: ");
		System.out.println("12: ");
		System.out.println("13: ");
		
		System.out.println("q: Salir");	
		System.out.println("");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Opción: ");
		eleccion = scanner.nextLine();

	}
	public static void main(String[] args) {
		ObraSocial obrasoc = new ObraSocial("San martin 1550", "Santa fe", "Inmaculada care");
		obrasoc.agregarLocalidad(3000, "Santa Fe");
		obrasoc.agregarLocalidad(3016, "Santo Tome");
		obrasoc.agregarLocalidad(3018, "Recreo");
		Domicilio domicilio = new Domicilio ("Guadalupe", "Sarimiento",2365, 3000);
		Domicilio domicilio1 = new Domicilio ("Centenario", "San martin",4232, 3000);
		Domicilio domicilio2 = new Domicilio ("Los Hornos", "Guemes",777, 3016);
		Empleado empleado1 = new Empleado("Perez", "Juan", "Masculino", 20123123, "10/10/88", domicilio, "10/10/2000", cargo.ESPECIALIZADO);
		Empleado empleado2 = new Empleado("Alves", "Daniel", "Masculino", 1988523, "10/10/99", domicilio1, "10/10/2000", cargo.AGENTE_AFILIADOR);
		Empleado empleado3 = new Empleado("Lujan", "Lara", "Femenino", 40252698, "25/03/2000", domicilio2, "10/10/2000", cargo.AGENTE_AFILIADOR);
		Afiliado afiliado1 = new Afiliado("Lujan", "Carlos", "Maculino", 12555555, "25/08/1965", domicilio2, true, "12/01/2023", planCobertura.PMO, empleado3);
		Afiliado afiliado2 = new Afiliado("Suarez", "Jose", "Maculino", 19888555, "25/08/1978", domicilio, false, "12/01/2023", planCobertura.PMI, empleado2);
		obrasoc.agregarPersona(empleado1);
		obrasoc.agregarPersona(empleado2);
		obrasoc.agregarPersona(empleado3);
		obrasoc.agregarPersona(afiliado1);
		obrasoc.agregarPersona(afiliado2);
		while (!eleccion.equals("q"))
		 {
			mostrarMenu();	
			switch(eleccion) {
			case "1":
				obrasoc.mostrar();
				break;
			case "2":
				obrasoc.cargarAfiliado();
				break;
			case "3": 
				obrasoc.cargarEmpleado();
				break;
			case "4":
				break;
			case "5":
				obrasoc.mostrarPersona();
			}
		 }
	}
}