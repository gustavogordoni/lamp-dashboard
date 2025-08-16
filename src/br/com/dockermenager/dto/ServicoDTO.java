/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.dto;

/**
 *
 * @author gustavo
 */
public class ServicoDTO {
    private String nome;
    private String status;
    private int porta;
    private String volumePath;
    private String comandoStart;
    private String comandoStop;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getVolumePath() {
        return volumePath;
    }

    public void setVolumePath(String volumePath) {
        this.volumePath = volumePath;
    }

    public String getComandoStart() {
        return comandoStart;
    }

    public void setComandoStart(String comandoStart) {
        this.comandoStart = comandoStart;
    }

    public String getComandoStop() {
        return comandoStop;
    }

    public void setComandoStop(String comandoStop) {
        this.comandoStop = comandoStop;
    }        
}
