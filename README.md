# Sistema de Gerenciamento de Patrimônios

Projeto desenvolvido em **Java** com acesso a banco de dados **MySQL**, criado com o objetivo de realizar o gerenciamento de patrimônios de uma instituição de educação profissional.

A aplicação foi estruturada buscando seguir os princípios **SOLID**, separando as responsabilidades do sistema em diferentes pacotes, facilitando a manutenção, organização, evolução e testes do projeto.

---

## Sobre o projeto

O sistema permite organizar e controlar informações relacionadas aos patrimônios da instituição, incluindo:

- Cadastro de patrimônios;
- Cadastro de categorias;
- Cadastro de cursos;
- Cadastro de locais;
- Cadastro de usuários;
- Registro de movimentações;
- Registro de baixas patrimoniais;
- Consulta e gerenciamento das informações armazenadas no banco de dados.

O projeto utiliza uma arquitetura organizada em camadas, separando as classes responsáveis pelos dados, acesso ao banco, interface gráfica e recursos visuais.

---

## Tecnologias utilizadas

- **Java**
- **JDBC**
- **MySQL**
- **Eclipse IDE**
- **Git**
- **GitHub**
- **POO — Programação Orientada a Objetos**
- **SOLID**

---

## Estrutura do projeto

O projeto foi dividido nos seguintes pacotes principais:

```text
src/
└── br.com.patrimonio/
    ├── pojo/
    ├── dao/
    ├── janela/
    └── imagens/
```

### POJO

O pacote `pojo` contém as classes que representam as entidades do sistema.

Essas classes armazenam os atributos dos objetos e normalmente possuem:

- Atributos;
- Construtores;
- Métodos `get`;
- Métodos `set`;
- Métodos auxiliares quando necessário.

Exemplos de entidades:

```text
Patrimonios
Categorias
Cursos
Locais
Usuarios
Movimentacoes
BaixasPatrimoniais
```

---

### DAO

O pacote `dao` contém as classes responsáveis pelo acesso ao banco de dados.

DAO significa **Data Access Object**.

Essa camada centraliza operações como:

- INSERT;
- SELECT;
- UPDATE;
- DELETE;
- Conexão com o MySQL;
- Consultas utilizando `PreparedStatement`;
- Conversão dos registros do banco para objetos Java.

Exemplo de organização:

```text
dao/
├── Conexao.java
├── CRUD.java
├── DAOPatrimonio.java
├── DAOCategoria.java
├── DAOCurso.java
├── DAOLocal.java
├── DAOUsuario.java
├── DAOMovimentacao.java
└── DAOBaixaPatrimonial.java
```

A separação da camada DAO evita que comandos SQL fiquem diretamente nas classes da interface gráfica.

---

### Janela

O pacote `janela` contém as telas e componentes da interface gráfica do sistema.

Exemplos:

```text
janela/
├── TelaPrincipal.java
├── TelaLogin.java
├── TelaPatrimonios.java
├── TelaCategorias.java
├── TelaCursos.java
├── TelaLocais.java
├── TelaUsuarios.java
├── TelaMovimentacoes.java
└── TelaBaixasPatrimoniais.java
```

As janelas são responsáveis pela interação entre o usuário e o sistema.

Elas recebem os dados informados pelo usuário e utilizam as classes DAO para realizar as operações no banco de dados.

---

### Imagens

O pacote `imagens` armazena os recursos gráficos utilizados na aplicação.

Exemplos:

- Ícones;
- Logos;
- Imagens dos menus;
- Imagens utilizadas nas telas.

```text
imagens/
├── logo.png
├── patrimonio.png
├── usuarios.png
├── movimentacao.png
└── baixa_patrimonial.png
```

---

## Banco de dados

O projeto utiliza o banco de dados **MySQL**.

Banco utilizado no desenvolvimento:

```text
hakodb
```

Atualmente o banco possui as seguintes tabelas:

| Tabela | Finalidade |
|---|---|
| `patrimonios` | Armazena os patrimônios cadastrados |
| `categorias` | Armazena as categorias dos patrimônios |
| `cursos` | Armazena os cursos da instituição |
| `locais` | Armazena os locais onde os patrimônios podem estar |
| `usuarios` | Armazena os usuários que utilizam o sistema |
| `movimentacoes` | Registra movimentações e transferências dos patrimônios |
| `baixas_patrimoniais` | Registra a retirada ou baixa definitiva de patrimônios |

``` sql
CREATE DATABASE  IF NOT EXISTS `hakodb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hakodb`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hakodb
-- ------------------------------------------------------
-- Server version	26.7.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'e5f1ada2-9c94-11f1-ba60-6e2035d93152:1-23';

--
-- Table structure for table `baixas_patrimoniais`
--

DROP TABLE IF EXISTS `baixas_patrimoniais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baixas_patrimoniais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_baixa` enum('Descarte','Venda','Doação','Furto/Roubo','Extravio') NOT NULL,
  `motivo` text NOT NULL,
  `valor_recuperado` decimal(10,2) DEFAULT '0.00',
  `documento_comprobatorio` varchar(100) DEFAULT NULL,
  `data_baixa` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `baixas_patrimoniais_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `baixas_patrimoniais_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baixas_patrimoniais`
--

LOCK TABLES `baixas_patrimoniais` WRITE;
/*!40000 ALTER TABLE `baixas_patrimoniais` DISABLE KEYS */;
/*!40000 ALTER TABLE `baixas_patrimoniais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Tecnico em Informatica','TI',1,'2026-09-23 13:06:21'),(2,'Estetica','ET',52,'2026-09-23 14:25:40');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locais`
--

DROP TABLE IF EXISTS `locais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `locais_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locais`
--

LOCK TABLES `locais` WRITE;
/*!40000 ALTER TABLE `locais` DISABLE KEYS */;
/*!40000 ALTER TABLE `locais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacoes`
--

DROP TABLE IF EXISTS `movimentacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_movimentacao` enum('Empréstimo','Devolução','Envio Manutenção','Retorno Manutenção','Transferência de Local','Baixa') NOT NULL,
  `responsavel_destino` varchar(150) DEFAULT NULL,
  `documento_responsavel` varchar(50) DEFAULT NULL,
  `data_saida` datetime DEFAULT CURRENT_TIMESTAMP,
  `data_prevista_retorno` datetime DEFAULT NULL,
  `data_retorno_efetivo` datetime DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movimentacoes_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacoes`
--

LOCK TABLES `movimentacoes` WRITE;
/*!40000 ALTER TABLE `movimentacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimentacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonios`
--

DROP TABLE IF EXISTS `patrimonios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrimonios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_tombamento` varchar(50) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` text,
  `curso_id` int DEFAULT NULL,
  `local_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `status` enum('Disponível','Emprestado','Em Manutenção','Baixado/Inativo') DEFAULT 'Disponível',
  `valor_aquisicao` decimal(10,2) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `criado_por` int NOT NULL,
  `atualizado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_tombamento` (`numero_tombamento`),
  KEY `curso_id` (`curso_id`),
  KEY `local_id` (`local_id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `criado_por` (`criado_por`),
  KEY `atualizado_por` (`atualizado_por`),
  CONSTRAINT `patrimonios_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_2` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_4` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `patrimonios_ibfk_5` FOREIGN KEY (`atualizado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonios`
--

LOCK TABLES `patrimonios` WRITE;
/*!40000 ALTER TABLE `patrimonios` DISABLE KEYS */;
/*!40000 ALTER TABLE `patrimonios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_usuarios` varchar(100) NOT NULL,
  `email_usuarios` varchar(100) NOT NULL,
  `senha_hash_usuarios` varchar(255) NOT NULL,
  `perfil_usuarios` enum('Administrador','Coordenador','Assistente') DEFAULT 'Assistente',
  `ativo_usuarios` tinyint(1) DEFAULT '1',
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email_usuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'moro','moro@gmail.com','HAHAHAHAHAHA','Coordenador',1,'2026-09-04 13:51:43','2026-09-04 13:51:43'),(52,'Morinho','andreiamoro@gmail.com','123123','Administrador',1,'2026-09-23 13:05:34','2026-09-23 13:05:34'),(103,'Andréia','andreiamorinho@gmail.com','123@senac','Administrador',1,'2026-09-24 11:37:01','2026-09-24 11:37:01');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-24  9:32:00

```

---

## Relacionamento geral das entidades

De forma simplificada, o sistema trabalha com o seguinte fluxo:

```text
Categorias
    │
    ▼
Patrimônios
    │
    ├──────────────► Locais
    │
    ├──────────────► Movimentações
    │
    └──────────────► Baixas Patrimoniais

Cursos ────────────► Patrimônios / Locais / Movimentações

Usuários ──────────► Cadastros e operações realizadas no sistema
```

Os relacionamentos exatos dependem das chaves estrangeiras definidas no banco de dados.

---

## Princípios SOLID

O projeto está sendo desenvolvido buscando aplicar os princípios **SOLID**.

### S — Single Responsibility Principle

Cada classe deve possuir uma responsabilidade principal.

Exemplo:

```text
Conexao.java
```

Responsável pela conexão com o banco de dados.

```text
DAOPatrimonio.java
```

Responsável pelas operações relacionadas aos patrimônios.

```text
TelaPatrimonios.java
```

Responsável pela interface de gerenciamento de patrimônios.

---

### O — Open/Closed Principle

As classes devem estar abertas para extensão, mas fechadas para modificações desnecessárias.

Interfaces podem ser utilizadas para definir contratos de funcionamento sem depender diretamente das implementações.

---

### L — Liskov Substitution Principle

Classes que implementam uma interface ou herdam de outra classe devem poder ser utilizadas sem quebrar o funcionamento esperado da aplicação.

---

### I — Interface Segregation Principle

Interfaces devem possuir apenas os métodos necessários para cada responsabilidade.

Exemplo:

```java
public interface CRUD<T> {

    String cadastrar(T obj);

    List<T> listar();

    String atualizar(T obj);

    String excluir(int id);
}
```

---

### D — Dependency Inversion Principle

As classes devem depender de abstrações sempre que possível, evitando dependência excessiva de implementações específicas.

---

## 🔌 Conexão com o MySQL

A conexão com o banco de dados é realizada utilizando **JDBC**.

Exemplo simplificado:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    protected Connection con;

    private static final String URL =
        "jdbc:mysql://localhost:3306/hakodb";

    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public boolean abrir() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
            );

            return true;

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(
                "Erro ao conectar ao banco: " + e.getMessage()
            );

            return false;
        }
    }
}
```

> ⚠️ Por segurança, em ambientes reais recomenda-se não deixar usuário e senha do banco diretamente no código-fonte.

---

## 📚 Driver JDBC do MySQL

Para permitir que o Java se conecte ao MySQL é necessário adicionar ao projeto o:

```text
MySQL Connector/J
```

Classe do driver utilizada:

```java
com.mysql.cj.jdbc.Driver
```

Exemplo de URL JDBC:

```text
jdbc:mysql://localhost:3306/hakodb
```

Caso o projeto utilize outra porta, altere a URL:

```text
jdbc:mysql://localhost:PORTA/hakodb
```

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java JDK;
- Eclipse IDE ou outra IDE compatível;
- MySQL Server;
- MySQL Workbench ou ferramenta semelhante;
- MySQL Connector/J;
- Git.

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone URL_DO_REPOSITORIO
```

### 2. Entre na pasta do projeto

```bash
cd NOME_DO_PROJETO
```

### 3. Abra o projeto no Eclipse

No Eclipse:

```text
File
→ Import
→ Existing Projects into Workspace
```

Selecione a pasta do projeto.

---

### 4. Configure o MySQL Connector/J

Adicione o arquivo `.jar` do MySQL Connector/J ao projeto.

No Eclipse:

```text
Clique com o botão direito no projeto
→ Build Path
→ Configure Build Path
→ Libraries
→ Add External JARs
```

Depois selecione o arquivo do Connector/J.

---

### 5. Configure o banco de dados

Crie o banco:

```sql
CREATE DATABASE hakodb;
```

Depois selecione o banco:

```sql
USE hakodb;
```

As tabelas necessárias são:

```text
baixas_patrimoniais
categorias
cursos
locais
movimentacoes
patrimonios
usuarios
```

> Recomenda-se manter no repositório um arquivo SQL contendo a estrutura completa do banco, por exemplo: `database/hakodb.sql`.

---

### 6. Configure a conexão

Altere os dados da classe responsável pela conexão conforme a configuração do seu MySQL:

```java
private static final String URL =
    "jdbc:mysql://localhost:3306/hakodb";

private static final String USUARIO = "root";

private static final String SENHA = "";
```

---

### 7. Execute o sistema

Localize a classe principal da aplicação e execute:

```text
Run As
→ Java Application
```

---

## 🔄 Funcionamento geral

O fluxo básico do sistema pode ser representado desta maneira:

```text
Usuário
   │
   ▼
Interface Gráfica
   │
   ▼
DAO
   │
   ▼
JDBC
   │
   ▼
MySQL
```

Exemplo de cadastro:

```text
Usuário preenche o formulário
        │
        ▼
Tela valida os dados
        │
        ▼
Objeto POJO é criado
        │
        ▼
DAO recebe o objeto
        │
        ▼
PreparedStatement executa o INSERT
        │
        ▼
MySQL salva o registro
```

---

## 📋 Funcionalidades

### Patrimônios

- Cadastrar patrimônio;
- Consultar patrimônios;
- Atualizar informações;
- Excluir ou inativar registros;
- Associar patrimônio a uma categoria;
- Associar patrimônio a um local.

### Categorias

- Cadastrar categorias;
- Listar categorias;
- Alterar categorias;
- Remover categorias.

### Cursos

- Cadastrar cursos;
- Consultar cursos;
- Alterar cursos;
- Excluir cursos.

### Locais

- Cadastrar locais;
- Consultar locais;
- Atualizar locais;
- Excluir locais.

### Usuários

- Cadastrar usuários;
- Controlar informações de acesso;
- Alterar usuários;
- Ativar ou inativar usuários.

### Movimentações

- Registrar movimentação de patrimônio;
- Controlar mudanças de local;
- Consultar histórico de movimentações.

### Baixas patrimoniais

- Registrar baixa de patrimônio;
- Informar motivo da baixa;
- Registrar responsável pela operação;
- Manter histórico das baixas realizadas.

---

## 🗂 Sugestão de organização do repositório

```text
projeto-patrimonio/
│
├── src/
│   └── br/
│       └── com/
│           └── patrimonio/
│               ├── dao/
│               ├── pojo/
│               ├── janela/
│               └── imagens/
│
├── lib/
│   └── mysql-connector-j.jar
│
├── database/
│   └── hakodb.sql
│
├── docs/
│
├── .gitignore
│
└── README.md
```

---

## 🔐 Segurança

Algumas práticas recomendadas para evolução do projeto:

- Não salvar senhas de usuários em texto puro;
- Utilizar hash de senha;
- Utilizar `PreparedStatement`;
- Validar os dados antes de enviar para o banco;
- Evitar deixar credenciais do MySQL publicadas no GitHub;
- Utilizar variáveis de ambiente ou arquivo de configuração ignorado pelo Git;
- Definir permissões de usuário;
- Tratar exceções adequadamente.

---

## 🧪 Testes

O projeto pode ser evoluído com testes automatizados.

Alguns testes recomendados:

```text
Teste de conexão com o banco
Teste de cadastro de patrimônio
Teste de cadastro de usuário
Teste de atualização
Teste de exclusão
Teste de consulta
Teste de movimentação
Teste de baixa patrimonial
```

Ferramentas que podem ser utilizadas:

- JUnit;
- Mockito.

---

## 🚀 Melhorias futuras

Algumas melhorias planejadas ou possíveis:

- [ ] Implementação completa do CRUD;
- [ ] Sistema de login;
- [ ] Controle de perfis de usuário;
- [ ] Criptografia/hash de senhas;
- [ ] Pesquisa de patrimônios;
- [ ] Filtros de consulta;
- [ ] Histórico de movimentações;
- [ ] Relatórios;
- [ ] Exportação de dados;
- [ ] Dashboard;
- [ ] Controle de permissões;
- [ ] Testes automatizados;
- [ ] Documentação do banco de dados;
- [ ] Backup do banco;
- [ ] Validação de formulários;
- [ ] Tratamento centralizado de erros.

---

## 📖 Conceitos utilizados

Durante o desenvolvimento são aplicados conceitos como:

```text
Programação Orientada a Objetos
Encapsulamento
Interfaces
Herança
Polimorfismo
Generics
DAO
POJO
JDBC
CRUD
SOLID
Tratamento de exceções
PreparedStatement
Banco de dados relacional
```

---

## 📌 Status do projeto

🚧 **Projeto em desenvolvimento**

Novas funcionalidades, melhorias na interface, ajustes na estrutura do banco de dados e refatorações serão realizadas durante o desenvolvimento.

---

## 👩‍💻 Autoria

Projeto desenvolvido para fins educacionais e para gerenciamento de patrimônios de uma instituição de educação profissional.

---

## 📄 Licença

Este projeto pode receber uma licença posteriormente.

Caso seja utilizado apenas para fins educacionais, isso também pode ser informado nesta seção.

---

## 🤝 Contribuições

Sugestões e melhorias são bem-vindas.

Para contribuir:

```bash
git checkout -b minha-melhoria
```

Após realizar as alterações:

```bash
git add .
git commit -m "Descrição da melhoria"
git push origin minha-melhoria
```

Depois, abra um **Pull Request** no GitHub.

---

> **Observação:** esta documentação deverá ser atualizada conforme novas funcionalidades, tabelas, telas e regras de negócio forem adicionadas ao projeto.
