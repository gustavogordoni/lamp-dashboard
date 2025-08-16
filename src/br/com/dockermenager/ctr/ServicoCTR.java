/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.ctr;

import br.com.dockermenager.dao.ConfigManagerDAO;
import br.com.dockermenager.dao.DockerDAO;

/**
 *
 * @author gustavo
 */
public class ServicoCTR {

    private ConfigManagerDAO configDAO;

    public ServicoCTR() {
        this.configDAO = new ConfigManagerDAO();
    }
    
    public void salvarCaminho(String path) {
        configDAO.salvarCaminho(path);
    }
    
    public String carregarCaminho() {
        return configDAO.carregarCaminho();
    }

    public boolean iniciar(String composeFile, String servico) {
        return DockerDAO.iniciarContainer(composeFile, servico);
    }

    public boolean parar(String composeFile, String servico) {
        return DockerDAO.pararContainer(composeFile, servico);
    }

    public boolean isRunning(String containerName) {
        return DockerDAO.statusContainer(containerName);
    }
}
