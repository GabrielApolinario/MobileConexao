package br.com.calebbiel.mybanco2;

public class Cliente {

    private int idCliente;
    private String nome;
    private String email;
    private String celular;
    private String cpf;

    public Cliente() {

    }

    public Cliente(int idCliente, String nome, String email, String celular, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.cpf = cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
