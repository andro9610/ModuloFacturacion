package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;

import Mapeador.ConexionDB;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.listMaker;
import Vista.Herramientas.tableMaker;

public class operacionesGestionProductos {
    public Object[] agregarNuevoProducto(tableMaker creadorTabla) throws SQLException {
        /**Creacion de listas desplegables */
        String [] opcionesMarcaProducto = {"ADIDDAS","ARTURO CALLE","TOTTO"};
        String [] opcionesTallaProducto = {"XXL","XL","L","M","XS","XXS"};
        String [] opcionesColorProducto = {"AMARILLO","AZUL","VERDE","NEGRO"};
        String [] opcionesOferta = {"SI","NO"};
        
        JComboBox<String> marcaProducto = agregarLista(opcionesMarcaProducto);
        JComboBox<String> tallaProducto = agregarLista(opcionesTallaProducto);
        JComboBox<String> colorProducto = agregarLista(opcionesColorProducto);
        JComboBox<String> oferta = agregarLista(opcionesOferta);

        /**Formateo de las columnas */
        TableColumn marcaProductoColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(3);
        marcaProductoColumn.setCellEditor(new DefaultCellEditor(marcaProducto));

        TableColumn tallaProductoColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(4);
        tallaProductoColumn.setCellEditor(new DefaultCellEditor(tallaProducto));

        TableColumn colorProductoColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(5);
        colorProductoColumn.setCellEditor(new DefaultCellEditor(colorProducto));

        TableColumn ofertaProductoColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(8);
        ofertaProductoColumn.setCellEditor(new DefaultCellEditor(oferta));


        Object[] nuevoProducto = {
            "A000",
            "DESCRIPCION",
            "0",
            marcaProducto,
            tallaProducto,
            colorProducto,
            "0",
            "0",
            oferta
        };

        new CRUDProductos().insertarProducto(
            "A000",
            "DESCRIPCION",
            "0",
            "NINGUNA",
            "M",
            "NINGUNO",
            "0",
            "0",
            "0"
            );
        return nuevoProducto;
    }

    public void cargarProductos(tableMaker creadorTabla) throws SQLException {
        String [] opcionesMarcaProducto = {"ADIDDAS","ARTURO CALLE","TOTTO"};
        String [] opcionesTallaProducto = {"XXL","XL","L","M","XS","XXS"};
        String [] opcionesColorProducto = {"AMARILLO","AZUL","VERDE","NEGRO"};
        String [] opcionesOferta = {"SI","NO"};
        
        JComboBox<String> marcaProducto = agregarLista(opcionesMarcaProducto);
        JComboBox<String> tallaProducto = agregarLista(opcionesTallaProducto);
        JComboBox<String> colorProducto = agregarLista(opcionesColorProducto);
        JComboBox<String> oferta = agregarLista(opcionesOferta);

        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaProductos = bdObject.createStatement().executeQuery(
            "SELECT * FROM PRODUCTOS"
        );

        while (listaProductos.next()){

            TableColumn marcaProductoColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(3);
            marcaProductoColumn.setCellEditor(new DefaultCellEditor(marcaProducto));

            TableColumn tallaProductoColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(4);
            tallaProductoColumn.setCellEditor(new DefaultCellEditor(tallaProducto));

            TableColumn colorProductoColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(5);
            colorProductoColumn.setCellEditor(new DefaultCellEditor(colorProducto));

            TableColumn ofertaProductoColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(8);
            ofertaProductoColumn.setCellEditor(new DefaultCellEditor(oferta));
            Object Productos[] = {
                listaProductos.getString(1),
                listaProductos.getString(2),
                listaProductos.getString(3),
                listaProductos.getString(4),
                listaProductos.getString(5),
                listaProductos.getString(6),
                listaProductos.getString(7),
                listaProductos.getString(8),
                listaProductos.getString(9)
            };
            creadorTabla.agregarFila(Productos);
        }
    }

    /**Operacion que permite añadir listas desplegables a la tabla */
    private JComboBox<String> agregarLista(String[] opciones){     
        listMaker creadorListas = new listMaker();
        return creadorListas.crear(
            0, 0,100, 32,
            new colorMaker().obtainColor("grisEnfasisMedio"),
            new fontMaker().obtainFont("fuenteListaDesplegable"),
            opciones
        );
    }
}
