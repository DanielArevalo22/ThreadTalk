package com.talk.threadtalk.models;

import java.util.Date;
import java.util.List;

public class Foro {

    private int idForo;
    private List<Mensaje> listaMensajes;
    private List<Usuario> usuariosParticipantes;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private String estado;

    public Foro() {
    }

    public Foro(int idForo, List<Mensaje> listaMensajes, List<Usuario> usuariosParticipantes, Date fechaCreacion, Date fechaActualizacion, String estado) {
        this.idForo = idForo;
        this.listaMensajes = listaMensajes;
        this.usuariosParticipantes = usuariosParticipantes;
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

    @Override
    public String toString() {
        return "Foro{" + "idForo=" + idForo + ", listaMensajes=" + listaMensajes + ", usuariosParticipantes=" + usuariosParticipantes + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", estado=" + estado + '}';
    }

}
