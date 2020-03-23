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

public class operacionesGestionUsuarios {
    public Object[] agregarNuevoUsuario(tableMaker creadorTabla) throws SQLException {
        /**Creacion de listas desplegables */
        String [] opcionesTipoUsuario = {"VENDEDOR","ADMINISTRADOR"};
        String [] opcionesEstado = {"ACTIVO","SUSPENDIDO"};
        
        JComboBox<String> tipoUsuario = agregarLista(opcionesTipoUsuario);
        JComboBox<String> estadoUsuario = agregarLista(opcionesEstado);

        /**Formateo de las columnas */
        TableColumn tipoUsuarioColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(2);
        tipoUsuarioColumn.setCellEditor(new DefaultCellEditor(tipoUsuario));

        TableColumn estadoUsuarioColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(3);
        estadoUsuarioColumn.setCellEditor(new DefaultCellEditor(estadoUsuario));

        Object[] nuevoUsuario = {"nombreUsuario","contraseña",tipoUsuario,estadoUsuario};
        new CRUDUsuarios().insertarUsuario("nombreUsuario", "contraseña", "VENDEDOR", "INACTIVO");
        return nuevoUsuario;
    }

    public void cargarUsuarios(tableMaker creadorTabla) throws SQLException {
        String [] opcionesTipoUsuario = {"VENDEDOR","ADMINISTRADOR"};
        String [] opcionesEstado = {"ACTIVO","SUSPENDIDO"};
        
        JComboBox<String> tipoUsuario = agregarLista(opcionesTipoUsuario);
        JComboBox<String> estadoUsuario = agregarLista(opcionesEstado);

        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaUsuarios = bdObject.createStatement().executeQuery(
            "SELECT * FROM USUARIOS"
        );

        while (listaUsuarios.next()){

            TableColumn tipoUsuarioColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(2);
            tipoUsuarioColumn.setCellEditor(new DefaultCellEditor(tipoUsuario));
    
            TableColumn estadoUsuarioColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(3);
            estadoUsuarioColumn.setCellEditor(new DefaultCellEditor(estadoUsuario));
            Object Usuarios[] = {
                listaUsuarios.getString(1),
                listaUsuarios.getString(2),
                listaUsuarios.getString(3),
                listaUsuarios.getString(4)
            };
            creadorTabla.agregarFila(Usuarios);
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
