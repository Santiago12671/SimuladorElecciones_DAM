package datos;

public enum Partido {
    X, Y, W, Z;

    // Método para obtener un partido aleatorio si fuera necesario o por índice
    public static Partido getById(int id) {
        return values()[id];
    }
}	