## Introdução

Aplicação em Java Spring que consiste em uma API com a seguinte estrutura:

| Método | Rota | Descrição |
| -------|------|---------- |
| POST | /users | Cadastra um novo usuário. Recebe na request um json com os atributos name, username, password. Retornando um json do objeto UserModel |
| POST | /tasks | Cadastra uma nova tarefa. Recebe na request um header autorization basic do usuário proprietário da tarefa e um json com os atributos: title, description, priority, startAt e endAt. Retornando um json do objeto TaskModel.|
| GET | /tasks | Recupera todas as tarefas cadastradas. Não possui parâmetros de request.|
| PUT | /tasks/{id} | Altera uma tarefa. A requisição precisa passar um ou mais atributos de uma tarefa como json no body, a autenticação no header e o id da tarefa no path da URI.|


## Deploy

Para rodar o sistema em ambiente de container é necessário construir a imagem:

```
docker build -t to-do-list-with-spring-java:1.0.0 .

```

Executar um container

```
docker run -p 8080:8080 docker.io/marcelocamacho/to-do-list-with-spring-java:1.0.0 --name spring-java-api

``` 

## Testes

A API foi implantada no https://render.com/ no plano Free. Disponível por tempo limitado em https://to-do-list-fqvz.onrender.com/

### cria usuário Fulano
```
curl --request POST \
  --url https://to-do-list-fqvz.onrender.com/users/ \
  --header 'content-type: application/json' \
  --header 'user-agent: vscode-restclient' \
  --data '{"name": "Fulano de Tal","username": "fulaninho","password": "123456"}'
```

### usuário Fulano cria uma tarefa
```
curl --request POST \
  --url https://to-do-list-fqvz.onrender.com/tasks/ \
  --header 'authorization: Basic ZnVsYW5pbmhvOjEyMzQ1Ng==' \
  --header 'content-type: application/json' \
  --header 'user-agent: vscode-restclient' \
  --data '{"title": "Terminar a criação da API To-Do-List","description": "Programação em Java Spring","priority": "ALTA","startAt": "2024-08-27T08:00:00","endAt": "2024-08-28T23:59:59"}'
```

### recupera as tarefas de Fulano

```
curl --request GET \
  --url https://to-do-list-fqvz.onrender.com/tasks/ \
  --header 'authorization: Basic ZnVsYW5pbmhvOjEyMzQ1Ng==' \
  --header 'user-agent: vscode-restclient'
``` 
