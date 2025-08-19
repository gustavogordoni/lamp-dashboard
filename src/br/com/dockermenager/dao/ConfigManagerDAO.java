/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gustavo
 */
public class ConfigManagerDAO {

    private static final String CONFIG_FILE = "docker-compose-path.txt";

    public static void salvarCaminho(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_FILE))) {
            writer.write(path);
        } catch (IOException e) {
            System.err.println("Erro ao salvar caminho: " + e.getMessage());
        }
    }

    public static String carregarCaminho() {
        File file = new File(CONFIG_FILE);
        if (!file.exists()) {
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}
