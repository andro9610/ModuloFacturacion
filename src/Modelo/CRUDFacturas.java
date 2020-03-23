package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

public class CRUDFacturas {

    /**
     * (R) Recuperar Facturas: Recupera la lista de todos los Facturas activos
     * 
     * @throws SQLException
     */
    public ResultSet recuperarFacturas() throws SQLException {
        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaFacturas = bdObject.createStatement().executeQuery(
            "SELECT * FROM FACTURA"
        );
        return listaFacturas;
    }

    /**
     * (C) insertar Factura: inserta un nuevo Factura en la base de datos
     */
    public void insertarFactura(String idFactura, String fechaFactura,
    String subtotalFactura, String envioFactura, String totalFactura){
            ConexionDB EnlaceBD= new ConexionDB();
            Connection bdObject = EnlaceBD.getConnection();
            try {
                PreparedStatement s = bdObject.prepareStatement(
                    "INSERT INTO FACTURA VALUES (?,?,?,?,?)"
                );
                s.setString(1,idFactura);
                s.setString(2,fechaFactura);
                s.setString(3,subtotalFactura);
                s.setString(4,envioFactura);
                s.setString(5,totalFactura);
                s.executeUpdate();
                EnlaceBD.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}