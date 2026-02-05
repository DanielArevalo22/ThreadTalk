package com.talk.threadtalk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.talk.threadtalk.database.Conexion;
import com.talk.threadtalk.models.Foro;
import com.talk.threadtalk.models.MensajeForoDTO;

public class ForoDAO {

    public boolean crearForo(String nombre) throws SQLException {

        String sql = "INSERT INTO FOROS (nombre, fecha_creacion, fecha_actualizacion, estado) VALUES (?, SYSDATE, SYSDATE, 'A')";
        Connection cn = Conexion.getConexion();
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            int cols = ps.executeUpdate();
            return cols > 0;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR CREANDO FORO", e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public List<Foro> listarForos() throws SQLException {
        String sql = "SELECT id_foro, nombre, fecha_creacion,fecha_actualizacion, estado FROM FOROS WHERE estado = 'A'";
        Connection cn = Conexion.getConexion();
        List<Foro> lista = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Foro f = new Foro();
                f.setIdForo(rs.getInt("id_foro"));
                f.setNombre(rs.getString("nombre"));
                f.setFechaCreacion(rs.getDate("fecha_creacion"));
                f.setFechaActualizacion(rs.getDate("fecha_actualizacion"));
                f.setEstado(rs.getString("estado"));
                lista.add(f);
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR LISTANDO FOROS", e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public Foro buscarForoPorNombre(String titulo) throws SQLException {
        String sql = "SELECT id_foro, nombre, fecha_creacion, fecha_actualizacion, estado FROM FOROS WHERE nombre = ? AND estado = 'A'";
        Connection cn = Conexion.getConexion();
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, titulo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Foro f = new Foro();
                    f.setIdForo(rs.getInt("id_foro"));
                    f.setNombre(rs.getString("nombre"));
                    f.setFechaCreacion(rs.getDate("fecha_creacion"));
                    f.setFechaActualizacion(rs.getDate("fecha_actualizacion"));
                    f.setEstado(rs.getString("estado"));
                    return f;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR BUSCANDO FORO", e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean editarForo(int idForo, String nuevoNombre) throws SQLException {
        String sql = "UPDATE FOROS SET nombre = ?, fecha_actualizacion = SYSDATE WHERE id_foro = ?";
        Connection cn = Conexion.getConexion();
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nuevoNombre);
            ps.setInt(2, idForo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("ERROR EDITANDO FORO", e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean eliminarForo(int idForo) throws SQLException {
        String sql = "UPDATE FOROS SET estado = 'I' WHERE id_foro = ?";
        Connection cn = Conexion.getConexion();
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idForo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR ELIMINANDO FORO", e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }
    
    public List<MensajeForoDTO> cargarForo(String tipo) throws SQLException{
        StringBuilder str = new StringBuilder();
        str.append("select u.nombres, m.texto, m.id_foro from usuarios u, mensajes m, foros f ");
        str.append("where m.id_foro = f.id_foro and m.id_usuario = u.id_usuario and f.nombre = ?");
        Connection cn = Conexion.getConexion();
        List<MensajeForoDTO> objForo = new ArrayList<>();
        
        try (PreparedStatement ps = cn.prepareStatement(str.toString())) {
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                MensajeForoDTO m = new MensajeForoDTO();
                m.setNombres(rs.getString("nombres"));
                m.setMensaje(rs.getString("texto"));
                m.setIdForo(rs.getInt("id_foro"));
                objForo.add(m);
            }
            
            return objForo;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR ELIMINANDO FORO", e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }
}
