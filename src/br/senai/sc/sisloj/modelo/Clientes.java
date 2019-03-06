/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.sisloj.modelo;

/**
 *
 * @author Aluno
 */
public class Clientes {
    
    private int codigo;
    private String nomeC;
    private String enderecoC;
    private String bairroC;
    private String complementoC;
    private long cepC;
    private long celC;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public String getEnderecoC() {
        return enderecoC;
    }

    public void setEnderecoC(String enderecoC) {
        this.enderecoC = enderecoC;
    }

    public String getBairroC() {
        return bairroC;
    }

    public void setBairroC(String bairroC) {
        this.bairroC = bairroC;
    }

    public String getComplementoC() {
        return complementoC;
    }

    public void setComplementoC(String complementoC) {
        this.complementoC = complementoC;
    }

    public long getCepC() {
        return cepC;
    }

    public void setCepC(long cepC) {
        this.cepC = cepC;
    }

    public long getCelC() {
        return celC;
    }

    public void setCelC(long celC) {
        this.celC = celC;
    }

 
}
