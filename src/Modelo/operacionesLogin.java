package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

public class operacionesLogin {

    public String validarCredenciales(String nombreUsuario, String password) throws SQLException {
        String tipoUsuario = "null";
        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaUsuarios = bdObject.createStatement().executeQuery(
            "SELECT * FROM USUARIOS WHERE (NOMBRE='"+nombreUsuario+"') AND (CLAVE='"+password+"') AND(ESTADO='ACTIVO')"
        );
        
        while (listaUsuarios.next()){
            tipoUsuario = listaUsuarios.getString(3);
        }
        return tipoUsuario;
    }
}