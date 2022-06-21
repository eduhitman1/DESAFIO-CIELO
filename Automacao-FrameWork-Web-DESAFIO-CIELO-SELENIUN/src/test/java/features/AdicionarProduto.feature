#language: pt
@Login_adicionar_carrinho
Funcionalidade: Adicionar Produto

 Cenario: Realizar login e adicionar produto carrinho

  Dado que estou com a aplicacao aberta
  Quando eu clico no link do login 
  Entao eu insiro o userName e Password
  E clico no botao logar 
  E selecionou a categoria do produto
  E tipo selecinou o tipo de vestido
  E clico no modelo do produto
  Então clico em adicionar produto
  E clico em progresso de pagamento 
  Então valido a página de pagamento