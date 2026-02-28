package modelo;

public class SimuladorVoto extends Thread {
    private String comunidad;
    private String rangoEdad;
    private int numeroVotantes;
    private UrnaGlobal urna;

    public SimuladorVoto(String comunidad, String rangoEdad, int numeroVotantes, UrnaGlobal urna) {
        this.comunidad = comunidad;
        this.rangoEdad = rangoEdad;
        this.numeroVotantes = numeroVotantes;
        this.urna = urna;
    }

    @Override
    public void run() {
        for (int i = 0; i < numeroVotantes; i++) {
            String partidoCandidato = calcularVoto(rangoEdad);
            urna.registrarVoto(comunidad, partidoCandidato);
        }
    }

    private String calcularVoto(String edad) {
        double suerte = Math.random() * 100;
        // Lógica basada en el PDF: diferentes gustos según edad
        if (edad.equals("RANGO_18_25")) {
            if (suerte < 40) return "Partido_Joven";
            if (suerte < 70) return "Partido_Cambio";
            return "Otros";
        }
        if (edad.equals("RANGO_MAS_66")) {
            if (suerte < 60) return "Partido_Tradicional";
            return "Partido_Estabilidad";
        }
        return "Abstención";
    }
}