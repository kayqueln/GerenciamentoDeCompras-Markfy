# Markfy

## Integrantes do Grupo:

### Representante/gestor do projeto:
- Bruno de Paula (RM552226)

### Líder Técnico:
- Kayque Lima (RM550782)

### Desenvolvedor Frontend/Mobile:
- Gabriel França (RM551905)

### Desenvolvedor/redator:
- Edward de Lima (RM98676)

## Como Rodar a Aplicação:

Para rodar a aplicação, siga os passos abaixo:

1. Clone o repositório do projeto para o seu ambiente local.
2. Certifique-se de ter o Java JDK e o Spring Boot instalados em sua máquina.
3. Abra o terminal e navegue até o diretório onde está o projeto.
4. Abra o projeto na sua IDE de preferencia.
5. Baixe as dependências do Maven utilizando o comando: `mvn clean install`.
6. Rode a classe `GerenciamentoDeComprasApplication`
5. Use o `-Dspring.profiles.active=dev` caso queira rodar em um ambiente de desenvolvimento com um banco de dados em memória (H2).
5. Acesse a aplicação em seu navegador ou client utilizando o endereço `http://localhost:8080/gerenciamento-de-compras/endpoint-desejado`.

## Diagramas da arquitetura do software:

### Diagrama de classes:
![Diagrama de classes.png](./documentos_do_projeto/Diagrama%20de%20classes.png)


### Diagrama de Entidade e Relacionamento:
![DER.png](./documentos_do_projeto/DER.png)

## Vídeo de Apresentação:

Acesse: [Clique aqui para assistir o vídeo de apresentação](https://www.youtube.com/watch?v=k0ObOt--m1k)

## Documentação da API:

Aqui estão listados todos os endpoints disponíveis na API de acordo com os domínios do software:

#### Login
1. POST `/login`: Realiza o login de um usuário já existente no sistema.
2. GET  `/login`: Lista todos os logins já feitos.
3. GET  `/login/{id}`: Retorna um login específico com base no ID fornecido.

### Usuário
4. POST `/usuario`: Cadastra um usuário no sistema.
5. GET  `/usuario`: Lista todos os usuários presentes na base de dados.
6. GET  `/usuario/{id}`: Retorna um usuário específico com base no ID fornecido.
7. PUT `/usuario/{id}`: Altera as informações de um usuário na base de dados
8. DELETE `/usuario/{id}`: Deleta um usuário da base de dado

### Endereço
9. GET `/endereco`: Lista todos os endereços presentes na base de dados.
10. GET  `/endereco/{id}`: Retorna um endereço específico com base no ID fornecido.
11. PUT `/endereco/{id}`: Altera as informações de um endereço na base de dados

### Item
12. POST `/item`: Cadastra um item no sistema.
13. GET  `/item`: Lista todos os items presentes na base de dados.
14. GET  `/item/{id}`: Retorna um item específico com base no ID fornecido.
15. PUT `/item/{id}`: Altera as informações de um item na base de dados
16. DELETE `/item/{id}`: Deleta um item da base de dado

### Compra
17. POST `/compra`: Cadastra uma compra no sistema.
18. POST `/compra/{id}`: Confirma que a compra foi realizada com êxito.
19. GET  `/compra`: Lista todos os compras presentes na base de dados.
20. GET  `/compra/{id}`: Retorna uma compra específico com base no ID fornecido.
21. DELETE `/compra/{id}`: Deleta uma compra da base de dados


## Atenção
Para mais detalhes sobre cada endpoint acesse a collection do Insomnia com todas as requisiçoes existentes. Siga os passos abaixo para executá-las.
1. Na raiz desse repositório entre na pasta `documentos_do_projeto`.
2. Faça o download do arquivo: `Insominia_Collection_Markfy.json`.
1. Certifique-se de ter o software Insomnia instalado na sua máquina.
3. No Insomnia clique no botão `create` ou no ícone de mais `+`.
4. Depois clique na opção `importar`.
5. Selecione o JSON (Insominia_Collection_Markfy.json) baixado e importe a collection.
6. Faça as chamadas aos endpoints listados acima respeitando a ordem das requisições




## Próximos passos 
- Bean validation
- reorganizar a documentação
- Autenticação com JWT
- Perfil de comprador e vendedor
- Autenticação com google e github
- integração com frontend
