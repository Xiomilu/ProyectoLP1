package util;

import java.sql.Connection;

public class PuebaMysql {

	public static void main(String[] args) {
        Connection connection = MysqlConexion.getConexion();
        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos");
            // Aquí podrías realizar otras operaciones con la base de datos si lo deseas
            // Por ejemplo, realizar consultas, actualizaciones, etc.
        } else {
            System.out.println("Error al conectar a la base de datos");
        }
    }
}