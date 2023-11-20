package taller2;

import java.util.Scanner;

class Clientes {
    String Nombres;
    String Apellidos;
    String Edad;
    String TipoCuenta;
}

public class Problema3 {
    private static Scanner scanner = new Scanner(System.in);
    private static double saldoCuentaCorriente = 0;
    private static double saldoCuentaAhorros = 0;
    
    public static void main(String[] args) {
        System.out.println("----Bienvenido al BancoX----");
        System.out.println("Por favor seleccione la operación que desea realizar");
        System.out.println(" Menu: ");
        System.out.println("1 - Apertura de cuentas: Ahorro o corriente");
        System.out.println("2 - Transferencias");
        System.out.println("3 - Cajero automático");
        System.out.println("4 - Estado de cuenta");
       
        
        // Leer la opción del usuario
        int opcionSeleccionada = scanner.nextInt();

        switch (opcionSeleccionada) {
            case 1:
                seleccionarTipoCuenta();
                break;
            case 2:
                bancoATransferir();
                break;
            case 3:
                movimientosCajero();
                break;
            case 4:
                cierre();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione opción válida");
        }
    }

    private static void seleccionarTipoCuenta() {
        // Lógica para abrir una cuenta de ahorro
        System.out.println("Ha seleccionado la Apertura de cuentas");
        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorro");
        System.out.println("2. Cuenta Corriente");

        // Obtener la elección del usuario
        int opcionSeleccionada = scanner.nextInt();

        // Procesar la elección del usuario
        switch (opcionSeleccionada) {
            case 1:
                abrirCuentaDeAhorro();
                break;
            case 2:
                abrirCuentaCorriente();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
        }
    }

    private static void abrirCuentaDeAhorro() {
        // Lógica para abrir una cuenta de ahorro
        System.out.println("Ha seleccionado la apertura de cuenta de ahorro. Procesando...");
        System.out.println("Por favor, indique su edad: ");
        int edad = scanner.nextInt();
     // Si el usuario es menor de 18, solicitar nombres y apellidos del representante
        if (edad < 18) {
            
            scanner.nextLine(); 
            System.out.println("Como es menor de edad, por favor indique nombres completos de su representante: ");
            String nombresRepresentante = scanner.nextLine();
            System.out.println("Gracias. Ahora continuaremos con la apertura de la cuenta.");
        }
        System.out.println("Cuenta de ahorro abierta con éxito. Detalles de la cuenta:");
        System.out.println("Tasa de rendimiento anual: 2.2%");
    }

    private static void abrirCuentaCorriente() {
        // Lógica para abrir una cuenta corriente
        System.out.println("Se ha seleccionado la apertura de cuenta corriente. Procesando...");

        System.out.println("Por favor, indique su edad: ");
        int edad = scanner.nextInt();

        if (edad < 18) {
            // Si el usuario es menor de 18, solicitar nombres y apellidos del representante
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.println("Como es menor de edad, por favor indique nombres completos de su representante: ");
            String nombresRepresentante = scanner.nextLine();
            System.out.println("Gracias. Ahora continuaremos con la apertura de la cuenta.");
        }

        
        System.out.println("Ingrese el monto de apertura (mínimo 200,000 pesos): ");
        double montoApertura = scanner.nextDouble();
     // Validar el monto de apertura que debe ser mayor a 200000
        if (montoApertura < 200000) {
            System.out.println("El monto de apertura debe ser al menos 200,000 pesos. Operación cancelada.");
            return;
        }

        // Mostrar información sobre la cuenta corriente
        System.out.println("Cuenta corriente abierta con éxito. Detalles de la cuenta:");
        System.out.println("¡Información importante!");
        System.out.println("Tasa de mantenimiento mensual: 1.5%");
        System.out.println("Se cobrara $3000 por uso de cheque emitido.");
    }

    private static void bancoATransferir() {
        System.out.println("Seleccione el banco a Transferir");
        System.out.println("1. Banco Y");
        System.out.println("2. Banco Z");

        
        int opcionSeleccionada = scanner.nextInt();
        System.out.println("Ingrese el monto a transferir: ");
        int monto = scanner.nextInt();
        if (opcionSeleccionada ==1) {
        	 System.out.println("Se ha transferido con exito " + monto + " a Banco Y");
        }
        else if (opcionSeleccionada ==2) {
        	 System.out.println("Se ha transferido con exito " + monto + " a Banco Z");
        }
        
          
    }

    private static void movimientosCajero() {
        System.out.println("Indique operacion a realizar");
        System.out.println("1. Deposito");
        System.out.println("2. Retiro");

        int opcionSeleccionada = scanner.nextInt();

        // Procesar la elección del usuario
        switch (opcionSeleccionada) {
            case 1:
                deposito();
                break;
            case 2:
                retiro();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
        }
    }

    private static void deposito() {
        System.out.println("Seleccione cuenta: ");
        System.out.println("1- Cuenta corriente: ");
        System.out.println("2- Cuenta de Ahorros: ");

        int opcionSeleccionada = scanner.nextInt();

        // Procesar la elección del usuario
        switch (opcionSeleccionada) {
            case 1:
                cuentaCorriente();
                break;
            case 2:
                cuentaAhorros();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
        }
    }

    private static void cuentaCorriente() {
        System.out.println("Ingrese el monto del depósito a realizar en cuenta corriente: ");
        double montoDeposito = scanner.nextDouble();

        // Aplicar cargos según el monto del depósito
        if (montoDeposito < 500000) {
            System.out.println("Se ha cobrado 7000 pesos por el depósito recibido.");
        } else if (montoDeposito < 2000000) {
            double cargo = 5000 + (0.02 * montoDeposito);
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        } else if (montoDeposito <= 10000000) {
            double cargo = 4000 + (0.02 * montoDeposito);
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        } else {
            double cargo = 0.033 * montoDeposito;
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        }
        saldoCuentaCorriente += montoDeposito; 
    }

    private static void cuentaAhorros() {
        System.out.println("Ingrese el monto del depósito a realizar en cuenta de ahorros: ");
        double montoDeposito = scanner.nextDouble();

        // Aplicar cargos según el monto del depósito
        if (montoDeposito >= 500000 && montoDeposito < 2000000) {
            double cargo = 3000 + (0.01 * montoDeposito);
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        } else if (montoDeposito >= 2000000 && montoDeposito <= 10000000) {
            double cargo = 2000 + (0.005 * montoDeposito);
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        } else if (montoDeposito > 10000000 && montoDeposito < 100000000) {
            double cargo = 0.018 * montoDeposito;
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        } else if (montoDeposito >= 100000000) {
            double cargo = 0.02 * montoDeposito;
            System.out.println("Se ha cobrado " + cargo + " pesos por el depósito recibido.");
        }
        saldoCuentaAhorros += montoDeposito; 
    }

    private static void retiro() {
        // Lógica para retiro
    	
    	 System.out.println("¿Cuanto monto desea retirar?");
    	   double montoRetiro3 = scanner.nextDouble();
    	 System.out.println("¿Retirará dinero en cajeros diferentes al banco? (Ingrese 'S' para sí, 'N' para no): ");
    	    char opcionRetiro = scanner.next().charAt(0);

    	    if (opcionRetiro == 'S' || opcionRetiro == 's') {
    	        System.out.println("Se cobrará una comisión de 4500 pesos por cada transacción de retiro en cajeros diferentes al banco.");
    	    } else {
    	        System.out.println("No se cobrará comisión por retiros en cajeros pertenecientes al banco.");
    	    }
    	}
    
    

    private static void cierre() {
    	System.out.println("Seleccione cuenta: ");
        System.out.println("1- Cuenta corriente: ");
        System.out.println("2- Cuenta de Ahorros: ");

        int opcionSeleccionada = scanner.nextInt();

       if ( opcionSeleccionada== 1)  {
    	   System.out.println("Saldo actual en cuenta corriente: " + saldoCuentaCorriente);
       }
       else if (opcionSeleccionada== 2)  {
    	   System.out.println("Saldo actual en cuenta de ahorros: " + saldoCuentaAhorros);
       }
       
    }    
}



