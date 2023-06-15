package com.example.projetobd;

public class Usuario {

    public Usuario() {
    }
    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario) {
        this.setIdUsuario(idUsuario);
        this.setNomeUsuario(nomeUsuario);
        this.setEmailUsuario(emailUsuario);
    }
    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    protected int getIdUsuario() {
        return idUsuario;
    }

    protected void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    protected String getNomeUsuario() {
        return nomeUsuario;
    }

    protected void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    protected String getEmailUsuario() {
        return emailUsuario;
    }

    protected void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}

