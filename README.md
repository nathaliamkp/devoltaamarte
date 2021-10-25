# O projeto:
Esse projeto se refere  ao desenvolvimento do seguinte desafio:
A NASA está levando alguns equipamentos exploradores para o planeta vermelho. A área a ser explorada curiosamente é um planalto de superfície muito plana.
Antes de lançar os equipamentos em solo marciano, é preciso definir qual equipamento ele será, se irá se movimentar, se suas trajetórias e posições iniciais foram definidas corretamente.
Para tanto, será preciso que desenvolva um software capaz de fazer tais verificações e também que retorne a posição final de cada equipamento.

## Premissas:

Aqui foi assumido que é possível existir um equipamento explorador diferente da sonda e que uma caracteristica de todas as sondas é que elas só podem se movimentar 10 vezes.
No momento dessa missão exploratória não há outro tipo de equipameto disponível a não ser a sonda, portanto, se a trajetória informada para algum equipamento não for compatível com a de uma sonda, não será possível realizar a exploração. 
No momento dessa exploração apenas equipamentos moveis serão lançados.
Essa exploração só contará também com equipamentos exploradores, não existindo, por enquanto, a possibilidade de enviar um equipamento que não seja desse tipo. 
Foi assumido aqui que as sondas serão lançadas uma de cada vez. Após cumprir sua trajetória, ela fica inativa. Caso aconteça de uma sonda colidir com alguma sonda inativada, a sonda para, seu status fica inativo e ela não será capaz de cumprir o restante da sua trajetória.
