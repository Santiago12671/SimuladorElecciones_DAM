package modelo;

import datos.Partido;
import datos.VotoIndividual;
import java.util.Random;

public class VotanteHilo extends Thread {
    private String comunidad;
    private String rangoEdad;
    private VotoIndividual resultadoVoto;

    public VotanteHilo(String comunidad, String rangoEdad) {
        this.comunidad = comunidad;
        this.rangoEdad = rangoEdad;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int valor = rand.nextInt(100) + 1; // Número entre 1 y 100 [cite: 22]
        Partido partidoVotado = calcularVoto(valor);

        this.resultadoVoto = new VotoIndividual(comunidad, rangoEdad, partidoVotado);

        try {
            // Simular validación del voto [cite: 47]
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Partido calcularVoto(int v) {
        switch (rangoEdad) {
            case "18-25":
                if (v <= 30) return Partido.X; // [cite: 24]
                if (v <= 50) return Partido.Y; // [cite: 24]
                if (v <= 70) return Partido.W; // [cite: 25]
                return Partido.Z; // [cite: 26]
            case "26-40":
                if (v <= 20) return Partido.X; // [cite: 29]
                if (v <= 55) return Partido.Y; // [cite: 30]
                if (v <= 85) return Partido.W; // [cite: 31]
                return Partido.Z; // [cite: 32]
            case "41-65":
                if (v <= 10) return Partido.X; // [cite: 34]
                if (v <= 55) return Partido.Y; // [cite: 35]
                if (v <= 90) return Partido.W; // [cite: 36]
                return Partido.Z; // [cite: 38]
            case "+66":
                if (v <= 25) return Partido.X; // [cite: 40]
                if (v <= 60) return Partido.Y; // [cite: 42]
                if (v <= 95) return Partido.W; // [cite: 43]
                return Partido.Z; // [cite: 44]
            default:
                return null;
        }
    }

    public VotoIndividual getResultadoVoto() {
        return resultadoVoto;
    }
}