# ☕ Fundamentos Java: Persistência de Dados com Padrão DAO

> **Status:** Concluído (Projeto de Estudo de Backend)

Este projeto foi desenvolvido para consolidar conhecimentos fundamentais em **Java SE**, focando na comunicação com bancos de dados relacionais (**MySQL**) através de **JDBC**. O objetivo principal foi implementar uma arquitetura limpa utilizando o padrão de projeto **DAO (Data Access Object)**.

## 🚀 Tecnologias Utilizadas
* **Linguagem:** Java 21 (LTS)
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** MySQL 8.0
* **Conectividade:** JDBC (Java Database Connectivity)

## 🏗️ Arquitetura e Padrões
Para garantir a organização e escalabilidade do código, o projeto foi dividido nas seguintes camadas:

1.  **Model:** Classes POJO (Plain Old Java Objects) que representam as entidades do banco de dados (ex: `Usuario`).
2.  **DAO (Data Access Object):** Camada de persistência que isola toda a lógica de acesso a dados (SQL) do restante da aplicação.
3.  **ConnectionFactory:** Implementação centralizada para gerenciamento e abertura de conexões com o MySQL.

## ✨ Funcionalidades Implementadas
* **CRUD Completo:** Criação, Leitura, Atualização e Deleção de registros no banco de dados.
* **Segurança:** Uso de `PreparedStatement` para evitar ataques de **SQL Injection**.
* **Tratamento de Exceções:** Gestão robusta de erros SQL com `try-catch` e fechamento de recursos.
* **Configuração via Maven:** Gerenciamento automatizado do driver `mysql-connector-j`.

## ⚙️ Como rodar o projeto
1. Clone o repositório.
2. Certifique-se de ter o **MySQL** instalado e rodando.
3. Crie um banco de dados e as tabelas conforme a classe `Model`.
4. Ajuste as credenciais (URL, User, Password) na classe `ConnectionFactory`.
5. Execute a classe principal através do seu IDE favorita (Eclipse/IntelliJ).

---
**Desenvolvido por [Henrique Oliveira Pires](https://github.com/hrnq-op)** *Focado em construir bases sólidas para o desenvolvimento Java Backend.*
