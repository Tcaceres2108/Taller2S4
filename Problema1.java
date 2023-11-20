package taller2;


import java.util.Scanner;


//Clase persona que servira para crear las herencias

class Persona  {
String Nombres;
String Apellidos;
String Documento;
String Direccion;
String Telefono;

// Constructor persona

public Persona (String Nombres, String Apellidos, String Documento, String Direccion, String Telefono) {
this.Nombres = Nombres;
this.Apellidos = Apellidos;
this.Documento = Documento;
this.Direccion = Direccion;
this.Telefono = Telefono;
}

// Método para obtener la información del estudiante
public void obtenerInformacion() {
System.out.println("Información del Estudiante:");
System.out.println("Nombres: " + Nombres);
System.out.println("Apellidos: " + Apellidos);
System.out.println("Documento: " + Documento);
System.out.println("Dirección: " + Direccion);
System.out.println("Teléfono: " + Telefono);
}

// Método para calcular el monto de la matrícula
public double calcularMatricula(int semestre, boolean enLinea, boolean aplazaMaterias) {
double montoBase = 1500.0;

if (enLinea && !aplazaMaterias && semestre >= 5) {
return montoBase * 1.05; // Aumento del 5% a partir del quinto semestre
} else if (!enLinea && aplazaMaterias) {

	// Calcula el total del semestre y las materias perdidas
double totalSemestre = calcularTotalSemestre(semestre);
double costoMateriasPerdidas = calcularCostoMateriasPerdidas(semestre);
return totalSemestre + costoMateriasPerdidas;
} else {
return montoBase;
   }
}

// Método para calcular el total del semestre
private double calcularTotalSemestre(int semestre) {
if (semestre <= 3) {
return semestre * 20.0; // Cada crédito cuesta 20 dólares para primero, segundo y tercer semestre
} else if (semestre <= 6) {
return semestre * 25.0; // Cada crédito cuesta 25 dólares para cuarto, quinto y sexto semestre
} else {
return semestre * 30.0; // Cada crédito cuesta 30 dólares para el resto de los semestres
}
}

// Método para calcular el costo de las materias perdidas
private double calcularCostoMateriasPerdidas(int semestre) {

   int materiasPerdidas = 2; // Número de materias perdidas
   double costoPorCredito = (semestre <= 3) ? 20.0 : (semestre <= 6) ? 25.0 : 30.0;
   return materiasPerdidas * costoPorCredito;
}

// Método para imprimir el recibo de inscripción
public void imprimirRecibo(double monto) {
   System.out.println("Recibo de Inscripción:");
   obtenerInformacion();
   System.out.println("Monto de la matrícula: $" + monto);
}
}

//Herencia de clase Persona
	class Estudiante extends Persona {
	String carrera;

// Constructor
public Estudiante(String nombres, String apellidos, String documento, String direccion, String telefono) {
   super(nombres, apellidos, documento, direccion, telefono);
   this.carrera = carrera;
}

}

public class Problema1 {
	
public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   System.out.println("Bienvenido a la Facultad de Ingeniería");
   System.out.println("Por favor seleccione el programa a consultar:");
   System.out.println("1 - Ingeniería de sistemas");
   System.out.println("2 - Ingeniería Industrial");
   System.out.println("3 - Ingeniería mecánica");

   // Leer la opción del usuario
   int opcion = scanner.nextInt();
   scanner.nextLine(); 

   // Pedir información del estudiante
   System.out.println("Ingrese sus nombres: ");
   String nombres = scanner.nextLine();
   System.out.println("Ingrese sus apellidos:");
   String apellidos = scanner.nextLine();
   System.out.println("Ingrese su documento:");
   String documento = scanner.nextLine();
   System.out.println("Ingrese su dirección:");
   String direccion = scanner.nextLine();
   System.out.println("Ingrese teléfono del estudiante:");
   String telefono = scanner.nextLine();

 
   Estudiante estudiante = new Estudiante(nombres, apellidos, documento, direccion, telefono);

   // Pedir información adicional para el cálculo de la matrícula
   System.out.println("¿El estudiante realiza su curso en línea? (Si/No):");
   String enLineaStr = scanner.next();
   boolean enLinea = enLineaStr.equalsIgnoreCase("Si");

   System.out.println("¿El estudiante aplaza materias? (Si/No):");
   String aplazaMateriasStr = scanner.next();
   boolean aplazaMaterias = aplazaMateriasStr.equalsIgnoreCase("Si");
   System.out.println("Ingrese el semestre actual del estudiante:");
   int semestre = scanner.nextInt();

   // Calcular y mostrar el recibo de inscripción
   double montoMatricula = estudiante.calcularMatricula(semestre, enLinea, aplazaMaterias);
   estudiante.imprimirRecibo(montoMatricula);

   scanner.close();
}
}
