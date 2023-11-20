package taller2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Alquiler {
    String Nombres;
    int CantidadClientes;
    Date FechaInicio;
    Date FechaFin;
    String PosicionAmarre;
    String Barco;

    // Método para calcular el costo del alquiler
    double calcularCostoAlquiler() {
        long diasAlquiler = TimeUnit.MILLISECONDS.toDays(FechaFin.getTime() - FechaInicio.getTime());
        return diasAlquiler * 25000; // 25,000 es el costo diario de alquiler
    }
}

class Barco {
    String Matricula;
    double Slora;
    int AñoFabricacion;
}

class Cliente {
    String Nombre;

    public Cliente(String nombreCliente) {
        this.Nombre = nombreCliente;
    }
}

public class Problema2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----Bienvenido Yachtworld----");
        // Solicitar datos del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente);

        // Solicitar datos del alquiler
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Ingrese la fecha de inicio del alquiler (dd/MM/yyyy): ");
        String fechaInicioStr = scanner.next();
        
        System.out.print("Ingrese la fecha de fin del alquiler (dd/MM/yyyy): ");
        String fechaFinStr = scanner.next();
        
        System.out.print("Ingrese la posición del amarre: ");
        String posicionAmarre = scanner.next();
        System.out.print("Ingrese el nombre del barco: ");
        String nombreBarco = scanner.next();

        try {
            Date fechaInicio = dateFormat.parse(fechaInicioStr);
            Date fechaFin = dateFormat.parse(fechaFinStr);

            // Creación de objetos Alquiler y Barco 
            Alquiler alquiler = new Alquiler();
            alquiler.Nombres = cliente.Nombre;
            alquiler.CantidadClientes = 1; // Puedes ajustar esto según tus necesidades
            alquiler.FechaInicio = fechaInicio;
            alquiler.FechaFin = fechaFin;
            alquiler.PosicionAmarre = posicionAmarre;
            alquiler.Barco = nombreBarco;

            // Calcular el costo total utilizando el método calcularCostoAlquiler
            double costoTotal = alquiler.calcularCostoAlquiler();

            // Mostrar los resultados
            System.out.println("\nRecibo de Alquiler:");
            System.out.println("Cliente: " + alquiler.Nombres);
            System.out.println("Barco: " + alquiler.Barco);
            System.out.println("Posición de Amarre: " + alquiler.PosicionAmarre);
            System.out.println("Fecha de inicio: " + fechaInicioStr);
            System.out.println("Fecha de fin: " + fechaFinStr);
            System.out.println("Días de alquiler: " + TimeUnit.MILLISECONDS.toDays(fechaFin.getTime() - fechaInicio.getTime()));
            System.out.println("Costo total: " + costoTotal);
        } catch (ParseException e) {
            System.out.println("Error al analizar las fechas. Asegúrese de usar el formato dd/MM/yyyy.");
        }

        scanner.close();
    }
}

     