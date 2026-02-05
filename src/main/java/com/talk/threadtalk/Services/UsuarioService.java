package com.talk.threadtalk.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.talk.threadtalk.DAO.UsuarioDAO;
import com.talk.threadtalk.Exceptions.UsuarioException;
import com.talk.threadtalk.models.Usuario;
import java.sql.SQLException;

public class UsuarioService {

    /* CON ESTE FORMATO SE VA A INSERTAR LA FECHA EN MYSQL */
    private final SimpleDateFormat formatoFechaMySQL = new SimpleDateFormat("yyyy-MM-dd");

    public boolean registrarUsuario(String nombres, String username, String password, String fechaNacimientoStr)
            throws UsuarioException {
        validarCamposRegistro(nombres, username, password, fechaNacimientoStr);
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Date fechaNacimiento = formatoFechaMySQL.parse(fechaNacimientoStr);
            return usuarioDAO.createUser(
                    nombres.trim(),
                    username.trim(),
                    password.trim(),
                    fechaNacimiento);
        } catch (ParseException e) {
            throw new UsuarioException("Formato de fecha inválido. Use: yyyy-MM-dd");
        } catch (SQLException e) {
            throw new UsuarioException("Error al registrar usuario", e);
        }
    }

    public Usuario login(String username, String password) throws UsuarioException {

        /* VALIDA SI USERNAME Y PASSWORD NO ESTAN VACIOS */
        if (username == null || username.trim().isEmpty()) {
            throw new UsuarioException("El username es obligatorio");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new UsuarioException("La contraseña es obligatoria");
        }

        try {
            /*
             * .TRIM() PARA EVITAR LOS ESPACIOS EN BALNCO Y LLAMAR AL DAO QUE BUSCA EN BASE
             * USUARIO
             */
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.findUsuario(username.trim(), password.trim());

            if (usuario == null) {
                throw new UsuarioException("Usuario o contraseña incorrectos");
            }

            return usuario;
        } catch (SQLException e) {
            throw new UsuarioException("Error al iniciar sesión", e);
        }
    }

    public boolean eliminarUsuario(String username, String password) throws UsuarioException {

        if (username == null || password == null) {
            throw new UsuarioException("Datos inválidos");
        }

        try {
            /* METODO PARA ELIMINAR UN REGISTRO LOGICO */
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean eliminado = usuarioDAO.eliminarUsuario(username.trim(), password.trim());
            if (!eliminado) {
                throw new UsuarioException("No se pudo eliminar el usuario");
            }

            return true;
        } catch (UsuarioException | SQLException e) {
            throw new UsuarioException("Error eliminando usuario", e);
        }
    }

    public boolean actualizarUsuario(String nombres, String username, String password) throws UsuarioException {

        /* VARIOS IFS PORQUE VAN A EVALUAR CAMPOS INDEPENDIENTES....... */
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new UsuarioException("El nombre no puede estar vacío");
        }

        if (username == null || username.trim().isEmpty()) {
            throw new UsuarioException("El username no puede estar vacío");
        }

        if (password == null || password.trim().length() < 6) {
            throw new UsuarioException("La contraseña debe tener mínimo 6 caracteres");
        }

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean actualizado = usuarioDAO.actualizarUsuario(nombres.trim(), username.trim(), password.trim());

            if (!actualizado) {
                throw new UsuarioException("No se pudo actualizar el usuario");
            }

            return true;
        } catch (UsuarioException | SQLException e) {
            throw new UsuarioException("Error actualizando usuario", e);
        }
    }

    public String buscarUsuarioPorId(int idUsuario) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.buscarUsuarioPorId(idUsuario);
        } catch (SQLException e) {
            System.err.println("Error en service buscarUsuarioPorId: " + e.getMessage());
            return null;
        }
    }

    /*
     * VALIDACION PARA EVITAR EXTENDER EL METODO DE REGISTRO POR ESO
     * ES MEJOR SEPARAR TAREAS 
     */
    private void validarCamposRegistro(String nombres, String username, String password, String fechaNacimiento)
            throws UsuarioException {

        if (nombres == null || nombres.trim().isEmpty()) {
            throw new UsuarioException("El nombre es obligatorio");
        }

        if (username == null || username.trim().isEmpty()) {
            throw new UsuarioException("El username es obligatorio");
        }

        if (password == null || password.trim().length() < 6) {
            throw new UsuarioException("La contraseña debe tener mínimo 6 caracteres");
        }

        if (fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
            throw new UsuarioException("La fecha de nacimiento es obligatoria");
        }
    }
}
