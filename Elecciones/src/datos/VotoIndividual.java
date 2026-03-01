package datos;

public class VotoIndividual {
    private String comunidad;
    private String rangoEdad;
    private Partido partido;

    public VotoIndividual(String comunidad, String rangoEdad, Partido partido) {
        this.comunidad = comunidad;
        this.rangoEdad = rangoEdad;
        this.partido = partido;
    }

    // Getters
    public String getComunidad() { return comunidad; }
    public String getRangoEdad() { return rangoEdad; }
    public Partido getPartido() { return partido; }
}