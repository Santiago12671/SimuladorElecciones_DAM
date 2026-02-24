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
            // Asegúrate de que la carpeta 'resources' existe y contiene el archivo
            props.load(new FileInputStream("resources/database.properties"));
        } catch (IOException e) {
            System.err.println("Error: No se encontró el archivo database.properties");
        }
    }

    public static ArrayList<Comunidad> obtenerComunidades() {
        ArrayList<Comunidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM PORCENTAJES_RANGOEDAD"; //

        try (Connection con = DriverManager.getConnection(
                props.getProperty("database.url"),
                props.getProperty("database.user"),
                props.getProperty("database.password"));
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                // Aquí es donde llamamos al nuevo constructor de Comunidad
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