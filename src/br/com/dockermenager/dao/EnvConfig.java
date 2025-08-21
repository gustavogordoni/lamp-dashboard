/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dockermenager.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gustavo
 */
public class EnvConfig {

    private static Dotenv dotenv;
    private static File envFile;

    public static void init(String dockerComposePath) {
        File dockerFile = new File(dockerComposePath);
        envFile = new File(dockerFile.getParentFile(), ".env");

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

    public static void salvar(Map<String, String> variaveis) throws IOException {
        if (envFile == null) {
            throw new IllegalStateException("EnvConfig não inicializado!");
        }

        List<String> linhas = Files.readAllLines(envFile.toPath(), StandardCharsets.UTF_8);
        List<String> novasLinhas = new ArrayList<>();

        for (String linha : linhas) {
            String novaLinha = linha;
            if (!linha.trim().startsWith("#") && linha.contains("=")) {
                String chave = linha.split("=", 2)[0].trim();
                if (variaveis.containsKey(chave)) {
                    novaLinha = chave + "=" + variaveis.get(chave);
                }
            }
            novasLinhas.add(novaLinha);
        }

        Files.write(envFile.toPath(), novasLinhas, StandardCharsets.UTF_8);

        dotenv = Dotenv.configure()
                .directory(envFile.getParent())
                .ignoreIfMissing()
                .load();
    }

    public static void redefinirPortas() throws IOException {
        Map<String, String> defaults = new LinkedHashMap<>();

        defaults.put("PHP_PORT", "80");
        defaults.put("POSTGRES_PORT", "5432");
        defaults.put("PGADMIN_PORT", "8081");
        defaults.put("MYSQL_PORT", "3306");
        defaults.put("PMA_PORT", "8080");

        salvar(defaults);
    }

    public static void redefinirVolumes() throws IOException {
        Map<String, String> defaults = new LinkedHashMap<>();

        defaults.put("PHP_VOLUME", "./web:/var/www/html");
        defaults.put("POSTGRES_VOLUME", "./postgres:/var/lib/postgresql/data");
        defaults.put("MYSQL_VOLUME", "./mysql:/var/lib/mysql");

        salvar(defaults);
    }

    public static void redefinirCredenciais() throws IOException {
        Map<String, String> defaults = new LinkedHashMap<>();

        defaults.put("MYSQL_ROOT_PASSWORD", "root");
        defaults.put("POSTGRES_USER", "postgres");
        defaults.put("POSTGRES_PASSWORD", "postdba");
        defaults.put("PGADMIN_DEFAULT_EMAIL", "postgres@servidor.com");
        defaults.put("PGADMIN_DEFAULT_PASSWORD", "posdtba");

        salvar(defaults);
    }

}
