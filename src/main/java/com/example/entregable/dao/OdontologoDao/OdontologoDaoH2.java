package com.example.entregable.dao.OdontologoDao;

import com.example.entregable.entidades.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class OdontologoDaoH2 implements OdontologoDao {
    private final static String DB_URL = "jdbc:h2:~/db_odontologos;INIT=RUNSCRIPT FROM 'create.sql';NON_KEYWORDS=USER";
    private final static Logger logger = LogManager.getLogger(OdontologoDaoH2.class);
    private final static String AGREGAR = "INSERT INTO Odontologos(nombre,apellido,matricula) VALUES(?,?,?)";
    private final static String SELECT = "SELECT *  FROM Odontologos where id = ?";
    private final static String DELETE = "DELETE  FROM Odontologos WHERE id = ?";
    private final static String UPDATE = "UPDATE Odontologos set nombre = ?, apellido = ?, matricula = ? where id = ?";

    @Override
    public void AGREGAR(Odontologo o){


        try {
            var connection = getConnection();
            connection = getConnection();
            var insert = connection.prepareStatement(AGREGAR);
            insert.setString(1, o.getNombre());
            insert.setString(2, o.getApellido());
            insert.setInt(3, o.getMatricula());


            insert.execute();
            logger.debug("se agrego correctamente");
            connection.close();
        } catch (SQLException e) {
           logger.error(e.getMessage());
        }
    }



    @Override
    public Odontologo SELECT(int id) {

        try {
            var connection = getConnection();
            connection = getConnection();
            var buscar = connection.prepareStatement(SELECT);
            buscar.setInt(1, id);
            var result = buscar.executeQuery();

            if (result.next()) {
                var nombre = result.getString(2);
                var apellido = result.getString(3);
                var matricula = result.getInt(4);
                return new Odontologo(nombre, apellido, matricula);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void UPDATE(Odontologo o) {

        try {
            var connection = getConnection();
            connection = getConnection();
            var update = connection.prepareStatement(UPDATE);
            update.setString(1, o.getNombre());
            update.setString(2, o.getApellido());
            update.setInt(3, o.getMatricula());
            update.setInt(4, o.getId());

            update.executeUpdate();
            logger.info("se actulizo correctamente");
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public void DELETE(int id) {
        try {
            var connection = getConnection();
            var delete = connection.prepareStatement(DELETE);
            delete.setInt(1, id);

            delete.execute();
            logger.debug("Se elmino correctamente");
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

}
