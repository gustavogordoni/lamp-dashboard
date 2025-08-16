# LAMP Dashboard

Este projeto é um **dashboard em Java (Swing)** que facilita o gerenciamento de containers Docker .

O dashboard permite **iniciar, parar e visualizar o status** dos serviços abaixo:

- **PHP 7.4 + apache** (`birazn-ifsp-php`)
- **MySQL 5.7** (`birazn-ifsp-mysql`)
- **phpMyAdmin** (`birazn-ifsp-phpmyadmin`)
- **PostgreSQL 12** (`birazn-ifsp-pgsql`)
- **pgAdmin 4** (`birazn-ifsp-pgadmin`)

---

## Tecnologias

- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/)
- [Java](https://www.java.com) com Swing para a interface gráfica

---

## Estrutura dos containers (Padrão)

### 🔹 PHP 7.4 + Apache
- Porta: **80:80**
- Código fonte mapeado em `./web:/var/www/html/`
- Build customizado a partir de `./php/Dockerfile`

### 🔹 MySQL 5.7
- Porta: **3306:3306**
- Volume persistente: `./mysql:/var/lib/mysql`
- Usuário root: **root**
- Senha root: **root**
- Banco inicial: **teste**

### 🔹 phpMyAdmin
- Porta: **8080**
- Build customizado a partir de `./phpmyadmin/Dockerfile`
- Conectado automaticamente ao container MySQL

### 🔹 PostgreSQL 12
- Porta: **5432:5432**
- Volume persistente: `./postgres:/var/lib/postgresql/data`
- Usuário: **postgres**
- Senha: **postdba**

### 🔹 pgAdmin 4
- Porta: **8081**
- Login: **postgres@servidor.com**
- Senha: **postdba**
- Depende do PostgreSQL

---

<!--
## Pré-requisitos

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17+](https://adoptium.net/)

---

## Como rodar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/lamp-dashboard.git
cd lamp-dashboard
```

2. Suba os containers pela primeira vez:

```
docker-compose up -d
```

3. Rode o dashboard:

```
java -jar lamp-dashboard.jar
```
-->
---

## Acesso aos serviços

* **Aplicação PHP** → [http://localhost](http://localhost)
* **phpMyAdmin** → [http://localhost:8080](http://localhost:8080)
* **pgAdmin** → [http://localhost:8081](http://localhost:8081)
* **MySQL** → `localhost:3306`
* **PostgreSQL** → `localhost:5432`

---

## Solução de problemas

### PHP/phpMyAdmin não conecta ao MySQL

A versão **MySQL 8.0** apresenta instabilidades. Este projeto usa **MySQL 5.7**.
Se ainda assim houver problemas, execute dentro do container:

```
docker exec -it birazn-ifsp-mysql bash
mysql -u root -p
# Senha: root
```

E aplique:

```
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root';
```

---

## Licença

Este projeto é de uso educacional no IFSP.
Sinta-se livre para adaptar e melhorar
