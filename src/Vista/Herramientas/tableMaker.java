package Vista.Herramientas;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tableMaker {

    DefaultTableModel dtm;
    JTable tabla;
    JScrollPane contenedorTabla;

    private void crearTabla(String[] columnas, int posX, int posY, int width, int heigth) {
        /** Definicion de la tabla y sus datos */
        Object[][] datos = new Object[][] {};

        dtm = new DefaultTableModel(datos, columnas);
        tabla = new JTable(dtm);
        tabla.setBounds(posX, posY, width, heigth);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 80));

        /** Personalizacion de la tabla */
        tabla.getTableHeader().setFont(new fontMaker().obtainFont("fuenteTituloTabla"));
        tabla.getTableHeader().setForeground(new colorMaker().obtainColor("grisEnfasisOscuro"));
        tabla.getTableHeader().setBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, new colorMaker().obtainColor("grisEnfasisOscuro")));
        tabla.getTableHeader().setBounds(0, 0, tabla.getWidth(), 90);
        tabla.getTableHeader().setBackground(null);
        tabla.getTableHeader().setPreferredSize(new Dimension(width, 32));

        tabla.setRowHeight(32);
        tabla.setFont(new fontMaker().obtainFont("fuenteItemTabla"));
        tabla.setGridColor(new colorMaker().obtainColor("grisEnfasisMedio"));
        tabla.setShowVerticalLines(false);
        tabla.setBackground(null);

        /** Diseño del contenedorTabla para instertar la tabla */
        contenedorTabla = new JScrollPane(tabla);
        contenedorTabla.setBounds(posX, posY, width, heigth);
        contenedorTabla.setBackground(new colorMaker().obtainColor("grisEnfasisMedio"));
        contenedorTabla
                .setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new colorMaker().obtainColor("invisible")));
        contenedorTabla.updateUI();
    }

    public JScrollPane getTabla(String[] columnas, int posX, int posY, int width, int heigth) {
        if (tabla == null) {
            crearTabla(columnas, posX, posY, width, heigth);
        }
        return contenedorTabla;
    }

    public void agregarFila(Object[] data) {
        dtm.addRow(data);
    }

    public void quitarFilaSeleccionada() {
        dtm.removeRow(tabla.getSelectedRow());
    }

    public DefaultTableModel getModelo() {
        return dtm;
    }

    public JTable getMetatabla() {
        return tabla;
    }


}