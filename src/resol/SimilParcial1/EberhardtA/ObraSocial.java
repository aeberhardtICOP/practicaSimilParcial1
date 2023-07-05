package resol.SimilParcial1.EberhardtA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ObraSocial {
private String direccion;
private String localidad;
private String razonSocial;
private ArrayList<Persona>personas;
private HashMap<Integer, String>localidades;
Scanner scanner = new Scanner(System.in);
public ObraSocial(String direccion, String localidad, String razonSocial) {
	this.direccion = direccion;
	this.localidad = localidad;
	this.razonSocial = razonSocial;
	this.personas = new ArrayList();
	this.localidades = new HashMap();
}
//localidades
public void mostrarLocalidades() {
	for (Map.Entry<Integer, String> entry : localidades.entrySet()) {
		String loc=entry.getValue();
		int codPostal=entry.getKey();
		System.out.println("Cod. de area: " + codPostal + " Localidad: "+loc);
	}	
}
public boolean validarLocalidad(int codigo) {
	if(localidades.containsKey(codigo)) {
		return true;
	}else {
		return false;
	}
}
public void agregarLocalidad(int codArea, String localidad) {
	localidades.put(codArea, localidad);
}
public void agregarLocalidad() {
	System.out.println("-------------------");
	System.out.println("Ingrese nombre de localidad: ");
	String nom = scanner.nextLine();
	System.out.println("Ingrese codigo de area: ");
	int cod = scanner.nextInt();
	localidades.put(cod, nom);
}
//persona
public void mostrarPersona() {
	System.out.println("----------------------------");
	System.out.println("Ingrese que desea listar: ");
	System.out.println("1)Afiliados\n2)Empleados\n3)TODOS");
	System.out.print("Opcion: ");
	int o = scanner.nextInt();
	switch(o) {
	case 1:
		for (int i=0;i<personas.size();i++) {
			if (personas.get(i)instanceof Afiliado){
				personas.get(i).mostrar();
			}
		}
		break;
	case 2: 
		for (int i=0;i<personas.size();i++) {
			if (personas.get(i)instanceof Empleado){
				personas.get(i).mostrar();
			}
		}
		break;
	case 3:
		for (int i=0;i<personas.size();i++) {
				personas.get(i).mostrar();
		}
		break;
	default:
		System.out.println("No ingreso opcion valida");
	}
	System.out.println();
}
public void agregarPersona(Persona persona) {
	personas.add(persona);
}
//Empleado
public void cargarEmpleado() {
	Empleado empleado = new Empleado();
	System.out.println("Carga de domicilio");
	Domicilio domicilio = new Domicilio();
	System.out.println("Localidad:");
	System.out.println("Localidades con cobertura: ");
	mostrarLocalidades();
	int cod=0;
	do {
	System.out.println("Ingrese codigo de area: ");
	cod = scanner.nextInt();
	}while(validarLocalidad(cod)!=true);
	System.out.println("Validacion correcta!");
	domicilio.setLocalidad(cod);
	empleado.setDomicilio(domicilio);
	personas.add(empleado);
}
public void mostrarAgentesAfiliadores() {
	for (int i=0; i<personas.size();i++) {
		if (personas.get(i) instanceof Empleado) {
			Empleado empleado = (Empleado)personas.get(i);
			if(empleado.getCargo()==cargo.AGENTE_AFILIADOR) {
				System.out.println(empleado.getNroLegajo()+" "+empleado.getNombre()+" "+empleado.getApellido());;
			}
		}
	}
}
//Afiliado
public void cargarAfiliado() {
	Afiliado afiliado=new Afiliado();
	System.out.println("Empleados disponibles: ");
	mostrarAgentesAfiliadores();
	System.out.println("Ingrese Nro del agente afiliador: ");
	int nroLeg=scanner.nextInt();
	for (int i=0;i<personas.size();i++) {
		if (personas.get(i) instanceof Empleado) {
			Empleado empleado = (Empleado)personas.get(i);
			if (empleado.getNroLegajo()==nroLeg) {
				afiliado.setAgenteAfiliador(empleado);
			}
		}
	}
	System.out.println("Carga de domicilio");
	Domicilio domicilio = new Domicilio();
	System.out.println("Localidad:");
	System.out.println("Localidades con cobertura: ");
	mostrarLocalidades();
	int cod=0;
	do {
	System.out.println("Ingrese codigo de area: ");
	cod = scanner.nextInt();
	}while(validarLocalidad(cod)!=true);
	System.out.println("Validacion correcta!");
	domicilio.setLocalidad(cod);
	afiliado.setDomicilio(domicilio);	
	personas.add(afiliado);
}
//domicilios
public void agregarDomicilio(String barrio, String calle, int nro, int localidad) {
	Domicilio domicilio = new Domicilio(barrio, calle, nro, localidad);
	
}
//mostrar obra social
public void mostrar() {
	System.out.println("--------------------");
	System.out.println("- "+this.razonSocial+" -");
	System.out.println("--------------------");
	System.out.println("Direccion: "+this.direccion);
	System.out.println("Localidad: "+this.localidad);
	System.out.println("Localidades con cobertura: ");
	mostrarLocalidades();
	System.out.println("--------------------");
}
//getters & setters
public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getLocalidad() {
	return localidad;
}

public void setLocalidad(String localidad) {
	this.localidad = localidad;
}

public String getRazonSocial() {
	return razonSocial;
}

public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}

public ArrayList<Persona> getPersonas() {
	return personas;
}

public void setPersonas(ArrayList<Persona> personas) {
	this.personas = personas;
}

public HashMap<Integer, String> getLocalidades() {
	return localidades;
}

public void setLocalidades(HashMap<Integer, String> localidades) {
	this.localidades = localidades;
}




}
