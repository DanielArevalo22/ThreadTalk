package com.talk.threadtalk.Services;

import java.sql.SQLException;
import java.util.List;

import com.talk.threadtalk.DAO.ForoDAO;
import com.talk.threadtalk.Exceptions.ForoException;
import com.talk.threadtalk.models.Foro;

public class ForoService {

    private ForoDAO foroDAO;

    public boolean crearForo(String nombre) {
        validarNombre(nombre);
        try {
    
            Foro existente = foroDAO.buscarForoPorNombre(nombre.trim());
            if (existente != null) {
                throw new ForoException("Ya existe un foro con ese nombre");
            }

            return foroDAO.crearForo(nombre.trim());

        } catch (SQLException e) {
            throw new ForoException("Error al crear foro");
        }
    }

    public List<Foro> listarForos() {

        try {
            return foroDAO.listarForos();
        } catch (SQLException e) {
            throw new ForoException("Error al obtener lista de foros");
        }
    }

    public Foro buscarForo(String nombre) {
        validarNombre(nombre);
        try {
            Foro foro = foroDAO.buscarForoPorNombre(nombre.trim());
            if (foro == null) {
                throw new ForoException("Foro no encontrado");
            }
            return foro;
        } catch (SQLException e) {
            throw new ForoException("Error al buscar foro");
        }
    }

    public boolean editarForo(int idForo, String nuevoNombre) {
        if (idForo <= 0) {
            throw new ForoException("ID de foro inválido");
        }

        validarNombre(nuevoNombre);

        try {
            return foroDAO.editarForo(idForo, nuevoNombre.trim());
        } catch (SQLException e) {
            throw new ForoException("Error al actualizar foro");
        }
    }

    public boolean eliminarForo(int idForo) {

        if (idForo <= 0) {
            throw new ForoException("ID de foro inválido");
        }

        try {
            return foroDAO.eliminarForo(idForo);
        } catch (SQLException e) {
            throw new ForoException("Error al eliminar foro");
        }
    }

    /* VALIDACIONES */

    private void validarNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ForoException("El nombre del foro no puede estar vacío");
        }

        if (nombre.length() < 3) {
            throw new ForoException("El nombre del foro es demasiado corto");
        }

        if (nombre.length() > 60) {
            throw new ForoException("El nombre del foro es demasiado largo");
        }
    }
}
