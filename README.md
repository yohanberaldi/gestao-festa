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

![tela_adicionando_convidado_1](https://user-images.githubusercontent.com/107574302/212153320-66814432-d76c-4ece-bc90-bcee2564065f.png)

![tela_adicionado_sucesso](https://user-images.githubusercontent.com/107574302/212150099-850170b1-06a1-4d49-a6c2-1af0fcfcf9e5.png)

<p>Deletando um convidado</p>

![tela_delete_sucesso](https://user-images.githubusercontent.com/107574302/212150510-87fc37b5-389b-4de7-b9ed-db050b0e4f09.png)

<p>Atualizando um convidado</p>

![tela_update_presente_dropbox](https://user-images.githubusercontent.com/107574302/212150676-67b6a1d9-3ecb-45f8-9dcf-f9eafcf25f4c.png)

![tela_update_sucesso](https://user-images.githubusercontent.com/107574302/212150791-cd15e874-5524-4fe3-8182-d7b0c61cd353.png)

<p>Regras de negócio</p>

![tela_erro_qtde_acompanhantes](https://user-images.githubusercontent.com/107574302/212151352-23bc547b-ef07-4292-808e-e707ab9af133.png)

![tela_erro_idade](https://user-images.githubusercontent.com/107574302/212151298-232c74a2-29a4-41a7-81c8-4ef893b0e60a.png)

![tela_erro_presente_cadastrado](https://user-images.githubusercontent.com/107574302/212151439-d3f47762-9d89-44ca-b45f-0c29797939e4.png)

![tela_erro_nome](https://user-images.githubusercontent.com/107574302/212151496-2cca14a2-d413-4d93-9b79-529403fc9206.png)

<p>Organização dos pacotes do projeto</p>

![tela_classes](https://user-images.githubusercontent.com/107574302/212152557-93874ea6-0739-41b9-ad7b-3246b7424e2a.png)

<p>Classes Controller, REST e Service</p>

![tela_convidados_controller](https://user-images.githubusercontent.com/107574302/212152069-f834380f-458c-4174-bf6d-dbab97e77059.png)

![tela_convidado_service_2](https://user-images.githubusercontent.com/107574302/212152967-bacfef97-90dc-4a19-b995-30a9a780cf11.png)

![tela_convidado_service](https://user-images.githubusercontent.com/107574302/212152088-f9507798-efb9-428e-93fd-d0aabfc9ced6.png)

![tela_convidado_rest_controller_2](https://user-images.githubusercontent.com/107574302/212153015-71a6c39e-6ae3-4cb3-89fd-0e59256c6657.png)

![tela_convidado_rest_controller](https://user-images.githubusercontent.com/107574302/212152110-b46f7557-98f8-4c1b-a27d-0c4dfe319729.png)

<p>Inserção de dados através do hibernate</p>

![tela_hibernate_insert](https://user-images.githubusercontent.com/107574302/212154475-5e5e8f43-86e6-48c2-b96a-090d006000dd.png)

<p>Exemplo de form usando thymeleaf</p>

![tela_presente_form](https://user-images.githubusercontent.com/107574302/212154489-58f0a108-7aae-476f-a831-b3fb59c2d13c.png)

<p>Testes implementados</p>

![tela_testes](https://user-images.githubusercontent.com/107574302/212154496-2e78772f-ce0c-4300-a6a0-0cbf0f2b3c11.png)

