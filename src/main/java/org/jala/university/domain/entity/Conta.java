package org.jala.university.domain.entity;

public class Conta {

    private Integer idConta;
    private Integer idCliente;
    private double saldo;

    public Conta(Integer idConta, Integer idCliente, double saldo) {
        this.idConta = idConta;
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.saldo -= valor;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }
}
