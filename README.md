# Gerador de link de pagamento

## **Requirements**
* Java 17
* Spring boot 3
* IDE de sua preferência

## **How to run**

*A aplicação roda na porta 8080

*Para rodar a aplicação local, via terminal, execute o comando: `./gradlew bootRun`

## **About**
A aplicação possui 2 endpoints:
* /payment
* /payment/redirect

**/payment** retorna o link de pagamento na response.

**/payment/redirect** redireciona automaticamente para o link de pagamento.

**Parâmetros disponíveis e como utilizar:**
* **totalAmount** O valor se refere a soma do pedido sem levar em consideração as taxas e descontos;
* **value** O valor do pedido de quem deseja obter o link de pagamento(nesse exemplo, seria o amigo);
* **increase** Valor total das taxas em R$ que deve ser acrescido no valor do pedido;
* **discount** Valor total dos descontos em R$ que devem ser aplicados no valor do pedido;
* **increasePercent** taxa percentual que deve ser acrescida no pedido.
* **discountPercent** percentual de desconto que deve ser aplicado no valor do pedido.

**Os Inputs são iguais para ambos os endpoints e devem ser feitos através de query param.**

**Exemplo:**
`http://localhost:8080/payment?totalAmount=50.00&value=8.00&increase=8.00&discount=20.00`


**OBS**: usar o formato igual no exemplo acima, utilizando 2 casas decimais, e utilizando o `.` como separador de casas decimais.
