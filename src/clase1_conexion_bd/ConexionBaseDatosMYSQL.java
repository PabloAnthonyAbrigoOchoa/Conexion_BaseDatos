package clase1_conexion_bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBaseDatosMYSQL {

    private static final String nombreBaseDatos = "bdEjercicio1";
    private static final String usuario = "root";
    private static final String contraseña = "root";
    private static final String lineaBaseConexion = "jdbc:mysql://localhost:3306/" + nombreBaseDatos + "?useSSL=TRUE";
    private Connection connect = null;

    public Connection ConexionMySQL() {

        try {
            connect = DriverManager.getConnection(lineaBaseConexion, usuario, contraseña);
            if (connect != null) {
                return connect;

            }

        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());

        }
        return null;

    }

}
