# Kafka Lab

Laboratório de estudos e experimentação com **Apache Kafka**, desenvolvido para praticar conceitos de mensageria e arquitetura orientada a eventos.

## 🎯 Objetivo

Explorar na prática o funcionamento do Apache Kafka e entender como aplicações podem se comunicar de forma assíncrona através de eventos.

O projeto serve como um ambiente de experimentação para testar diferentes recursos do Kafka e compreender seu comportamento em cenários de mensageria.

## 🛠️ Tecnologias

* Java
* Spring Boot
* Spring Kafka
* Apache Kafka
* Docker
* Docker Compose

## 📚 Conceitos estudados

* Producers
* Consumers
* Topics
* Partitions
* Consumer Groups
* Offsets
* Messages / Events
* Serialização e desserialização
* Comunicação assíncrona
* Event-driven architecture
* Kafka com Docker

## 🏗️ Arquitetura

A aplicação possui componentes responsáveis por publicar e consumir eventos através do Apache Kafka.

```text
┌──────────────┐
│   Producer   │
└──────┬───────┘
       │
       │ Event
       ▼
┌────────────────┐
│  Apache Kafka  │
│                │
│    Topic       │
└───────┬────────┘
        │
        │ Event
        ▼
┌──────────────┐
│   Consumer   │
└──────────────┘
```

## 🚀 Executando o projeto

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd kafka-lab
```

### 2. Suba o Kafka

```bash
docker compose up -d
```

### 3. Execute a aplicação

Utilizando Maven:

```bash
./mvnw spring-boot:run
```

Ou execute a aplicação diretamente pela sua IDE.

## 🐳 Docker

O ambiente do Kafka é executado utilizando Docker Compose, permitindo iniciar toda a infraestrutura necessária para os testes sem precisar instalar o Kafka diretamente na máquina.

```bash
docker compose up -d
```

Para verificar os containers:

```bash
docker compose ps
```

Para parar o ambiente:

```bash
docker compose down
```

## 🧪 Experimentos

Este projeto será utilizado para testar diferentes cenários relacionados ao Kafka, como:

* Publicação e consumo de mensagens
* Múltiplos consumers
* Consumer Groups
* Particionamento de tópicos
* Processamento de eventos
* Gerenciamento de offsets
* Comunicação entre serviços
* Comportamento de consumers em diferentes cenários

## 📌 Observação

Este é um **projeto de estudos**, criado com o objetivo de aprofundar conhecimentos em Apache Kafka e mensageria distribuída.

A implementação poderá evoluir conforme novos conceitos forem estudados.

## 👨‍💻 Autor

**Cauã Couto**
