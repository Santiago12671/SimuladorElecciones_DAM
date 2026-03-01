package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import datos.Comunidad;

public class ConexionBBDD {
    private static Properties props = new Properties();

    static {
        try {
            // Ajusta la ruta si tu archivo está en una carpeta distinta
            props.load(new FileInputStream("resources/database.properties"));
        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo de propiedades");
        }
    }

    public static ArrayList<Comunidad> obtenerComunidades() {
        ArrayList<Comunidad> lista = new ArrayList<>();
        // Query para la tabla de tu SQL
        String sql = "SELECT * FROM PORCENTAJES_RANGOEDAD";

        try (Connection con = DriverManager.getConnection(
                props.getProperty("database.url"),
                props.getProperty("database.user"),
                props.getProperty("database.password"));
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Comunidad(
                    rs.getString("NOMBRE_COMUNIDAD"),
                    rs.getInt("TOTAL_HABITANTES"),
                    rs.getInt("RANGO_18_25"),
                    rs.getInt("RANGO_26_40"),
                    rs.getInt("RANGO_41_65"),
                    rs.getInt("RANGO_MAS_66")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}