package com.talk.threadtalk.Services;

import java.sql.SQLException;
import java.util.List;

import com.talk.threadtalk.DAO.MensajeDAO;
import com.talk.threadtalk.Exceptions.MensajeException;
import com.talk.threadtalk.models.Mensaje;

public class MensajeService {

    /* DECLARAR GLOBAL PARA EVITAR DUPLICIDAD DE OBJETOS DE TIPO MENSAJEDAO */
    private MensajeDAO mensajeDAO;

    public boolean crearMensaje(String texto, int idUsuario, int idForo) {
        validarTexto(texto);
        validarIds(idUsuario, idForo);
        try {
            return mensajeDAO.crearMensaje(texto.trim(), idUsuario, idForo);
        } catch (SQLException e) {
            throw new MensajeException("Error al guardar el mensaje");
        }
    }

    public List<Mensaje> obtenerMensajes(int idUsuario, int idForo) {
        validarIds(idUsuario, idForo);
        try {
            return mensajeDAO.buscarMensaje(idUsuario, idForo);
        } catch (SQLException e) {
            throw new MensajeException("Error al obtener mensajes del foro");
        }
    }

    public boolean eliminarMensaje(int idMensaje) {
        if (idMensaje <= 0) {
            throw new MensajeException("ID del mensaje inválido");
        }
        try {
            return mensajeDAO.borrarMensaje(idMensaje);
        } catch (SQLException e) {
            throw new MensajeException("Error al eliminar el mensaje");
        }
    }

    public boolean editarMensaje(int idMensaje, String nuevoTexto) {
        if (idMensaje <= 0) {
            throw new MensajeException("ID del mensaje inválido");
        }
        validarTexto(nuevoTexto);
        try {
            return mensajeDAO.editarMensaje(idMensaje, nuevoTexto.trim());
        } catch (SQLException e) {
            throw new MensajeException("Error al actualizar el mensaje");
        }
    }

    /*
     * VALIDACIONES PARA NO EXTENDER LOS METODOS Y PONDER SEPARAR REPSONSABILIDADES
     */

    private void validarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new MensajeException("El mensaje no puede estar vacío");
        }
        if (texto.length() < 2) {
            throw new MensajeException("El mensaje es demasiado corto");
        }
        if (texto.length() > 500) {
            throw new MensajeException("El mensaje supera el límite permitido (500 caracteres)");
        }
    }

    private void validarIds(int idUsuario, int idForo) {
        if (idUsuario <= 0) {
            throw new MensajeException("Usuario inválido");
        }
        if (idForo <= 0) {
            throw new MensajeException("Foro inválido");
        }
    }
}
