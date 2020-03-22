package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

public class CRUDUsuarios {

    /**
     * (R) Recuperar Usuarios: Recupera la lista de todos los usuarios
     * 
     * @throws SQLException
     */
    public ResultSet recuperarUsuarios() throws SQLException {
        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaUsuarios = bdObject.createStatement().executeQuery(
            "SELECT * FROM USUARIOS WHERE (ESTADO='ACTIVO')"
        );
        return listaUsuarios;
    }
}