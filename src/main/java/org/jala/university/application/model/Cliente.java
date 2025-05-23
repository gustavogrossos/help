package org.jala.university.application.model;

public class Cliente {
    private int id;
    private String cpf;
    private String nome;
    private String email;

    public Cliente() {}

    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
