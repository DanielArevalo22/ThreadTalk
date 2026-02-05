package com.talk.threadtalk.models;

public class MensajeForoDTO {

    private String nombres;
    private String mensaje;
    private int idForo;

    public MensajeForoDTO() {
    }

    public MensajeForoDTO(String nombres, String mensaje, int idForo) {
        this.nombres = nombres;
        this.mensaje = mensaje;
        this.idForo = idForo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

}
