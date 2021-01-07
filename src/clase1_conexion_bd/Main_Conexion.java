package clase1_conexion_bd;

public class Main_Conexion {

    public static void main(String[] args) {

        System.out.println("Iniciando la conexión con la Base de Datos ...");
        ConexionBaseDatosMYSQL baseDatosMySQl = new ConexionBaseDatosMYSQL();
        baseDatosMySQl.ConexionMySQL();
        if (baseDatosMySQl.ConexionMySQL() != null) {
            System.out.println("Éxito en la conexión con la Base de Datos");

        } else {
            System.out.println("No se pudo conectar con la Base de Datos");
        }
    }
}
