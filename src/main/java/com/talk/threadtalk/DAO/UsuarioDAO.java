package com.talk.threadtalk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.talk.threadtalk.database.Conexion;
import com.talk.threadtalk.models.Usuario;

public class UsuarioDAO {

    public boolean createUser(String nombres, String username, String password, Date fechaNacimiento)
            throws SQLException {
        String sql = "INSERT INTO USUARIOS (nombres, username,password,fecha_nacimiento,fecha_registro,status) VALUES (?,?,?,?,SYSDATE,'A')";
        Connection cn = Conexion.getConexion();
        try {
            /* SETEAMOS LOS PARAMETROS QUE VAN A IR EN EL QUERY */
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setDate(4, (java.sql.Date) fechaNacimiento);

            /*
             * RETORNAMOS TRUE SI EL NUMERO DE COLUMNAS ES MAYOR A 0, QUIERE DECIR INSERT
             * EXITOSO
             */
            int cols = ps.executeUpdate();
            return cols > 0;

        } catch (SQLException e) {
            throw new RuntimeException("ERROR CREANDO USUARIO -> " + e);
        } finally {
            /* CERRAMOS CONEXION */
            if (cn != null) {
                cn.close();
            }
        }
    }

    public Usuario findUsuario(String username, String password) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE USERNAME = ? AND PASSWORD = ? AND STATUS = 'A'";
        Connection cn = Conexion.getConexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            /* SETEAMOS PARAMETROS EN QUERY */
            ps.setString(1, username);
            ps.setString(2, password);

            /* SE USA UN TRY DE ESTA MANERA YA QUE AUTOMATICAMENTE VA A CERRAR EL RESULTSET Y EL PREPAREDSTATEMENT */
            try (ResultSet rs = ps.executeQuery()) {

                /* VALIDA QUE SI ENCONTRO USUARIO */
                if (rs.next()) {
                    /*
                     * OBTIENE TODOS LOS CAMPOS TRAIDOS EN LA CONSULTA Y LOS SETEA EN UN OBJETO TIPO
                     * USUARIO PARA RETORNARLO
                     */
                    Usuario u = new Usuario();
                    u.setIdUsuario(rs.getInt("codigo_usuario"));
                    u.setNombres(rs.getString("nombres"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setStatus(rs.getString("status"));
                    u.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    u.setFechaRegistro(rs.getDate("fecha_registro"));
                    return u;
                }
            } catch (SQLException e) {
                throw new RuntimeException("ERROR VALIDANDO USARIO -> " + e);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR BUSCANDO USARIO -> " + e);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean eliminarUsuario(String username, String password) throws SQLException{
        String sql = "UPDATE USUARIOS SET STATUS = 'I' WHERE USERNAME = ? AND PASSWORD = ?";
        Connection cn = Conexion.getConexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            int cols = ps.executeUpdate();
            ps.close();
             return cols > 0;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR ELIMINANDO USUARIO ->" + e);
        }finally{
            if(cn != null){
                cn.close();
            }
        }
    }

    public boolean actualizarUsuario(String nombres, String username, String password) throws SQLException{
        String sql = "UPDATE USUARIOS SET NOMBRES = ?, USERNAME = ?, PASSWORD = ? WHERE USERNAME = ? AND PASSWORD = ? AND STATUS = 'A'";
        Connection cn = Conexion.getConexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setString(2, username);
            ps.setString(3, password);
            int cols = ps.executeUpdate();
            return cols > 0;
        } catch (SQLException e) {
            throw new RuntimeException("ERROR ELIMINANDO USUARIO ->" + e);
        }finally{
            if (cn != null){
                cn.close();
            }
        }
    }
}
