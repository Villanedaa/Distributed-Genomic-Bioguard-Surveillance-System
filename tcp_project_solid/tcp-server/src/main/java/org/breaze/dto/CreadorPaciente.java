import java.io.*;

public class CreadorPaciente {
    private static final String FILE_NAME = "pacientes.csv";

    public static String gestionarPeticion(String mensaje) {
        String[] partes = mensaje.split(":");
        String comando = partes[0].toUpperCase();

        switch (comando) {
            case "REGISTRAR":
                return registrar(partes);
            case "CONSULTAR":
                return consultar(partes[1]);
            default:
                return "ERROR: Comando no reconocido";
        }
    }

    private static String registrar(String[] d) {
        // Validación de duplicados usando el documentoId (d[1])
        if (buscarEnArchivo(d[1]) != null) {
            return "ERROR: El documentoId " + d[1] + " ya existe.";
        }

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            // Unimos los datos d[1] a d[8] con comas para el CSV
            String lineaCsv = String.join(",", java.util.Arrays.copyOfRange(d, 1, 9));
            out.println(lineaCsv);
            return "EXITO: Paciente registrado correctamente.";
        } catch (IOException e) {
            return "ERROR: No se pudo escribir en el archivo.";
        }
    }

    private static String consultar(String documentoId) {
        String linea = buscarEnArchivo(documentoId);
        return (linea != null) ? "ENCONTRADO:" + linea : "ERROR: Paciente no encontrado.";
    }

    private static String buscarEnArchivo(String id) {
        File f = new File(FILE_NAME);
        if (!f.exists()) return null;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(id + ",")) return linea;
            }
        } catch (IOException e) { return null; }
        return null;
    }
}