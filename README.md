# 🚀 Gerenciador de Tarefas em Java

> Sistema de gerenciamento de tarefas com CRUD completo, desenvolvido em Java utilizando Programação Orientada a Objetos e persistência em arquivo.

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de aplicar conceitos fundamentais de desenvolvimento backend, como:

* Programação Orientada a Objetos (POO)
* Manipulação de arquivos
* Estruturação em camadas (Model, Service, UI)
* Operações CRUD

A aplicação roda no terminal (CLI) e permite o gerenciamento completo de tarefas com persistência local.

---

## ✨ Funcionalidades

* ✅ Criar tarefas com título, descrição e status
* 📋 Listar todas as tarefas
* 🔍 Filtrar tarefas por status
* ✏️ Atualizar tarefas existentes
* ❌ Remover tarefas por ID
* 💾 Salvamento automático em arquivo CSV
* 📂 Carregamento automático ao iniciar o sistema

---

## 🧠 Conceitos aplicados

* Encapsulamento
* Separação de responsabilidades
* Coleções (`ArrayList`)
* Streams API (filtros)
* Tratamento de exceções
* Persistência em arquivos

---

## 🏗️ Arquitetura do Projeto

```id="arch01"
src/
 ├── Main.java                # Interface com o usuário (CLI)
 ├── GerenciadorTarefas.java # Regras de negócio (CRUD)
 └── Tarefa.java             # Modelo de dados
```

---

## 🛠️ Tecnologias

* Java (JDK 8+)
* API de Collections
* IO (BufferedReader / BufferedWriter)

---

## ▶️ Como executar

### 🔧 Compilar

```bash id="run01"
javac src/*.java
```

### ▶️ Executar

```bash id="run02"
java -cp src Main
```

---

## 💾 Persistência de Dados

Os dados são armazenados em:

```id="data01"
tarefas.csv
```

* Salvamento automático a cada operação
* Carregamento automático na inicialização

---

## 📸 Demonstração

> 💡 (Adicione aqui um print do terminal rodando o sistema)

Exemplo:

```id="demo01"
--- MENU PRINCIPAL ---
1. Adicionar nova tarefa
2. Listar tarefas
3. Filtrar por status
4. Atualizar tarefa
5. Remover tarefa
0. Sair
```

---

## 📈 Possíveis melhorias

* 🔄 Migração de CSV para JSON
* 🧩 Uso de `enum` para status
* 🎨 Interface gráfica com JavaFX
* 🌐 API REST com Spring Boot
* 🗄️ Integração com banco de dados

---

## 🎯 Objetivo do Projeto

Este projeto faz parte da evolução prática em Java, com foco em consolidar fundamentos essenciais para desenvolvimento backend.

---

## 👨‍💻 Autor

**João Victor Souza**

---

## 📄 Licença

Este projeto é destinado para fins educacionais e pode ser utilizado livremente.
