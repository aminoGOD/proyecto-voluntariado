import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Personas {

    // Primera colección de objetos - Personas
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String rut;

    private List<InformacionPersonal> informacionPersonalList; // Colección de información personal

    // Constructor completo
    public Personas(String nombre, String primerApellido, String segundoApellido, String rut) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.rut = rut;
        this.informacionPersonalList = new ArrayList<>(); // Inicialización de la colección
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<InformacionPersonal> getInformacionPersonalList() {
        return informacionPersonalList;
    }

    public void setInformacionPersonalList(List<InformacionPersonal> informacionPersonalList) {
        this.informacionPersonalList = informacionPersonalList;
    }

    // Sobrecarga de métodos para agregar información personal
    public void agregarInformacionPersonal(String genero, String fechaNacimiento) {
        this.informacionPersonalList.add(new InformacionPersonal(genero, fechaNacimiento));
    }

    public void agregarInformacionPersonal(String genero, String fechaNacimiento, String correo, int numero) {
        this.informacionPersonalList.add(new InformacionPersonal(genero, fechaNacimiento, correo, numero));
    }

    // Clase anidada - Información personal (segunda colección)
    public class InformacionPersonal {
        private String genero;
        private String fechaNacimiento;
        private String correo;
        private int numero;
        private String region;
        private String comuna;
        private String contactoEmergencia;
        private int numeroEmergencia;
        private List<Resto> restoList; // Colección de "Resto"

        // Constructor completo
        public InformacionPersonal(String genero, String fechaNacimiento) {
            this.genero = genero;
            this.fechaNacimiento = fechaNacimiento;
            this.restoList = new ArrayList<>();
        }

        public InformacionPersonal(String genero, String fechaNacimiento, String correo, int numero) {
            this(genero, fechaNacimiento); // Reutilizamos el constructor
            this.correo = correo;
            this.numero = numero;
        }

        // Getters y Setters
        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getComuna() {
            return comuna;
        }

        public void setComuna(String comuna) {
            this.comuna = comuna;
        }

        public String getContactoEmergencia() {
            return contactoEmergencia;
        }

        public void setContactoEmergencia(String contactoEmergencia) {
            this.contactoEmergencia = contactoEmergencia;
        }

        public int getNumeroEmergencia() {
            return numeroEmergencia;
        }

        public void setNumeroEmergencia(int numeroEmergencia) {
            this.numeroEmergencia = numeroEmergencia;
        }

        public List<Resto> getRestoList() {
            return restoList;
        }

        public void setRestoList(List<Resto> restoList) {
            this.restoList = restoList;
        }

        // Sobrecarga de métodos para agregar "Resto"
        public void agregarResto(String ocupacionActual) {
            this.restoList.add(new Resto(ocupacionActual));
        }

        public void agregarResto(String ocupacionActual, String comoTeEnteraste) {
            this.restoList.add(new Resto(ocupacionActual, comoTeEnteraste));
        }

        // Clase anidada dentro de "InformacionPersonal" - Resto
        public class Resto {
            private String ocupacionActual;
            private String comoTeEnteraste;

            // Constructor completo
            public Resto(String ocupacionActual) {
                this.ocupacionActual = ocupacionActual;
            }

            public Resto(String ocupacionActual, String comoTeEnteraste) {
                this.ocupacionActual = ocupacionActual;
                this.comoTeEnteraste = comoTeEnteraste;
            }

            // Getters y Setters
            public String getOcupacionActual() {
                return ocupacionActual;
            }

            public void setOcupacionActual(String ocupacionActual) {
                this.ocupacionActual = ocupacionActual;
            }

            public String getComoTeEnteraste() {
                return comoTeEnteraste;
            }

            public void setComoTeEnteraste(String comoTeEnteraste) {
                this.comoTeEnteraste = comoTeEnteraste;
            }
        }
    }
}

public class LeerCSV {

    public static void main(String[] args) throws IOException {
        String archivoCSV = "ruta/del/archivo/personas_chile_realista_50_fixed.csv";
        List<Personas> listaPersonas = leerCSV(archivoCSV);

        // Mostrar las personas cargadas
        for (Personas persona : listaPersonas) {
            System.out.println("Nombre: " + persona.getNombre() + " " + persona.getPrimerApellido() + " " + persona.getSegundoApellido());
            System.out.println("RUT: " + persona.getRut());
            for (Personas.InformacionPersonal info : persona.getInformacionPersonalList()) {
                System.out.println("Genero: " + info.getGenero());
                System.out.println("Fecha Nacimiento: " + info.getFechaNacimiento());
                System.out.println("Correo: " + info.getCorreo());
                System.out.println("Comuna: " + info.getComuna());
                System.out.println("Region: " + info.getRegion());
                System.out.println("---------------------");
            }
        }
    }

    // Método que lee el archivo CSV 
    public static List<Personas> leerCSV(String archivoCSV) throws IOException {
        List<Personas> listaPersonas = new ArrayList<>();
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

            // Añadir la persona a la lista
            listaPersonas.add(persona);
        }

        return listaPersonas;
    }
}
