# Sistema de Gestão em Java Swing 💻

Este é um **sistema de gestão completo** e intuitivo, desenvolvido em **Java** com interface gráfica utilizando **Swing**. Ele oferece uma solução robusta para o gerenciamento de diversas entidades, como produtos, clientes, categorias, pedidos e itens de pedidos, tudo através de uma interface amigável e estilizada. ✨

---

## ✨ Funcionalidades Principais

* **Menu Principal Interativo:** Um menu principal bem organizado com opções categorizadas em "Arquivo" 📁, "Cadastrar" ➕ e "Ajuda" ❓, proporcionando fácil navegação e acesso às funcionalidades do sistema.
* **Formulários de Cadastro Dedicados:** Telas específicas e otimizadas para o cadastro e gerenciamento de:
    * Clientes 👤
    * Produtos 📦
    * Categorias 🏷️
    * Pedidos 📝
    * Itens de Pedidos 🛒
* **Design Personalizado:** A interface gráfica foi cuidadosamente estilizada com cores e layouts personalizados, visando uma experiência do usuário agradável e eficiente. 🎨
* **Ação de Sair:** Opção direta no menu para encerrar o sistema de forma segura. 🚪
* **Tela "Sobre":** Uma seção dedicada com informações sobre os desenvolvedores do projeto. 👩🏻‍💻

---

## 💚 Estrutura do Projeto

O projeto foi concebido com uma **arquitetura modular**, onde cada funcionalidade é implementada em classes separadas, como `FormularioCliente`, `FormularioProduto`, `ClienteDao`, `ProdutoDao`, entre outras. Isso garante maior organização, facilidade de manutenção e escalabilidade do código, seguindo princípios como:

* **View (Visão):** Pacote `View/` (Ex: `Menu.java`, `FormularioCliente.java`) - Responsável pela interface do usuário.
* **Model (Modelo):** Pacote `Model/` (Ex: `Cliente.java`, `Produto.java`) - Representa os dados e a lógica de negócios.
* **DAO (Data Access Object):** Pacote `DAO/` (Ex: `ClienteDao.java`, `ConnectionFactory.java`) - Responsável pela comunicação com o banco de dados.

---

## 🚀 Tecnologias Utilizadas

* **Java (JDK 8 ou superior)**
* **Java Swing** (para a interface gráfica)
* **JDBC** (Java Database Connectivity para interação com o banco de dados)
* **MySQL** (ou outro banco de dados compatível, com o driver JDBC apropriado)

---

## 🛠️ Como Executar o Projeto (Sugestão)

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SeuUsuario/NomeDoSeuRepositorio.git](https://github.com/SeuUsuario/NomeDoSeuRepositorio.git)
    cd NomeDoSeuRepositorio
    ```
2.  **Configurar o Banco de Dados:**
    * Importe o arquivo `menuinterfacegrafica.sql` (ou o nome do seu script SQL) para o seu servidor MySQL (ex: usando phpMyAdmin, MySQL Workbench ou linha de comando).
    * Certifique-se de que as credenciais do banco de dados em `DAO/ConnectionFactory.java` estejam corretas para sua configuração local.
3.  **Compilar e Executar:**
    * Abra o projeto em sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code).
    * Certifique-se de que as bibliotecas JDBC para MySQL estejam adicionadas ao classpath do projeto.
    * Execute a classe `Menu.java` (que contém o método `main`).

---

## 🤝 Contribuições (Sugestão)

Contribuições são bem-vindas! Se você quiser melhorar este projeto:

1.  Faça um fork do projeto.
2.  Crie uma nova branch (`git checkout -b feature/minha-feature`).
3.  Faça suas alterações e commit-as (`git commit -m 'Adiciona nova funcionalidade'`).
4.  Envie para a branch original (`git push origin feature/minha-feature`).
5.  Abra um Pull Request.

---


## 👩🏻‍💻 Desenvolvedora:

* Esther Nascimento 


---
