package com.talk.threadtalk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.talk.threadtalk.database.Conexion;
import com.talk.threadtalk.models.Mensaje;

public class MensajeDAO {

    public boolean crearMensaje(String texto, int idUsuario, int idForo) throws SQLException {
        // Opción 1: Si fechaEnvio se llena automáticamente con SYSDATE
        String sql = "INSERT INTO MENSAJES (texto, fecha_envio, id_usuario, id_foro, status) VALUES (?, NOW(), ?, ?, 'A')";

        Connection cn = Conexion.getConexion();

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, texto);     
            ps.setInt(2, idUsuario);    
            ps.setInt(3, idForo);      

            int cols = ps.executeUpdate();
            return cols > 0;

        } catch (SQLException e) {
            throw new RuntimeException("ERROR CREATING MESSAGE -> " + e.getMessage(), e);

        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public List<Mensaje> buscarMensaje(int idUsuario, int idForo) throws SQLException {
        String sql = "SELECT id_mensaje, texto, fecha_envio, id_usuario, id_foro FROM MENSAJES WHERE ID_USUARIO = ? AND ID_FORO = ? AND STATUS = 'A'";
        Connection cn = Conexion.getConexion();
        List<Mensaje> mensajesForo = new ArrayList<>();

        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, idUsuario);
            ps.setInt(2, idForo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    /* CREACION DE OBJETO MENSAJE PARA AGREGAR A LISTA Y RETORNAR */
                    Mensaje m = new Mensaje();
                    m.setIdMensaje(rs.getInt("id_mensaje"));
                    m.setTexto(rs.getString("texto"));
                    m.setIdUsuario(rs.getInt("id_usuario"));
                    m.setIdForo(rs.getInt("id_foro"));
                    m.setFechaEnvio(rs.getDate("fecha_envio"));
                    mensajesForo.add(m); // AGREGAMOS EL OBJETO A LA LISTA
                }
                return mensajesForo;
            } catch (SQLException e) {
                throw new RuntimeException("NO SE ENCONTRARON MENSAJES -> " + e);
            }
        } catch (Exception e) {
            throw new RuntimeException("ERROR BUSCANDO MENSAJES -> " + e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean borrarMensaje(int idMensaje) throws SQLException {
        String sql = "UPDATE MENSAJES SET STATUS = 'I' WHERE ID_MENSAJE = ?";
        Connection cn = Conexion.getConexion();

        /* DE ESTA MANERA EL TRY CIERRA EL PREPAREDSTATEMENT */
        try (PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, idMensaje);
            int cols = ps.executeUpdate();
            return cols > 0;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR ELIMINANDO MENSAJE -> " + e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean editarMensaje(int idMensaje, String texto) throws SQLException {
        String sql = "UPDATE MENSAJES SET TEXTO = ? WHERE ID_MENSAJE = ?";
        Connection cn = Conexion.getConexion();

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, texto);
            ps.setInt(2, idMensaje);
            int cols = ps.executeUpdate();
            return cols > 0;
        } catch (Exception e) {
            throw new RuntimeException("ERROR ACTUALIZANDO MENSAJE -> " + e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }
}
