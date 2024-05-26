# Entrega Tech Challenge – Fase 1

----------------------------------------------------------------------------

### Grupo: 36
### Integrantes: 
#### Suleiman Diverio Sallum – RM355044 - suleimandiverio@gmail.com
#### Rodrigo Franco – RM355046 - rodrigofrancodelima@gmail.com

----------------------------------------------------------------------------

### O que é este projeto?
#### Trata-se de um sistema que vai automatizar o controle de pedidos de uma lanchonete, visando atender os clientes de maneira eficiente e gerenciando seus pedidos de forma adequada.

----------------------------------------------------------------------------

### Objetivos
#### Nesta versão, o sistema possui:
1. CRUD de Clientes (possui uma busca por CPF);
2. CRUD de Produtos (possui uma busca por Categoria);
3. Cadastro de Pedidos (tem todas operações de um CRUD e uma listagem por Status);
4. Operação para avançar o status/estágio de um determinado Pedido;
5. Realização de pagamento (Fakecheckout) de um determinado Pedido.

----------------------------------------------------------------------------

### Como executar estre programa?
#### Basta seguir os seguintes passos:

1. Execute o seguinte comando para clonar este repositório em sua máquina:
```
git clone https://github.com/RodrigoFranco91/fastfood.git 
```

2. Entre no diretório raiz do projeto (certifique-se que está no diretório que contem o arquivo docker-compose). 
Execute o comando:
```
docker-compose up
```

3. Agora já é possível executar todas operações deste programa.
Veja e execute todas as operações acessando o Swagger em:
```
http://localhost:8080/api/swagger-ui/index.html
```

4. Na próxima seção, haverá uma explicação e exemplos das requisições.

----------------------------------------------------------------------------

## Operações implementadas para Cliente:

###
### Cadastro de Cliente

Host: localhost:8080/api/cliente

Method: POST

+ Body

```
{
  "cpf": "41383701024",
  "nome": "Rodrigo Franco",
  "email": "rodrigo@gmail.com",
  "senha": "789abc159qsc"
}
```

+ Response

HTTP Status: 201 - Created
```
{
    "id": "835822ab-31bc-45e8-8be3-66aa5b8e00fc",
    "cpf": "41383701024",
    "nome": "Rodrigo Franco",
    "email": "rodrigo@gmail.com"
}
```
###
### Atualização de Cliente

Host: localhost:8080/api/cliente

Method: PUT

Obs: tem que informar no body o CPF do cliente que desejas atualizar.

+ Body

```
{
  "cpf": "41383701024",
  "nome": "Rodrigo Franco de Lima",
  "email": "rodrigofranco@gmail.com",
  "senha": "789abc159qsc"
}
```

+ Response

HTTP Status: 200 - Ok
```
{
    "id": "835822ab-31bc-45e8-8be3-66aa5b8e00fc",
    "cpf": "41383701024",
    "nome": "Rodrigo Franco de Lima",
    "email": "rodrigofranco@gmail.com"
}
```
###
### Busca por CPF

Host: localhost:8080/api/cliente/41383701024

Obs: tem que informar no path o CPF do cliente que desejas visualizar.

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
{
    "id": "835822ab-31bc-45e8-8be3-66aa5b8e00fc",
    "cpf": "41383701024",
    "nome": "Rodrigo Franco de Lima",
    "email": "rodrigofranco@gmail.com"
}
```

###
### Listagem de Todos Clientes

Host: localhost:8080/api/cliente

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
[
    {
        "id": "835822ab-31bc-45e8-8be3-66aa5b8e00fc",
        "cpf": "41383701024",
        "nome": "Rodrigo Franco de Lima",
        "email": "rodrigofranco@gmail.com"
    }
]
```

###
### Exclusão de Cliente

Host: localhost:8080/api/cliente/41383701024

Obs: tem que informar no path o CPF do cliente que desejas excluir.

Method: DELETE

+ Body

```
```

+ Response

HTTP Status: 204 - No Content
```
```

----------------------------------------------------------------------------

## Operações implementadas para Produto:

###
### Cadastro de Produto

Host: localhost:8080/api/produto

Method: POST

Obs: categoria pode ser = LANCHE, ACOMPANHAMENTO, BEBIDA, SOBREMESA.

+ Body

```
{
    "nome": "X Tudo",
    "categoria": "LANCHE",
    "preco": 50.0,
    "descricao": "Contem Tudo",
    "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181"
}
```

+ Response

HTTP Status: 201 - Created
```
{
    "id": "a0d8dc49-a59f-4561-8191-4684ef60bae0",
    "nome": "X Tudo",
    "categoria": "LANCHE",
    "preco": 50.0,
    "descricao": "Contem Tudo",
    "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181"
}
```
###
### Atualização de Produto

Host: localhost:8080/api/produto/88f6e5bf-153a-4a80-8f42-0fbd1193eecf

Obs: tem que informar no path o ID do produto que desejas atualizar.

Method: PUT

+ Body

```
{
    "nome": "X Tudo atualizado",
    "categoria": "LANCHE",
    "preco": 60,
    "descricao": "Contem tudo que é possivel e mais um pouco",
    "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181atualizado"
}
```

+ Response

HTTP Status: 200 - Ok
```
{
    "id": "a0d8dc49-a59f-4561-8191-4684ef60bae0",
    "nome": "X Tudo atualizado",
    "categoria": "LANCHE",
    "preco": 60,
    "descricao": "Contem tudo que é possivel e mais um pouco",
    "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181atualizado"
}
```
###
### Busca de produto por ID

Host: localhost:8080/api/produto/88f6e5bf-153a-4a80-8f42-0fbd1193eecf

Obs: tem que informar no path o ID do produto que desejas visualizar.


Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
{
    "id": "a0d8dc49-a59f-4561-8191-4684ef60bae0",
    "nome": "X Tudo atualizado",
    "categoria": "LANCHE",
    "preco": 60.00,
    "descricao": "Contem tudo que é possivel e mais um pouco",
    "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181atualizado"
}
```

###
### Listagem de Todos Produtos

Host: localhost:8080/api/produto

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
[
    {
        "id": "a0d8dc49-a59f-4561-8191-4684ef60bae0",
        "nome": "X Tudo atualizado",
        "categoria": "LANCHE",
        "preco": 60.00,
        "descricao": "Contem tudo que é possivel e mais um pouco",
        "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181atualizado"
    }
]
```

###
### Exclusão de Produto

Host: localhost:8080/api/produto/a0d8dc49-a59f-4561-8191-4684ef60bae0

Obs: tem que informar no path o ID do produto que desejas excluir.

Method: DELETE

+ Body

```
```

+ Response

HTTP Status: 204 - No Content
```
```

###
### Busca de produtos por categoria

Host: localhost:8080/api/produto/categoria?nome=lanche

Obs: tem que passar um Query Param (nome), cujo valor é a categoria desejada (LANCHE, ACOMPANHAMENTO, BEBIDA, SOBREMESA).

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
[
    {
        "id": "a0d8dc49-a59f-4561-8191-4684ef60bae0",
        "nome": "X Tudo atualizado",
        "categoria": "LANCHE",
        "preco": 60.00,
        "descricao": "Contem tudo que é possivel e mais um pouco",
        "imagem": "sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181sdfvsdfgvdsdfg4518918181atualizado"
    }
]
```

----------------------------------------------------------------------------

## Operações implementadas para Pedido:

###
### Cadastro de Pedido

Host: localhost:8080/api/pedido

Method: POST

Obs: tem que passar no body o CPF de um cliente existente e o ID de um Produto existente!

+ Body

```
{
    "cpfCliente": "41383701024",
    "itens": [
        {
            "produtoId": "a0d8dc49-a59f-4561-8191-4684ef60bae0",
            "quantidade": 1
        }
    ]
}
```

+ Response

HTTP Status: 201 - Created
```
{
    "id": "d6d8fd11-04a1-4efb-95c8-b19ffb837c4a",
    "total": 50.00,
    "data": "2024-05-26T12:41:35.346303508-03:00",
    "statusPedido": "AGUARDANDO_PAGAMENTO",
    "cliente": {
        "id": "0ceb90bd-231c-46ee-b8d2-e08e5f14b1a3",
        "cpf": "41383701024",
        "nome": "Rodrigo Franco",
        "email": "rodrigo@gmail.com"
    },
    "itens": [
        {
            "produto": "X Tudo",
            "quantidadeDoItem": 1,
            "precoAtualDoIem": 50.00
        }
    ]
}
```

###
### Busca de Pedido por ID

Host: localhost:8080/api/pedido/d6d8fd11-04a1-4efb-95c8-b19ffb837c4a

Obs: tem que informar no path o ID do pedido que desejas visualizar.

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
{
    "id": "d6d8fd11-04a1-4efb-95c8-b19ffb837c4a",
    "total": 50.00,
    "data": "2024-05-26T15:41:35.346304Z",
    "statusPedido": "AGUARDANDO_PAGAMENTO",
    "cliente": {
        "id": "0ceb90bd-231c-46ee-b8d2-e08e5f14b1a3",
        "cpf": "41383701024",
        "nome": "Rodrigo Franco",
        "email": "rodrigo@gmail.com"
    },
    "itens": [
        {
            "produto": "X Tudo",
            "quantidadeDoItem": 1,
            "precoAtualDoIem": 50.00
        }
    ]
}
```

###
### Listagem de Todos Pedidos

Host: localhost:8080/api/pedido

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
[
    {
        "id": "d6d8fd11-04a1-4efb-95c8-b19ffb837c4a",
        "total": 50.00,
        "data": "2024-05-26T15:41:35.346304Z",
        "statusPedido": "AGUARDANDO_PAGAMENTO",
        "cliente": {
            "id": "0ceb90bd-231c-46ee-b8d2-e08e5f14b1a3",
            "cpf": "41383701024",
            "nome": "Rodrigo Franco",
            "email": "rodrigo@gmail.com"
        },
        "itens": [
            {
                "produto": "X Tudo",
                "quantidadeDoItem": 1,
                "precoAtualDoIem": 50.00
            }
        ]
    }
]
```

###
### Exclusão de Pedido

Host: localhost:8080/api/pedido/d6d8fd11-04a1-4efb-95c8-b19ffb837c4a

Obs: tem que informar no path o ID do pedido que desejas excluir.

Method: DELETE

+ Body

```
```

+ Response

HTTP Status: 204 - No Content
```
```

###
### Busca de Pedidos por Status/Estágio

Host: localhost:8080/api/pedido/status/aguardando_pagamento

Obs: tem que informar no path o valor do status/estágio desejado. Esse valor pode ser: AGUARDANDO_PAGAMENTO, RECEBIDO, EM_PREPARACAO, PRONTO, FINALIZADO.

Method: GET

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
[
    {
        "id": "d6d8fd11-04a1-4efb-95c8-b19ffb837c4a",
        "total": 50.00,
        "data": "2024-05-26T15:41:35.346304Z",
        "statusPedido": "AGUARDANDO_PAGAMENTO",
        "cliente": {
            "id": "0ceb90bd-231c-46ee-b8d2-e08e5f14b1a3",
            "cpf": "41383701024",
            "nome": "Rodrigo Franco",
            "email": "rodrigo@gmail.com"
        },
        "itens": [
            {
                "produto": "X Tudo",
                "quantidadeDoItem": 1,
                "precoAtualDoIem": 50.00
            }
        ]
    }
]
```

###
### Avança Status/Estágio de um Pedido

Host: localhost:8080/api/pedido/status/d6d8fd11-04a1-4efb-95c8-b19ffb837c4a

Obs: tem que informar no path o ID de um Pedido existente e que seu STATUS/ESTÁGIO esteja em: RECEBIDO, EM_PREPARACAO, PRONTO. 
Se o pedido informado estiver no status FINALIZADO ou AGUARDANDO_PAGAMENTO você receberá um 400 BAD REQUEST.

Para passar um Pedido novo (AGUARDANDO_PAGAMENTO) para o status de RECEBIDO, basta rodar a operação de Efetuar Pagamento, que vamos exemplificar
a seguir.

###
Method: PATCH

+ Body

```
```

+ Response

HTTP Status: 200 - Ok
```
{
    "id": "d6d8fd11-04a1-4efb-95c8-b19ffb837c4a",
    "total": 50.00,
    "data": "2024-05-26T15:41:35.346304Z",
    "statusPedido": "EM_PREPARACAO",
    "cliente": {
        "id": "0ceb90bd-231c-46ee-b8d2-e08e5f14b1a3",
        "cpf": "41383701024",
        "nome": "Rodrigo Franco",
        "email": "rodrigo@gmail.com"
    },
    "itens": [
        {
            "produto": "X Tudo",
            "quantidadeDoItem": 1,
            "precoAtualDoIem": 50.00
        }
    ]
}
```

----------------------------------------------------------------------------

## Operação implementada para Pagamento:

###
### Efetivação de Pagamento

Host: localhost:8080/api/pagamento/d6d8fd11-04a1-4efb-95c8-b19ffb837c4a

Method: POST

Obs: tem que informar no path o ID do pedido que desejas efetuar o pagamento. O pedido informado deve ter o status em: AGUARDANDO_PAGAMENTO

+ Body

```
```

+ Response

HTTP Status: 201 - Created
```
{
    "id": "a4a56a1d-86a4-435a-842b-cc4654d77daf",
    "dataHora": "2024-05-26T12:58:05.271963086-03:00",
    "pago": true,
    "valorCobrado": 50.00,
    "pedido": {
        "id": "d6d8fd11-04a1-4efb-95c8-b19ffb837c4a",
        "total": 50.00,
        "data": "2024-05-26T15:41:35.346304Z",
        "statusPedido": "RECEBIDO",
        "cliente": {
            "id": "0ceb90bd-231c-46ee-b8d2-e08e5f14b1a3",
            "cpf": "41383701024",
            "nome": "Rodrigo Franco",
            "email": "rodrigo@gmail.com"
        },
        "itens": [
            {
                "produto": "X Tudo",
                "quantidadeDoItem": 1,
                "precoAtualDoIem": 50.00
            }
        ]
    }
}
```

----------------------------------------------------------------------------