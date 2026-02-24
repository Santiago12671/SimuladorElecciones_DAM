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
            // Cargamos el archivo de configuración
            props.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(
            props.getProperty("db.url"),
            props.getProperty("db.user"),
            props.getProperty("db.password")
        );
    }

    public static ArrayList<Comunidad> obtenerComunidades() {
        ArrayList<Comunidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM PORCENTAJES_RANGOEDAD"; // Según tu SQL [cite: 10, 11]

        try (Connection con = getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                // Creamos el objeto con los datos del censo [cite: 15]
                Comunidad c = new Comunidad(
                    rs.getString("NOMBRE_COMUNIDAD"),
                    rs.getInt("TOTAL_HABITANTES"),
                    rs.getInt("RANGO_18_25"),
                    rs.getInt("RANGO_26_40"),
                    rs.getInt("RANGO_41_65"),
                    rs.getInt("RANGO_MAS_66")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error en Acceso a Datos: " + e.getMessage());
        }
        return lista;
    }
}