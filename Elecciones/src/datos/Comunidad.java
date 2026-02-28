package datos;

public class Comunidad {
    private String nombre;
    private int habitantes;
    private int r18_25;
    private int r26_40;
    private int r41_65;
    private int r66;

    // Constructor completo para que coincida con la BBDD
    public Comunidad(String nombre, int habitantes, int r18_25, int r26_40, int r41_65, int r66) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.r18_25 = r18_25;
        this.r26_40 = r26_40;
        this.r41_65 = r41_65;
        this.r66 = r66;
    }

    // Getters necesarios para la lógica de hilos
    public String getNombre() { return nombre; }
    public int getTotalHabitantes() { return habitantes; }
    public int getR18_25() { return r18_25; }
    public int getR26_40() { return r26_40; }
    public int getR41_65() { return r41_65; }
    public int getR66() { return r66; }
}