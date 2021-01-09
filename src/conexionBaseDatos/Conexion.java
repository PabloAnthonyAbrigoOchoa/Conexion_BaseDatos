package conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;
    //Declaramos los datos de conexion
    private static final String usuario = "root";
    private static final String contraseña = "root";
    private static final String url = "jdbc:mysql://localhost:3306/bdejercicio1? useUnicode=true&use"
            + " JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection conectarBaseDatos() throws SQLException {
        //Reseteamos null a la conexion de la BD
        conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conexion a la BD
            conexion = (Connection) DriverManager.getConnection(url, usuario, contraseña);
            //comprobacion
            if (conexion != null) {
                System.out.println("Conexion exitosa");
            }
            //mensaje de error
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conexion;
    }
    
}
