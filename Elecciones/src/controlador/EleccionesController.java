package controlador;

import modelo.ConexionBBDD;
import modelo.VotanteHilo;
import datos.Comunidad;
import java.util.ArrayList;
import java.util.List;

public class EleccionesController {

    public void iniciarSimulacion() {
        ArrayList<Comunidad> comunidades = ConexionBBDD.obtenerComunidades();
        List<VotanteHilo> hilosActivos = new ArrayList<>();

        for (Comunidad c : comunidades) {
            // Lógica de 1 hilo por cada 100.000 hab [cite: 18-19]
            // Debes calcular los hilos para cada rango de edad votable (18-25, 26-40, 41-65, +66)
            crearHilosPorRango(c, "18-25", c.getR18_25(), hilosActivos);
            crearHilosPorRango(c, "26-40", c.getR26_40(), hilosActivos);
            // ... repetir para los demás rangos votables
        }

        // Iniciar todos los hilos
        for (VotanteHilo h : hilosActivos) {
            h.start();
        }
        
        // Aquí deberías implementar un join o un sistema para saber cuando terminan
    }

    private void crearHilosPorRango(Comunidad c, String nombreRango, int porcentaje, List<VotanteHilo> lista) {
        long habitantesRango = (c.getTotalHabitantes() * porcentaje) / 100;
        long numHilos = Math.max(5, (long) Math.ceil(habitantesRango / 100000.0)); // [cite: 20-21]

        for (int i = 0; i < numHilos; i++) {
            lista.add(new VotanteHilo(c.getNombre(), nombreRango));
        }
    }
}