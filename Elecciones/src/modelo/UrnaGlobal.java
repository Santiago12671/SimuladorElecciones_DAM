package modelo;

import java.util.HashMap;
import java.util.Map;

public class UrnaGlobal {
    // Mapa que guarda: Comunidad -> (Partido -> Cantidad de Votos)
    private Map<String, Map<String, Integer>> recuento;

    public UrnaGlobal() {
        this.recuento = new HashMap<>();
    }

    // Método sincronizado: la "puerta" para que los hilos sumen votos de forma segura
    public synchronized void registrarVoto(String comunidad, String partido) {
        // Si la comunidad no existe en el mapa, la añadimos
        recuento.putIfAbsent(comunidad, new HashMap<>());
        
        Map<String, Integer> votosComunidad = recuento.get(comunidad);
        
        // Sumamos 1 al partido correspondiente
        votosComunidad.put(partido, votosComunidad.getOrDefault(partido, 0) + 1);
    }

    public Map<String, Map<String, Integer>> getRecuento() {
        return recuento;
    }
}