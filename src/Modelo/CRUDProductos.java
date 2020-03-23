package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

public class CRUDProductos {

    /**
     * (R) Recuperar Productos: Recupera la lista de todos los Productos activos
     * 
     * @throws SQLException
     */
    public ResultSet recuperarProductos() throws SQLException {
        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaProductos = bdObject.createStatement().executeQuery(
            "SELECT * FROM PRODUCTOS"
        );
        return listaProductos;
    }

    /**
     * (C) insertar Producto: inserta un nuevo Producto en la base de datos
     * 
     */
    public void insertarProducto(
        String IdProducto,
        String nombreProducto,
        String existenciasProducto,
        String marcaProducto,
        String tallaProducto,
        String colorProducto,
        String costoProducto,
        String ivaProducto,
        String ofertaProducto){
            ConexionDB EnlaceBD= new ConexionDB();
            Connection bdObject = EnlaceBD.getConnection();
            try {
                PreparedStatement s = bdObject.prepareStatement(
                    "INSERT INTO ProductoS VALUES (?,?,?,?,?,?,?,?,?)"
                );
                s.setString(1,IdProducto);
                s.setString(2,nombreProducto);
                s.setString(3,existenciasProducto);
                s.setString(4,marcaProducto);
                s.setString(5,tallaProducto);
                s.setString(6,colorProducto);
                s.setString(7,costoProducto);
                s.setString(8,ivaProducto);
                s.setString(9,ofertaProducto);
                s.executeUpdate();
                EnlaceBD.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}