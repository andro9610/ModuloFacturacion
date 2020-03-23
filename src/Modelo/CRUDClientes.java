package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

public class CRUDClientes {

    /**
     * (R) Recuperar Clientes: Recupera la lista de todos los Clientes activos
     * 
     * @throws SQLException
     */
    public ResultSet recuperarClientes() throws SQLException {
        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaClientes = bdObject.createStatement().executeQuery(
            "SELECT * FROM CLIENTES"
        );
        return listaClientes;
    }

    /**
     * (C) insertar Cliente: inserta un nuevo Cliente en la base de datos
     * 
     */
    public void insertarCliente(
        String numeroDocumento,
        String tipoDocumento,
        String nombreCliente,
        String apellidoCliente,
        String sexoCliente,
        String edadCliente){
            ConexionDB EnlaceBD= new ConexionDB();
            Connection bdObject = EnlaceBD.getConnection();
            try {
                PreparedStatement s = bdObject.prepareStatement(
                    "INSERT INTO ClienteS VALUES (?,?,?,?,?,?)"
                );
                s.setString(1,numeroDocumento);
                s.setString(2,tipoDocumento);
                s.setString(3,nombreCliente);
                s.setString(4,apellidoCliente);
                s.setString(5,sexoCliente);
                s.setString(6,edadCliente);
                s.executeUpdate();
                EnlaceBD.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}