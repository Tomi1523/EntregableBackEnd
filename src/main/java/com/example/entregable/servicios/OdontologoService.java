package com.example.entregable.servicios;

import com.example.entregable.dao.OdontologoDao.OdontologoDao;
import com.example.entregable.dao.OdontologoDao.OdontologoDaoH2;
import com.example.entregable.entidades.Odontologo;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
@AllArgsConstructor
public class OdontologoService {
    private final static Logger logger = LogManager.getLogger(OdontologoDaoH2.class);

    private final OdontologoDao odontologoDao;



    public void agregar(Odontologo O){
        try {
            odontologoDao.AGREGAR(O);
        } catch (SQLException e) {
            logger.fatal("No se pudo agregar el al odontologo");
        }
    }
    public Odontologo buscar(int id){
       return odontologoDao.SELECT(id);
    }

    public void delete(int id){
        try {
            odontologoDao.DELETE(id);
        } catch (SQLException e) {
            logger.fatal("No se pudo borrar al odontologo");
        }

    }

    public void update(Odontologo O){
        try {
            odontologoDao.UPDATE(O);
        } catch (SQLException e) {
            logger.fatal("Fallo la actualizacion");
        }
    }


}
