/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author gustavo
 */
public class DockerDAO {

    public static String executarComando(String comando) {
        StringBuilder resultado = new StringBuilder();
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", comando);
            Process processo = pb.start();

            BufferedReader stdOut = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            BufferedReader stdErr = new BufferedReader(new InputStreamReader(processo.getErrorStream()));

            String linha;
            while ((linha = stdOut.readLine()) != null) {
                resultado.append(linha).append("\n");
            }
            while ((linha = stdErr.readLine()) != null) {
                resultado.append(linha).append("\n");
            }

            int exitCode = processo.waitFor();
            if (exitCode != 0) {
                resultado.append("ERRO_EXIT_CODE=").append(exitCode);
            }
        } catch (Exception e) {
            resultado.append("Erro: ").append(e.getMessage());
        }
        return resultado.toString().trim();
    }

    public static boolean iniciarContainer(String nomeComposeFile, String servico) {
        String cmd = "docker compose -f \"" + nomeComposeFile + "\" up -d " + servico;
        String resultado = executarComando(cmd);
        return resultado.contains("Creating") || resultado.contains("Starting") || resultado.contains("is up-to-date");
    }

    public static boolean pararContainer(String nomeComposeFile, String servico) {
        String cmd = "docker compose -f \"" + nomeComposeFile + "\" stop " + servico;
        String resultado = executarComando(cmd);
        return resultado.contains("Stopping") || resultado.contains("Stopped");
    }

    public static boolean statusContainer(String containerName) {
        try {
            String resultado = executarComando(
                    "docker ps --filter \"name=^/" + containerName + "$\" --format \"{{.Status}}\""
            );
            return resultado != null && resultado.trim().startsWith("Up");
        } catch (Exception e) {
            return false;
        }
    }
}
