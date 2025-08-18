/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.ctr;

import br.com.dockermenager.dao.ConfigManagerDAO;
import br.com.dockermenager.dao.MySQLUtils;
import br.com.dockermenager.dao.DockerDAO;
import br.com.dockermenager.dao.EnvConfig;

/**
 *
 * @author gustavo
 */
public class ServicoCTR {
    
    public void salvarCaminho(String path) {
        ConfigManagerDAO.salvarCaminho(path);
    }
    
    public String carregarCaminho() {
        return ConfigManagerDAO.carregarCaminho();
    }
    
    public void verificarAplicarRoot() {
        MySQLUtils.verificarAplicarRoot();
    }
    
    public String getEnv(String key, String defaultValue) {
        return EnvConfig.get(key, defaultValue);
    }
    
    public void init(String dockerComposePath) {
        EnvConfig.init(dockerComposePath);
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
