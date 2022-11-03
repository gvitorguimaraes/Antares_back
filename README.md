# Antares

Antares é um sistema de faturamento que permite ao usuário registrar as vendas e imprimir uma folha de cobrança.

## Requisitos
 - Ser capaz de incluir, editar, visualizar e remover os produtos
 - Ser capaz de criar um documento de venda
 - Ser capaz de incluir produtos nos documentos de venda
 - Ser capaz de cadastrar, editar, visualizar e remover registros de clientes
 - Ser capaz de incluir um cliente em um documento de venda
 - Ser capaz de adicionar observações no documento de venda
 - Ser capaz de imprimir ou gerar um PDF do documento de venda 
 - Ser capaz de gerar um relatório de faturamento por período
 - O documento deve possuir data, número de identificação, valor total por produto, valor total do documento, quantidade e preços dos itens, endereço e forma de pagamento.


## Casos de Uso - Documento

### Gerar documento de venda

Cria um novo registro inserindo o cliente, os produtos e suas quantidades e o preço de cada produto.

Entrada esperada:
 - Id do cliente
 - Forma de pagamento
 - Id do produto
 - Quantidade
 - Preço
 - Observações (opcional)

Saída esperada:
 - Número documento
 - Valor total do documento
 - PDF do documento

### Editar documento de venda

Editar um registro já existente ( produto, preço e quantidade )

Entrada esperada:
 - Id do documento
 - Id do produto (opcional)
 - Quantidade (opcional)
 - Preço (opcional)
 - Observações (opcional)

Saida esperada:
 - Nova quantidade
 - Novo preço
 - Novo valor total  
 - Nova observação

### Consultar documento de venda

Consultar um documento informando o ID.

Entrada esperada:
 - ID do documento

Saída esperada:
 - Cliente
 - Produtos
 - Valor total
 - PDF do documento (Opcional)

### Excluir documento de venda

Pesquisa por um registro de venda e o excluí, desde que aquele registro ainda não tenha sido baixado como pago.

Entrada esperada:
 - Id do documento

Saída esperada:
 - Nenhuma

### Imprime relatório

Insere o período em que deseja que seja feita a consulta.

Entrada esperada:
 - Data inicial do período
 - Data final do período

Saída esperada:
 - Arquivo PDF contendo os documentos criados no período

## Casos de Uso - Cliente

### Cadastra um cliente

Faz um cadastro de um novo cliente inserindo o nome, endereço, contato e CPF/CNPJ.

Entrada esperada:
 - Nome
 - Endereço
 - Telefone / E-mail
 - CPF/CNPJ

Saída esperada:
 - Id do cliente
 - Nome
 - Endereço
 - Telefone / E-mail
 - CPF/CNPJ

### Consultar cliente

Consultar um cliente pelo ID

Entrada esperada:
 - ID cliente

Saída esperada:
 - ID cliente
 - Nome
 - Endereço
 - Telefone / E-mail
 - CPF/CNPJ

### Editar cliente

Editar o cadastro de um cliente informando o ID

Entrada esperada:
 - ID do cliente

 - Nome (Opcional)
 - Endereço (Opcional)
 - Telefone / E-mail (Opcional)

Saída esperada:
 - Novo nome
 - Novo Endereço
 - Novo Telefone ou E-mail

### Excluir cliente

Excluir um cliente pelo ID

Entrada esperada:
 - ID do cliente

Saída esperada:
 - Nenhuma

## Casos de uso - Produto

### Cadastrar produto

Faz o cadastro de um produto informando o nome e o código será gerado automaticamente.

Entrada esperada:
 - Nome do produto

Saída esperada:
 - ID do produto
 - Nome do produto

### Editar produto

Editar um produto informando o ID

Entrada esperada:
 - ID do produto
 - Nome do produto (Opcional)

Saída esperada:
 - Nome do produto

### Excluir um produto

Excluir um produto informando o ID

Entrada esperada:
 - ID do produto

Saída esperada:
 - Nenhuma



## Protótipo do projeto

https://www.figma.com/proto/PCGmkJ3CEJ2nt4yOmYXUVf/ANTARES?node-id=5%3A17&scaling=contain&page-id=0%3A1&starting-point-node-id=5%3A17

https://github.com/gvitorguimaraes/Antares_back
