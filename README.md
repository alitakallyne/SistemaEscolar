## Projeto da API Escolar
Este projeto consiste em desenvolver uma API de um sistema escolar utilizando Java e Spring. O objetivo principal é capacitar os desenvolvedores a construir uma API simples que responda com os códigos de status HTTP corretos para as requisições feitas pelo lado do usuário. É essencial comunicar o resultado das requisições, como sucesso, erro do cliente, erro do servidor, entre outros, garantindo uma experiência de usuário consistente e confiável.

## Tecnologias Utilizadas 🛠
- **Eclipse IDE**
- **Insomnia**
- **Linguagem Java**
- **Spring Framework**
- **MySQL**
- **Trello**

## Entidades 📝
- **Colaborador** : A entidade "Colaborador" possui os seguintes atributos:
- Nome
- Email
- CPF
- Cargo (ENUM)
- Endereço
- **Aluno** : A entidade "Aluno" possui os seguintes atributos:
- Nome
- Email
- CPF
- Curso (ENUM)
- Telefone
- Endereço

## Funcionalidades 🚀 
- Ambas as entidades "Colaborador" e "Aluno" terão as seguintes funcionalidades:
- CRUD (Create, Read, Update, Delete): Implementação das operações básicas de criação, leitura, atualização e exclusão para
 manipulação dos registros de colaboradores e alunos no sistema. Essas funcionalidades permitirão gerenciar eficientemente os
 dados dessas entidades, garantindo uma interação completa com a API.

## Estrutura do Projeto 🏗️
O projeto está estruturado em pacotes conforme as responsabilidades:

- com.api.ToLifeApi.Controller: Contém os controladores responsáveis por receber e processar as requisições HTTP.
- com.api.ToLifeApi.Service: Contém os serviços responsáveis pela lógica de negócio da aplicação.
- com.api.ToLifeApi.DTO: Contém os objetos de transferência de dados utilizados para representar os dados recebidos e enviados pela API.
- com.api.ToLifeApi.Repositories: Contém as interfaces de repositório utilizadas para acessar o banco de dados.
  
## Como Contribuir 🤝
- Faça um fork do repositório.
- Crie uma branch para sua feature (git checkout -b feature/MinhaFeature).
- Faça commit das suas mudanças (git commit -am 'Adicionando uma nova feature').
- Faça push para a branch (git push origin feature/MinhaFeature).
- Abra um Pull Request.

## Executando Localmente 🏃
Para executar o projeto localmente, siga estas etapas:

- Clone o repositório (git clone https://github.com/alitakallyne/SistemaEscolar-T3.git).
- Importe o projeto em sua IDE preferida.
- Execute a aplicação.
- Acesse os endpoints através do navegador ou de uma ferramenta de teste de API, como o Insomnia.

## Observações Importantes ℹ️
- Certifique-se de configurar corretamente as propriedades de conexão no arquivo application.properties.

## Autor

**[Alita Kallyne Do Nascimento](https://github.com/alitakallyne)**
