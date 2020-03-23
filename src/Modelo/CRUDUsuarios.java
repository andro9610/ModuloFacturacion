package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

public class CRUDUsuarios {

    /**
     * (R) Recuperar Usuarios: Recupera la lista de todos los usuarios activos
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

    /**
     * (C) insertar Usuario: inserta un nuevo usuario en la base de datos
     * 
     * @param nombreUsuario
     * @param claveUsuario
     * @param tipoUsuario
     * @param estadoUsuario
     */
    public void insertarUsuario(String nombreUsuario,String claveUsuario,
        String tipoUsuario, String estadoUsuario){
            ConexionDB EnlaceBD= new ConexionDB();
            Connection bdObject = EnlaceBD.getConnection();
            try {
                PreparedStatement s = bdObject.prepareStatement(
                    "INSERT INTO USUARIOS VALUES (?,?,?,?)"
                );
                s.setString(1,nombreUsuario);
                s.setString(2,claveUsuario);
                s.setString(3,tipoUsuario);
                s.setString(4,estadoUsuario);
                s.executeUpdate();
                EnlaceBD.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}