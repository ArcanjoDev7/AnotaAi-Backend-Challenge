# Restaurant Marketplace
## AnotaAi Backend Challenge

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

Este projeto é uma API construída usando Java, Java Spring, AWS Simple Queue Service, Mongo DB e AWS Simple Storage Service.


## Índice

- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Pontos finais da API](#pontos finais da API)
- [Banco de dados](#banco de dados)
- [Contribuindo](#contribuindo)

## Uso

1. Inicie o aplicativo com Maven
2. A API estará acessível em http://localhost:8080

## Terminais de API
A API fornece os seguintes endpoints:

**PRODUTO API**
```redução
POST /api/product - Crie um novo produto
GET /api/product - Recupera todos os produtos
PUT /api/product/{id} - Atualiza um produto
DELETE /api/product/{id} - Excluir um produto
```

**CORPO**
```json
{
   "title": "Produto para postar no tópico",
   "descrição": "",
   "proprietárioId": "4444444",
   "categoryId": "659d558b0304df732ddd4587",
   "preço": 10000
}
```

**CATEGORIA DE API**
```redução
POST /api/category - Crie uma nova categoria
GET /api/category - Recupera todas as categorias
PUT /api/category/{id} - Atualiza uma categoria
DELETE /api/category/{id} - Excluir uma categoria
```

**CORPO**
```json
{
   "id": "393948882828",
   "título": "Teste",
   "descrição": "",
   "proprietárioId": "4444444"
}
```

## Contribuindo

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, abra um problema ou envie uma solicitação pull ao repositório.

Ao contribuir para este projeto, siga o estilo de código existente, [convenções de commit](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em um branch separado.



