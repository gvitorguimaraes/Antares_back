# Antares_back
Repositório da API da aplicação Antares desenvolvido em Java com Springboot

# Antares

Antares é um sistema de faturamento que permite ao usuário registrar as vendas e imprimir uma folha de cobrança.

## Requisitos
 - Ser capaz de incluir, editar, visualizar e remover os produtos
 - Ser capaz de criar um registro de venda
 - Ser capaz de incluir produtos nos registros de venda
 - Ser capaz de cadastrar, editar, visualizar e remover registros de clientes
 - Ser capaz de incluir um cliente em um registro de venda
 - Ser capaz de adicionar observações no registro de venda
 - Ser capaz de imprimir ou gerar um PDF do registro de venda
 - Ser capaz de gerar um relatório de faturamento por período
 - O registro deve possuir data, número de Identificação, valor total por produto, valor total do documento, quantidade e preços dos itens, endereço e forma de pagamento.

## Casos de Uso

### Gerar registro de venda

Cria um novo registro inserindo o cliente, os produtos e suas quantidades e o preço de cada produto.

### Excluir registro de venda

Pesquisa por um registro de venda e o excluí, desde que aquele registro ainda não tenha sido baixado como pago.

### Imprime relatório

Insere o período em que deseja que seja feita a consulta.

### Cadastra um cliente

Faz um cadastro de um novo cliente inserindo o nome, endereço, contato e CPF/CNPJ.

### Cadastrar um produto

Faz o cadastro de um produto informando o nome e o código será gerado automaticamente.
