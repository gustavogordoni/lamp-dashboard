/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;

/**
 *
 * @author gustavo
 */
public class EnvConfig {
    
    private static Dotenv dotenv;

    public static void init(String dockerComposePath) {
        File dockerFile = new File(dockerComposePath);
        File envFile = new File(dockerFile.getParentFile(), ".env");

        if (envFile.exists()) {
            dotenv = Dotenv.configure()
                .directory(envFile.getParent())
                .ignoreIfMissing()
                .load();
            System.out.println("Arquivo .env ENCONTRADO.");
        } else {
            dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();
            System.out.println("Arquivo .env não encontrado. Usando valores defaults.");
        }
    }

    public static String get(String key, String defaultValue) {
        if (dotenv == null) {
            return defaultValue;
        }
        return dotenv.get(key, defaultValue);
    }

}
