# gestao-festa
Projeto em Spring com versão web e API RESTful

Este projeto contém uma aplicação que utiliza Spring Boot, Spring MVC, Spring Data JPA, Thymeleaf e API RESTful usando o Spring Tool Suite (STS), uma IDE baseada no Eclipse.

Consiste em um sistema de controle do tipo CRUD de uma lista de convidados, onde é possível adicionar convidados, deletar convidados, editar dados do convidado e adicionar um presente para cada convidado. Possui regras de negócios pensando em possíveis histórias dos usuários, atendendo diversos tipos de demandas. Abaixo seguem alguns exemplos.
"Eu como (ator - dono da festa) preciso controlar o acesso ao evento para não exceder a capacidade de lotação do local onde a festa será realizada." - Foi implementada uma regra de negócio que estabelece uma quantidade máxima de 3 acompanhantes para cada convidado.
"Eu como (ator - dono da festa) desejo saber qual presente cada convidado trouxe para poder agradecer após a festa" - Foi implementada a possibilidade de um registro pré e pós festa para o cadastro dos presentes.
"Eu como (ator - dono da festa) desejo saber se o convidado tem mais de 18 anos, pois, serão servidas bebidas alcólicas na festa." Foi implementada uma regra de negócio que verifica a data de nascimento, comparando com a data atual, só aceitando a inserção do registro caso o convidado tenha mais de 18 anos.
"Eu como (ator - dono da festa) desejo que não haja registros de nomes iguais, para evitar problemas na lista de acesso à festa." Foi implementada uma regra de negócio que verifica se o nome do convidado já não consta no registro de convidados.

A seguir é possível ver algumas telas do sistema para entender seu funcionamento.


<p>Tela Principal</p>

![tela_principal_crud](https://user-images.githubusercontent.com/107574302/212144103-ee834ef0-71df-410c-8ca0-def38051fc00.png)

<p>Adicionando um convidado</p>

![tela_adicionando_convidado_2](https://user-images.githubusercontent.com/107574302/212149630-17040f45-e29d-49a9-9e91-cf239c09798d.png)
