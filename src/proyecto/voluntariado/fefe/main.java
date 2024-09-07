import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LeerCSV {

    // Mapa para almacenar personas con RUT como clave
    private static HashMap<String, Personas> mapaPersonas = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String archivoCSV = "ruta/del/archivo/personas_chile_realista_50_fixed.csv";
        leerCSV(archivoCSV);

        // Mostrar el menú
        mostrarMenu();
    }

    // Método que lee el archivo CSV
    public static void leerCSV(String archivoCSV) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
        String linea;
        boolean primeraLinea = true; // Para omitir la cabecera

        while ((linea = br.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false; // Omitimos la primera línea (cabecera)
                continue;
            }

            String[] datos = linea.split(";"); // Separar por punto y coma
            String nombre = datos[0];
            String primerApellido = datos[1];
            String segundoApellido = datos[2];
            String rut = datos[3];
            String genero = datos[4];
            String fechaNacimiento = datos[5];
            String correo = datos[6];
            int numero = Integer.parseInt(datos[7]);
            String region = datos[8];
            String comuna = datos[9];

            // Crear la persona
            Personas persona = new Personas(nombre, primerApellido, segundoApellido, rut);

            // Crear la información personal
            persona.agregarInformacionPersonal(genero, fechaNacimiento, correo, numero);
            persona.getInformacionPersonalList().get(0).setRegion(region);
            persona.getInformacionPersonalList().get(0).setComuna(comuna);

            // Añadir la persona al mapa
            mapaPersonas.put(rut, persona);
        }

        System.out.println("Personas cargadas desde el archivo CSV.");
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n----- Menú -----");
            System.out.println("1. Insertar Persona Manualmente");
            System.out.println("2. Mostrar todas las Personas");
            System.out.println("3. Buscar Persona por RUT");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    insertarPersona(scanner);
                    break;
                case 2:
                    mostrarPersonas();
                    break;
                case 3:
                    buscarPersonaPorRUT(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    