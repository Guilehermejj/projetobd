package com.example.projetobd;

public class Usuario {

    public Usuario() {
    }
    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, int numeroUsuario) {
        this.setIdUsuario(idUsuario);
        this.setNomeUsuario(nomeUsuario);
        this.setEmailUsuario(emailUsuario);
        this.setNumeroUsuario(numeroUsuario);

    }

    public Usuario(String nomeUsuario, String emailUsuario int numeroUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario
        this.numeroUsuario = numeroUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario='" + nomeUsuario + '\'' + ", NumeroUsuario=" + numeroUsuario + '}';
        //"Usuario{idUsuario=1, nomeUsuario=Ronan, idadeUsuario=30}"
    }
    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;

    private int  numeroUsuario;
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
    protected int getNumeroUsuario() {
        return numeroUsuario;
    }

    protected void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }
}

