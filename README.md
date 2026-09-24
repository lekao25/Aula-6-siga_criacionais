# SIGA - Padrões Criacionais

Atividade prática de Técnicas de Programação II sobre padrões criacionais.

## Padrões utilizados

### Abstract Factory

Foi criada a interface `FabricaBanco`, com as fábricas concretas:

- `FabricaMySQL`;
- `FabricaPostgreSQL`.

Cada fábrica cria uma família coerente de objetos:

- conexão;
- comando.

Assim, uma conexão MySQL não é combinada com um comando PostgreSQL.

### Builder

Foi criada a classe `ConsultaBuilder`.

Ela permite montar consultas utilizando métodos nomeados e encadeáveis, como:

- `comFiltro`;
- `comOrdenacao`;
- `comLimite`;
- `comOffset`;
- `comTimeout`;
- `somenteAtivos`.

A construção da consulta é finalizada pelo método `construir()`.

### Singleton

A classe `AcessoDados` foi transformada em Singleton.

Ela possui:

- construtor privado;
- instância estática;
- método `obterInstancia()`.

Dessa forma, existe apenas uma instância controlada de `AcessoDados`.

## Tecnologias utilizadas

- Java;
- JDK 17 ou superior;
- Git;
- GitHub.

## Como compilar


```bash
javac -d bin src/siga/*.java
