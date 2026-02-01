package com.talk.threadtalk.models;

import java.util.Date;
import java.util.List;

public class Foro {

    private int idForo;
    private String nombre;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private String estado;

    /*
     * ESTO ES PARA PODER OBTENER EL FORO CON SUS MENSAJES Y PARTICIPANTES SIN
     * AFECTAR EL MODELO DE LA TABLA EN BASE
     */
    private List<Mensaje> listaMensajes;
    private List<Usuario> usuariosParticipantes;

    public Foro() {
    }

    public Foro(int idForo, String nombre, Date fechaCreacion, Date fechaActualizacion, String estado) {
        this.idForo = idForo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public List<Usuario> getUsuariosParticipantes() {
        return usuariosParticipantes;
    }

    public void setUsuariosParticipantes(List<Usuario> usuariosParticipantes) {
        this.usuariosParticipantes = usuariosParticipantes;
    }

    @Override
    public String toString() {
        return "Foro{" +
                "idForo=" + idForo +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
