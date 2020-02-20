# teste sicredi
Realizei a automação com Junit e RestAssured porque acho simples.

Teste de API só validei o schema pois não encontrei as rotas para realizar os testes.

Teste Web fiz os cts:

* Como cliente
Quando tento realizar a simulação inferior a R$20 somente com o valor de aplicação inicial
Então me retorna a informação que só é possivel simular acima de R$20
E que campo meses é obrigatório

* Como cliente
Quando tento realizar a simulação inferior a R$20 somente com o valor de investimento
Então me retorna a informação que só é possivel simular acima de R$20
E que campo meses é obrigatório

* Como cliente
Quando tento realizar a simulação inferior a R$20 somente com o valor de investimento
E com o campo meses preenchido
Então me retorna a informação que só é possivel simular acima de R$20

* Como cliente
Quando tento realizar a simulação inferior a R$20 somente com o valor de aplicação inicial
E com o campo meses preenchido
Então me retorna a informação que só é possivel simular acima de R$20

* Como cliente
Quando tento realizar a simulação somente com o campo meses preenchido
Então me retorna a informação que só é possivel simular acima de R$20

* Como cliente
Quando preencho os campos de aplicação inicial e investimento acima de R$20
Então me retorna uma tabela com o valor da simulação e mais 4 estimativas com intervalo de 12 anos.
