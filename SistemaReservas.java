import java.util.ArrayList;
import java.util.Scanner;


//192358 - 192420
public class SistemaReservas {

    // Clase EspacioRecreacional
    static class EspacioRecreacional {
        private String nombre;
        private String tipo; // Puede ser "cancha", "sala de juegos", etc.
        private int capacidad;
        private ArrayList<String> horariosDisponibles;
        private ArrayList<String> reservas; // Para llevar el control de las reservas

        public EspacioRecreacional(String nombre, String tipo, int capacidad, ArrayList<String> horariosDisponibles) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.capacidad = capacidad;
            this.horariosDisponibles = horariosDisponibles;
            this.reservas = new ArrayList<>();
        }

        public boolean reservar(String horario) {
            if (horariosDisponibles.contains(horario) && !reservas.contains(horario)) {
                reservas.add(horario);
                return true;
            }
            return false;
        }

        public void mostrarDisponibilidad() {
            System.out.println("Horarios disponibles para " + nombre + ":");
            for (String horario : horariosDisponibles) {
                if (!reservas.contains(horario)) {
                    System.out.println(horario);
                }
            }
        }

        public boolean cancelarReserva(String horario) {
            if (reservas.contains(horario)) {
                reservas.remove(horario);
                return true;
            }
            return false;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public int getCapacidad() {
            return capacidad;
        }

        public ArrayList<String> getHorariosDisponibles() {
            return horariosDisponibles;
        }
    }

    // Clase Estudiante
    static class Estudiante {
        private String nombre;
        private String id;

        public Estudiante(String nombre, String id) {
            this.nombre = nombre;
            this.id = id;
        }

        public boolean reservarEspacio(EspacioRecreacional espacio, String horario) {
            if (espacio.reservar(horario)) {
                System.out.println("Reserva exitosa para el estudiante " + nombre + " en el horario " + horario);
                return true;
            } else {
                System.out.println("No se pudo reservar el espacio en el horario " + horario);
                return false;
            }
        }

        public boolean cancelarReserva(EspacioRecreacional espacio, String horario) {
            if (espacio.cancelarReserva(horario)) {
                System.out.println("Reserva cancelada exitosamente para el estudiante " + nombre + " en el horario " + horario);
                return true;
            } else {
                System.out.println("No se pudo cancelar la reserva para el horario " + horario);
                return false;
            }
        }
    }

    // Clase GestionRecreacional
    static class GestionRecreacional {
        private ArrayList<EspacioRecreacional> espacios;

        public GestionRecreacional() {
            this.espacios = new ArrayList<>();
        }

        public void registrarEspacio(EspacioRecreacional espacio) {
            espacios.add(espacio);
        }

        public void mostrarDisponibilidad() {
            for (EspacioRecreacional espacio : espacios) {
                espacio.mostrarDisponibilidad();
            }
        }

        public EspacioRecreacional buscarEspacio(String nombre) {
            for (EspacioRecreacional espacio : espacios) {
                if (espacio.getNombre().equalsIgnoreCase(nombre)) {
                    return espacio;
                }
            }
            return null; // No se encuentra el espacio
        }
    }

    // Método principal para simular el sistema
    public static void main(String[] args) {
        // Crear horarios disponibles
        ArrayList<String> horariosCancha = new ArrayList<>();
        horariosCancha.add("INGRESE EL HORARIO EN STRING TAL COMO SE VE EN PANTALLA ");
        horariosCancha.add("08:00 AM");
        horariosCancha.add("10:00 AM");
        horariosCancha.add("12:00 PM");
        horariosCancha.add("02:00 PM");
        
        ArrayList<String> horariosSalaJuegos = new ArrayList<>();
        horariosCancha.add("INGRESE EL HORARIO EN STRING TAL COMO SE VE EN PANTALLA ");
        horariosSalaJuegos.add("09:00 AM");
        horariosSalaJuegos.add("11:00 AM");
        horariosSalaJuegos.add("01:00 PM");
        horariosSalaJuegos.add("03:00 PM");
        
        // Crear espacios recreativos
        EspacioRecreacional cancha = new EspacioRecreacional("Cancha de Futbol", "Cancha", 20, horariosCancha);
        EspacioRecreacional salaJuegos = new EspacioRecreacional("Sala de Juegos", "Sala", 10, horariosSalaJuegos);

        // Crear el sistema de gestión
        GestionRecreacional gestion = new GestionRecreacional();
        gestion.registrarEspacio(cancha);
        gestion.registrarEspacio(salaJuegos);

        // Crear el objeto Scanner para leer entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del estudiante
        System.out.print("Ingrese su nombre: ");
        String nombreEstudiante = scanner.nextLine();
        System.out.print("Ingrese su ID de estudiante: ");
        String idEstudiante = scanner.nextLine();
        
        // Crear un objeto Estudiante
        Estudiante estudiante = new Estudiante(nombreEstudiante, idEstudiante);

        // Mostrar las opciones de espacios disponibles
        System.out.println("\nEspacios recreacionales disponibles:");
        System.out.println("1. Cancha de Futbol");
        System.out.println("2. Sala de Juegos");
        System.out.print("Seleccione el número del espacio que desea reservar (1 o 2): ");
        int opcionEspacio = scanner.nextInt();
        scanner.nextLine(); 

        EspacioRecreacional espacioSeleccionado = null;

        if (opcionEspacio == 1) {
            espacioSeleccionado = cancha;
        } else if (opcionEspacio == 2) {
            espacioSeleccionado = salaJuegos;
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        // Mostrar los horarios disponibles para el espacio seleccionado
        espacioSeleccionado.mostrarDisponibilidad();

        // Solicitar el horario para la reserva
        System.out.print("Ingrese el horario que desea reservar: ");
        String horarioSeleccionado = scanner.nextLine();

        // Realizar la reserva
        estudiante.reservarEspacio(espacioSeleccionado, horarioSeleccionado);

        // Preguntar si desea cancelar una reserva
        System.out.print("¿Desea cancelar alguna reserva? (si/no): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            // Mostrar las reservas del espacio
            System.out.print("Ingrese el horario que desea cancelar: ");
            String horarioCancelar = scanner.nextLine();
            estudiante.cancelarReserva(espacioSeleccionado, horarioCancelar);
        }

        // Mostrar la disponibilidad final
        System.out.println("\nDisponibilidad final de los espacios:");
        gestion.mostrarDisponibilidad();

        // Cerrar el scanner
        scanner.close();
    }
}