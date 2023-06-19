API-e-commerce
Esse algoritmo implementa um sistema de gerenciamento de produtos, carrinho de compras e confirmação de vendas. Ele utiliza um banco de dados em MySQL para armazenar os dados dos produtos.

A classe "Produto" representa um produto com atributos como ID, nome, preço e quantidade. Através de métodos como "salvarProduto", "removerProduto" e "atualizarProduto", é possível adicionar, remover e atualizar produtos no banco de dados.

A classe "Carrinhocompra" gerencia o carrinho de compras, com uma lista de objetos "Item" que representam os produtos selecionados e suas quantidades. Os métodos como "adcionarItem", "removerDoCarrinho", "totalCompra","confirmar" e "atualizarEstoque"  permitem adicionar produtos ao carrinho, removê-los , calcular o valor total do carrinho, confirmar os itens do carrinho e atualizar o banco de dados do produto após a confirmação.

Esse algoritmo fornece uma estrutura básica para gerenciar produtos, carrinho de compras e confirmação de vendas, utilizando um banco de dados para armazenar os dados dos produtos e garantir a atualização adequada do estoque.

Utilização:

Para a Utilização do código é necessario exporta a biblioteca mysql-connector-j-8.0.33 para a plataforma eclipse, o arquivo esta localizado na pasta resources dentro do repositorio, tambem é necessario fazer as mudanças no url, usuario e senha para o banco de dados local, o arquivo sql tambem esta localizado na pasta resources. dar "Run" na classe EcommerceMenu.java. dentro do pacote ecommerce.aplicacao.
