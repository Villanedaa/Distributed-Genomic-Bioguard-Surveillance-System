

public class Paciente {


    private String documentoId;
    private String nombre;
    private String apellido;
    private String edad;
    private String correo;
    private String genero;
    private String ciudad;
    private String pais;

    public Paciente(String documentoId, String nombre, String apellido, String edad, String correo, String ciudad, String genero, String pais) {
        this.documentoId = documentoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.ciudad = ciudad;
        this.genero = genero;
        this.pais = pais;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getGenero() {
        return genero;
    }

    public String toCSV() {
        return documentoId + "," + nombre + "," + apellido + "," + edad + "," +
                correo + "," + genero + "," + ciudad + "," + pais;
    }
}