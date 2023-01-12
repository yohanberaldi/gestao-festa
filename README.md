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

![tela_adicionado_sucesso](https://user-images.githubusercontent.com/107574302/212150099-850170b1-06a1-4d49-a6c2-1af0fcfcf9e5.png)

<p>Convidado deletado com sucesso</p>

![tela_delete_sucesso](https://user-images.githubusercontent.com/107574302/212150510-87fc37b5-389b-4de7-b9ed-db050b0e4f09.png)

<p>Convidado atualizado com sucesso</p>

![tela_update_presente_dropbox](https://user-images.githubusercontent.com/107574302/212150676-67b6a1d9-3ecb-45f8-9dcf-f9eafcf25f4c.png)

![tela_update_sucesso](https://user-images.githubusercontent.com/107574302/212150791-cd15e874-5524-4fe3-8182-d7b0c61cd353.png)

<p>Regras de negócio</p>

![tela_erro_qtde_acompanhantes](https://user-images.githubusercontent.com/107574302/212151352-23bc547b-ef07-4292-808e-e707ab9af133.png)

![tela_erro_idade](https://user-images.githubusercontent.com/107574302/212151298-232c74a2-29a4-41a7-81c8-4ef893b0e60a.png)

![tela_erro_presente_cadastrado](https://user-images.githubusercontent.com/107574302/212151439-d3f47762-9d89-44ca-b45f-0c29797939e4.png)

![tela_erro_nome](https://user-images.githubusercontent.com/107574302/212151496-2cca14a2-d413-4d93-9b79-529403fc9206.png)

