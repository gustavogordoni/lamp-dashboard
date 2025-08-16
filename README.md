# LAMP Dashboard - Gerenciador de Containers

Este projeto é um **dashboard em Java (Swing)** que permite gerenciar facilmente os containers do repositório [lamp-compose](https://github.com/gustavogordoni/lamp-compose).

Com ele, você pode:

- Iniciar/Parar containers Docker
- Acompanhar o status dos serviços

---

## Tecnologias

- [Java 24.0.2](https://www.java.com/)
- [Netbeans 26](https://netbeans.apache.org/front/main/download/)
- [Docker](https://www.docker.com/) + [Docker Compose](https://docs.docker.com/compose/)

---

## Como usar

1. Clone este repositório
   
```
git clone https://github.com/gustavogordoni/lamp-dashboard.git
````

2. Certifique-se de clonar o repositório [`lamp-compose`](https://github.com/gustavogordoni/lamp-compose).
   
```
git clone https://github.com/gustavogordoni/lamp-compose.git
````

3. Copie a pasta dashboard do projeto para dentro de [`lamp-compose`](https://github.com/gustavogordoni/lamp-compose)
```
cp -r lamp-dashboard/dashboard/ lamp-compose/
````

4. Acesse o diretório lamp-dashboard
```
cd lamp-compose
````

5. Rode o dashboard:

```
java -jar dashboard/lamp-dashboard.jar
```

6. Use a interface para gerenciar os serviços:

* **PHP + Apache**
* **MySQL**
* **phpMyAdmin**
* **PostgreSQL**
* **pgAdmin**

---

## Onde usar

Este dashboard foi criado para:

* **Facilitar o gerenciamento** de containers Docker
* Servir como **painel de controle rápido** em ambiente local
* Evitar comandos manuais de `docker compose up -d`, `docker down`, etc.
