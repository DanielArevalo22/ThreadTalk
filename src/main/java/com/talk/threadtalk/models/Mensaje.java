package com.talk.threadtalk.models;

import java.util.Date;

public class Mensaje {

    private int idMensaje;
    private String texto;
    private Date fechaEnvio;
    private int idUsuario;
    private int idForo;
    private String status;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String texto, Date fechaEnvio, int idUsuario, int idForo, String status) {
        this.idMensaje = idMensaje;
        this.texto = texto;
        this.fechaEnvio = fechaEnvio;
        this.idUsuario = idUsuario;
        this.idForo = idForo;
        this.status = status;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "idMensaje=" + idMensaje + ", texto=" + texto + ", fechaEnvio=" + fechaEnvio + ", idUsuario=" + idUsuario + ", idForo=" + idForo + ", status=" + status + '}';
    }

}
