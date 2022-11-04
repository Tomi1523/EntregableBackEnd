package com.example.entregable.dao.OdontologoDao;

import com.example.entregable.entidades.Odontologo;

import java.sql.SQLException;

public interface OdontologoDao {

    void AGREGAR(Odontologo O) throws SQLException;

    Odontologo SELECT(int id);

    void UPDATE(Odontologo O) throws SQLException;

    void DELETE(int id) throws SQLException;
}
