**## Introdução e conceitos iniciais.**

Olá pessoal, sabemos que com a evolução da internet os serviços e aplicações online também evoluíram no sentido de se tornarem mais escaláveis e acessíveis, a comunicação entre serviços e sistemas web foi se tornando cada vez mais uma necessidade para o desenvolvimento de novas aplicações.

Então vamos entender como podemos implementar um sistemas baseado nesses novos padrões de comunicação para serviços web. Nesse artigo vamos entender como poderíamos criar uma API baseada no padrão REST.

Mas calma antes de tudo vamos entender um pouco sobre esses dois conceitos [1]:

- ***API (Application Programming Interface)**** – É como uma interface entre dois programas diferentes de modo que eles possam se comunicar um com o outro. Ou seja, uma *API** é a forma que terceiros disponibilizam uma interface de modo que possamos consumir um determinado serviço deles sem nos preocuparmos com a implementação do mesmo. As *API** podem usar qualquer meio de comunicação para iniciar a interação entre as aplicações. Por exemplo, as chamadas de sistema (System Calls) são invocados usando interrupções da *API** do kernel Linux.
- ***Web Services**** – é uma interface projetada para se comunicar via rede. É uma *API** que usa obrigatoriamente a rede. Tipicamente, HTTP é o protocolo mais comumente usado para a comunicação. *Web Services** também usam SOAP, REST e XML-RPC como meio de comunicação. Ou seja, quando uma*API** precisa enviar dados através de rede, estamos falando de *Web Services**.
- ***REST-**** "Representational State Transfer" [2], que em português significa tansferência de estado representacional" ****não é um protocolo ou padrão, mas sim um conjunto de restrições de arquitetura. Os desenvolvedores de API podem implementar a arquitetura REST de maneiras variadas.

Quando um cliente faz uma solicitação usando uma API RESTful, essa API transfere uma representação do estado do recurso ao solicitante ou endpoint. Essa informação (ou representação) é entregue via HTTP utilizando um dos vários formatos possíveis: Javascript Object Notation (JSON), HTML, XLT, Python, PHP ou texto sem formatação. O formato JSON é a linguagem de programação mais usada porque, apesar de seu nome, é independente de qualquer outra linguagem e pode ser lido por máquinas e humanos.

Agora que reunimos os conceitos principais necessários, sabemos que um Webservice se trata de uma API que pode usar meios de comunicação e protocolos web para implementar seus serviços. Nosso objeto então é usar a Arquitetura REST para construção dessa API.

[1] [https://cursos.alura.com.br/forum/topico-qual-a-diferenca-entre-web-services-e-api-55330](https://cursos.alura.com.br/forum/topico-qual-a-diferenca-entre-web-services-e-api-55330)

[2] [https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)

### Contexto da aplicação

Nossa aplicação representará um contexto de banca digital de quadrinhos (Commics). Vamos listar quais seriam as etapas e os requisitos base para esse tipo de aplicação:

#### Primeira etapa da aplicação:

 Construção de um cadastro de usuários, para esse cadastro, os seguintes requisitos devem ser respeitados:

- O Usuário deve possuir os seguintes dados cadastrados
    - Nome
    - E-mail
    - CPF
    - Data de nascimento
- As restrições devem ser respeitadas
    - O Nome é obrigatório
    - O E-mail é obrigatório
    - O CPF é obrigatório
    - A data de nascimento é obrigatória
    - O e-mail deve ser um e-mail válido (ex: formato [usuario@host.com](mailto:usuario@host.com)…)
    - O CPF deve ser válido
    - A data de nascimento deve estar no formato dd/mm/aaaa
    - O e-mail deve ser único (apenas um usuário cadastrado pode possuir um determinado endereço e-mail)
    - CPF deve ser único (apenas um usuário cadastrado pode possuir um determinado CPF)

#### Segunda etapa da aplicação:

Construção de um cadastro de quadrinhos (Comics) para um determinado usuário. Para este requisito, deve-se consumir a API da MARVEL (disponível em [https://developer.marvel.com/](https://developer.marvel.com/)) para buscar os dados de um determinado quadrinho, baseado no comicId informado no momento do cadastro. Para este cadastro, os seguintes requisitos devem ser respeitados:

- O Comic deve possuir os seguintes dados cadastrados
    - ComicId
    - Título
    - Preço
    - Autores
    - ISBN
    - Descrição
- As restrições devem ser respeitadas
    - ComicId é obrigatório
    - O Título é obrigatório
    - O Preço é obrigatório
    - Os Autores são obrigatórios
    - O ISBN é obrigatório
    - O ISBN deve ser único (apenas um Comic cadastrado pode possuir um determinado ISBN)

#### Terceira etapa da aplicação:

Construção de uma consulta da lista de usuários cadastrados na aplicação. Para essa consulta, não deve ser retornada a lista de quadrinhos de cada usuário. 
 
#### Quarta  etapa da aplicação:

Construção de uma consulta da lista de quadrinhos de um determinado Usuário. Para essa listagem, devemos obedecer algumas regras de negócio da nossa aplicação:

- Cada quadrinho possui um desconto de 10% que pode ser aplicado ao seu preço de acordo com o dia da semana em que a consulta está sendo realizada.
- O dia da semana que corresponde a aplicação do desconto varia de acordo com o dígito final do ISBN, conforme abaixo:
    - Final 0-1: segunda-feira
    - Final 2-3: terça-feira
    - Final 4-5: quarta-feira
    - Final 6-7: quinta-feira
    - Final 8-9: sexta-feira
- Deverá haver um atributo em cada quadrinho indicando se um desconto está ou não está sendo aplicado ao seu preço.

*Exemplo A:* hoje é segunda-feira, o Comics tem o ISBN XXXXXXXX1, ou seja, seu desconto será às segundas-feiras e o atributo de desconto ativo será TRUE.*Exemplo B:* hoje é quinta-feira, o Comics tem o ISBN XXXXXXXX1, ou seja, seu desconto será às segundas-feiras e o atributo de desconto ativo será FALSE.As respostas retornadas pelos endpoints da API construída devem seguir os requisitos:

- Caso os cadastros estejam corretos, é necessário retornar o HTTP Status Code 201. Caso haja erros de preenchimento de dados, o HTTP Status Code retornado deve ser 400 e deve ser apresentada uma mensagem indicando qual campo foi preenchido incorretamente.
- Caso as buscas estejam corretas, é necessário retornar o HTTP Status Code 200. Caso haja erro na busca, retornar o status adequado (atenção a erros do cliente ou do servidor) e uma mensagem de erro amigável.

### Hands on

Agora que temos o contexto da nossa aplicação o primeiro passo para a construção da API será escolher quais as tecnologias e ferramentas iremos utilizar, nesse projeto escolhemos as seguintes ferramentas:

- Java [3]: O Java é uma linguagem de programação orientada a objetos e é uma das linguagens mais utilizadas pelas empresas na atualidade no desenvolvimento de aplicações WEB e Mobile. O Java foi criado em 1995 na empresa Sun Microsystem por uma equipe chefiada por James Gosling, conhecido como o pai do Java. Em 2008, o Java foi adquirido pela Oracle e vem crescendo bastante desde então no mercado de tecnologia
- Springbot [4]:  O Spring Boot é um framework Java open source que tem como objetivo facilitar esse processo em aplicações Java. Consequentemente, ele traz mais agilidade para o processo de desenvolvimento, uma vez que devs conseguem reduzir o tempo gasto com as configurações iniciais.
- Hibernate [5] : O Hibernate é um projeto open-source fundado por Gavin King e segue os passos do Spring em popularidade, conseguindo se tornar um dos frameworks mais usados para persistência de dados. A ideia deste framework é transformar o acesso a dados, em um banco de dados relacional, mais simples através da manipulação de objetos Java, deixando de lado as instruções SQL empregadas em operações de CRUD. O Hibernate possui uma rica documentação de introdução sobre como usá-lo disponível em vários idiomas, incluindo o Português. Atualmente, ele é encontrado na versão estável 3.6.8-Final, embora já haja a versão 4, ainda não considerada uma versão estável. Um dos fatores positivos do Spring Framework é a facilidade de integração entre ele e outros **frameworks Java, como o próprio Hibernate.**

Percebam que é importante verificar a compatibilidade e a disponibilidade das tecnologias que serão usadas no projeto, no nosso projeto em questão adotamos apenas ferramentas open source e que possuem compatibilidade entre si,  nesse temos a garantia de um desenvolvimento com poucos problemas no processo de integração. 

[3] [https://www.zup.com.br/blog/java](https://www.zup.com.br/blog/java)

[4] [https://www.zup.com.br/blog/spring-boot](https://www.zup.com.br/blog/spring-boot)

[5] [https://www.devmedia.com.br/como-integrar-os-frameworks-spring-e-hibernate/23414](https://www.devmedia.com.br/como-integrar-os-frameworks-spring-e-hibernate/23414)

You can use the [editor on GitHub](https://github.com/jcarloslimaufc/VUP-challenge/edit/gh-pages/index.md) to maintain and preview the content for your website in Markdown files. Test.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [Basic writing and formatting syntax](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/jcarloslimaufc/VUP-challenge/settings/pages). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.
