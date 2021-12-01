# page1

**### Hands on**

Agora que temos o contexto da nossa aplicação o primeiro passo para a construção da API será escolher quais as tecnologias e ferramentas iremos utilizar, nesse projeto escolhemos as seguintes ferramentas:

- Java [3]: O Java é uma linguagem de programação orientada a objetos e é uma das linguagens mais utilizadas pelas empresas na atualidade no desenvolvimento de aplicações WEB e Mobile. O Java foi criado em 1995 na empresa Sun Microsystem por uma equipe chefiada por James Gosling, conhecido como o pai do Java. Em 2008, o Java foi adquirido pela Oracle e vem crescendo bastante desde então no mercado de tecnologia
- Springbot [4]:  O Spring Boot é um framework Java open source que tem como objetivo facilitar esse processo em aplicações Java. Consequentemente, ele traz mais agilidade para o processo de desenvolvimento, uma vez que devs conseguem reduzir o tempo gasto com as configurações iniciais.
- Hibernate [5] : O Hibernate é um projeto open-source fundado por Gavin King e segue os passos do Spring em popularidade, conseguindo se tornar um dos frameworks mais usados para persistência de dados. A ideia deste framework é transformar o acesso a dados, em um banco de dados relacional, mais simples através da manipulação de objetos Java, deixando de lado as instruções SQL empregadas em operações de CRUD. O Hibernate possui uma rica documentação de introdução sobre como usá-lo disponível em vários idiomas, incluindo o Português. Atualmente, ele é encontrado na versão estável 3.6.8-Final, embora já haja a versão 4, ainda não considerada uma versão estável. Um dos fatores positivos do Spring Framework é a facilidade de integração entre ele e outros **frameworks Java, como o próprio Hibernate.**

Percebam que é importante verificar a compatibilidade e a disponibilidade das tecnologias que serão usadas no projeto, no nosso projeto em questão adotamos apenas ferramentas open source e que possuem compatibilidade entre si,  nesse temos a garantia de um desenvolvimento com poucos problemas no processo de integração. 

[3] [https://www.zup.com.br/blog/java](https://www.zup.com.br/blog/java)

[4] [https://www.zup.com.br/blog/spring-boot](https://www.zup.com.br/blog/spring-boot)

[5] [https://www.devmedia.com.br/como-integrar-os-frameworks-spring-e-hibernate/23414](https://www.devmedia.com.br/como-integrar-os-frameworks-spring-e-hibernate/23414)

Modelo:

[https://digitalinnovation.one/artigos/construindo-uma-api-rest-com-java-spring-boot-e-hibernate](https://digitalinnovation.one/artigos/construindo-uma-api-rest-com-java-spring-boot-e-hibernate)

====================================================

O primeiro passo vai ser criar a estrutura inicial do nosso projeto usando o Spring initialzr [6]. Aqui iremos definir as configurações iniciais da nossa aplicação usando o Spring framework, vamos adicionar uma dependência para construção de API's Web no padrão MVC. 

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled.png)

[6] [https://start.spring.io/](https://start.spring.io/)

Após a realização da configuração inicial, realizamos o download, extração e importação da estrutura do projeto para nossa IDE de desenvolvimento.

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%201.png)

Neste projeto os pontos mais importantes são o arquivo **pom.xml**, que contém o *starter* web e das dependências que definimos:

E o arquivo **RestComicsApplication.java** que contém o nosso método `main`, este método será responsável por carregar todas dependências embutidas na aplicação, isso inclui o servidor web (o **Tomcat**).: 

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%202.png)

Vamos moddificar um pouco a estrutura base do nosso projeto para qque seja compatível com o modelo MVC. [7] MVC é acrônimo de Model, View e Controller, e é bacana entender o papel de cada um deles dentro do sistema. Esse entendimento vai te ajudar a trabalhar com Spring MVC de forma a construir aplicações mais organizadas e de fácil manutenção.

[7] [https://blog.algaworks.com/spring-mvc/](https://blog.algaworks.com/spring-mvc/)

Uma das conversões que o Spring Boot adota é que ele reconhece como componentes da aplicação, todas as classes definidas no mesmo pacote da classe que contém o método `main` ou em um package “abaixo” do package.

Ou seja, como a nossa classe está definida no pacote **br.com.jcarlos.restcomics**, qualquer classe definida nele ou em um “subpackage” dele, será reconhecida pelo Spring Boot. Desta forma, vamos definir a nossas entidades no pacote **br.com.jcarlos.restcomics.model**:

#################

O segundo passo vai ser criar uma base de dados local com o Docker para facilitar a persistência de dados :

Para criar nossa base de dados  vamos usar um conteiner Docker Mysql juntamente com o gerenciador PHPmyadmin para o gerenciamento. Para isso vamos criar um novo diretório em src  chamado Docker, que irá conter o arquivo de configuração do docker-compose [12]

[12][https://share.atelie.software/subindo-um-banco-de-dados-mysql-e-phpmyadmin-com-docker-642be41f7638](https://share.atelie.software/subindo-um-banco-de-dados-mysql-e-phpmyadmin-com-docker-642be41f7638)

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%203.png)

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%204.png)

Com o nosso seriço de banco de dados online vamos criar uma nova base chamada rest_comics com o modelo de colação apropriado a língua portuguesa [13]

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%205.png)

[13] [https://pt.stackoverflow.com/questions/72139/qual-codificação-de-caracteres-collation-devo-usar-em-mysql](https://pt.stackoverflow.com/questions/72139/qual-codifica%C3%A7%C3%A3o-de-caracteres-collation-devo-usar-em-mysql)

Em seguida vamos adicionar as configurações de conexão com a base de dados no projeto através do arquivo src>main>resources>application.properties 

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%206.png)

Também precisamos adicionar  duas dependências na configuração do projeto: JPA e mysql, uma nos permite fazer a persistência e manipulação de dados  através do padrão Hibernate [14]e outra nos permite realizar a conexão com a base mysql.

 

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%207.png)

[14] [https://www.devmedia.com.br/guia/hibernate/38312](https://www.devmedia.com.br/guia/hibernate/38312)

#############

O Terceiro passo vai ser criar nosso model para User

Em model vamos criar  a primeira classe da nossa aplicação **User**

A classe user tem os seguintes elementos

Os atributos base definidos nos requisitos:

- Nome
- E-mail
- CPF
- Data de nascimento

Mas alguns elementos extras que vão nos permitir manipular a classe e seus objetos de uma melhor forma:

Equals e Hashcodes [8]

Getters and Setters [9] 

serialVersionUID [10]

JPA notations [11]

[8]  [https://angeliski.com.br/2014/01/05/equals-e-hashcode/](https://angeliski.com.br/2014/01/05/equals-e-hashcode/)

[9] [https://pooperrotti.fandom.com/pt-br/wiki/Getters_e_setters](https://pooperrotti.fandom.com/pt-br/wiki/Getters_e_setters)

[10] [https://blog.algaworks.com/serialversionuid/](https://blog.algaworks.com/serialversionuid/)

[11] [https://developer.okta.com/blog/2019/02/01/spring-hibernate-guide](https://developer.okta.com/blog/2019/02/01/spring-hibernate-guide)

O interessante do uso do Hibernate JPA notations é que podemos já implementar algumas regras da nossa aplicação como não permitir valores nulos ou definir o tamanho dos campos na base de dados .

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%208.png)

##############

O quarto passo vai ser criar um pacote repository que vai atuar como a camada de persistência, dentro desse pacote iremos criar uma interface chamada **UserRepository**

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%209.png)

Também iremos criar um pacote chamado: **services**  e uma classe chamada **UserService .** Geralmente, para se escrever a lógica relacionada aos negócios de uma *feature*, faz-se o uso do conceito do **Service**. É essa classe que vai ser a facilitadora no acesso dos **Models** a partir do *framework* de persistência de sua escolha [11].

[11] [https://medium.com/equals-lab/15-boas-práticas-para-desenvolvimento-de-aplicações-com-spring-boot-953e0ff2e24f](https://medium.com/equals-lab/15-boas-pr%C3%A1ticas-para-desenvolvimento-de-aplica%C3%A7%C3%B5es-com-spring-boot-953e0ff2e24f)

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2010.png)

Aqui na camada de service vamos aproveitar também para implementar um novo pacote chamado exception que irá conter uma classe chamada ResourceNotFoundException  que irá nos retornar as mensagens de exceção , como por exemplo quando registros não forem encontrados.:  [12]

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2011.png)

[12] [https://www.baeldung.com/spring-response-status-exception](https://www.baeldung.com/spring-response-status-exception)

#############

O quinto passo é adicionar o pacote controller e a classe UserController que será a camada responsável tanto por receber requisições como por enviar a resposta ao usuário, a nossa classe controler irá utilizar aannotation ***@RestController*** no Spring MVC nada mais é do que uma combinação das annotations *@**Controller*** e ***@ResponseBody***. Essa annotation foi adicionada ao **Spring 4.0** para facilitar o desenvolvimento dos serviços ***RESTful*** com Framework Spring [13]. É nessa classe que iremos realizar o mapeamento de rotas da nossa API RequestMapping, dessa forma o controller irá receber solicitações do usuário, encaminha-las a camada de servise e Repository .

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2012.png)

Algumas observações sobre essa classe

- A anotação `@RestController` permite definir um controller com características REST;
- A anotação `@Autowired` delega ao Spring Boot a inicialização do objeto;
- A anotação `@RequestMapping` permite definir uma rota. Caso não seja informado o método HTTP da rota, ela será definida para todos os métodos.
- A anotação `@PathVariable` indica que o valor da variável virá de uma informação da rota;
- A anotação `@RequestBody` indica que o valor do objeto virá do corpo da requisição;

 [13] [https://medium.com/@gcbrandao/diferença-entre-restcontroller-e-controller-annotation-no-spring-mvc-e-rest-8533998a93eb](https://medium.com/@gcbrandao/diferen%C3%A7a-entre-restcontroller-e-controller-annotation-no-spring-mvc-e-rest-8533998a93eb)

################

Pronto com esses componentes já podemos realizar o primeiro teste funcional da nossa API, para isso vamos verificar o nosso banco de dados Docker usando o PHPmyAdmin:

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2013.png)

Como podemos verificar o banco não possui nenhum registro ou tabela salva.

PAra testar o funcionamento da nossa API vamos executar nossa classe principal e utilizando o Postman que é um aplicativo com a função de testar e desenvolver APIs em uma interface bastante simples e intuitiva. Ele nos permite simular requisições HTTP de forma rápida, armazenando-as para que possamos usá-las posteriormente. vamos realizar alguns testes [14]. 

[14][https://imasters.com.br/apis-microsservicos/ganhando-eficiencia-em-suas-apis-com-o-postman](https://imasters.com.br/apis-microsservicos/ganhando-eficiencia-em-suas-apis-com-o-postman)

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2014.png)

[14][https://imasters.com.br/apis-microsservicos/ganhando-eficiencia-em-suas-apis-com-o-postman](https://imasters.com.br/apis-microsservicos/ganhando-eficiencia-em-suas-apis-com-o-postman)

Nossa aplicação é executada através do Tomcat no endereço [localhost:8080](http://localhost:8080) então vamos configurar o postman para fazer requisições para nossa API:

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2015.png)

O Status 200 quer dizer que nossa aplicação retornou uma resposta com sucesso. Como definimos no controle que a rota /user vai chamar primeiro a função listall não retounou nenhum valor pois não havia nenhum usuário cadastrado ainda. Mas se verificarmos novamente nosso banco de dados veremos que a tabela user foi criada com os atributos que definimos no Model.

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2016.png)

Podemos realizar um teste adicionando manualmente na base de dados um novo registro

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2017.png)

Dessa forma podemos verificar no Postman que a requisição retorna agora nosso usuário cadastrado

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2018.png)

Também podemos passar um id específico para testar a função FindByID

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2019.png)

Vamos fazer um teste também coma inserção através do método POST

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2020.png)

Por fim vamos testar a atualização com PUT passando o ID do usuário no body e o delete DELETE através do id

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2021.png)

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2022.png)

Ao fim desses teste nossa aplicação vai ter uma usuário na base de dados

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2023.png)

![Untitled](page1%20b853eaf0215e4ea1b05d7758802de5e3/Untitled%2024.png)

Próximo passo:

 bem agora que a estrutura da nossa aplicação já está funcionando nas próximas etapas vamos adicionar o restante dos requisitos.