package Mapeador;

import java.sql.*;

/**
 * Class ConectionDB: This class connect the Java project with the MySQL
 * database
 */
public class ConexionDB {
    private Connection conn;
    private String dbName = "dbfacturacion";
    private String dbDirection = "localhost";

    private String user = "root";
    private String password = "basededatos";

    /** initConnection: get the Connection with the database */
    private Connection initConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+dbDirection+"/"+dbName+"?useSSL=false", user, password);
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }
        return conn;
    }

    public Connection getConnection(){
        if (conn == null){
            return initConnection();
        }else{
            return conn;
        }
    }

    /** closeConnection: finish the connection with the database */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * createData: (C) Create a register in a table
     * 
     * @param tableName
     * @param columnName
     * @param values
     * @param condition
     * @return
     */
    /** public static void createData(String tableName, String columnName, int lengthValues, String values,String condition) {
        auxiliarDB = new AuxiliarConexionDB();
        try {
            Statement s = conn.prepareStatement("INSERT INTO "+tableName+" VALUES "+auxiliarDB.getSpaces(lengthValues));
            if (condition == "null") {
                s.executeUpdate("INSERT INTO" + tableName + " (" + columnName + ") VALUES (" + values + ")");
            } else {
                conn.prepareStatement(
                    "INSERT INTO" + tableName + " (" + columnName + ") VALUES (" + values + ") WHERE " + condition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * updateData: (U)Update the fields of a table
     * 
     * @param tableName
     * @param values
     * @param condition
     */
    /**public static void updateData(String tableName, String values, String condition) {

        try {
           
            if (condition == "null") {
                conn.prepareStatement("UPDATE " + tableName + " SET " + values);
            } else {
                conn.prepareStatement("UPDATE " + tableName + " SET " + values + " WHERE " + condition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/ 

    /** deleteData: (D) Delete the fields of a table
    public static void deleteData(String tableName, String condition) {
        try {
            if (condition == "null") {
                conn.prepareStatement("DELETE FROM "+tableName);
            } else {
                conn.prepareStatement("DELETE FROM "+tableName+" WHERE "+condition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**getData: (R) Allows recovery data from database
     * @param fields
     * @param @tableName
     * @param condition (if exists)
     * 
     * @return resultSet (The subtable with the results of Query)
    */
    /**public static ResultSet getData(String fields, String tableName, String condition) {
        ResultSet resultSet = null;
        try{
            /**Creating the resultSet
            if (condition == "null"){
                resultSet = conn.createStatement().executeQuery ("SELECT "+fields+" FROM "+tableName);  
            }else{
                resultSet = conn.createStatement().executeQuery ("SELECT "+fields+" FROM "+tableName+" WHERE "+condition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }*/

}