## Introduçaõ e conceitos iniais.


Olá pessoal, sabemos que com a evolução da internet os serviços e aplicações online também evoluíram no sentido de se tornarem mais escaláveis e acessíveis, a comunicação entre serviços e sistemas web foi se tornando cada vez mais uma necessidade para o desenvolvimento de novas aplicações.

Então vamos entender como podemos implementar um sistemas baseado nesses novos padrões de comunicação para serviços web. Nesse artigo vamos entender como poderíamos criar uma API baseada no padrão REST. 

Mas calma antes de tudo vamos entender um pouco sobre esses dois conceitos [1]:

**API (Application Programming Interface)** – É como uma interface entre dois programas diferentes de modo que eles possam se comunicar um com o outro. Ou seja, uma *API* é a forma que terceiros disponibilizam uma interface de modo que possamos consumir um determinado serviço deles sem nos preocuparmos com a implementação do mesmo. As *API* podem usar qualquer meio de comunicação para iniciar a interação entre as aplicações. Por exemplo, as chamadas de sistema (System Calls) são invocados usando interrupções da *API* do kernel Linux.

**Web Services** – é uma interface projetada para se comunicar via rede. É uma *API* que usa obrigatoriamente a rede. Tipicamente, HTTP é o protocolo mais comumente usado para a comunicação. *Web Services* também usam SOAP, REST e XML-RPC como meio de comunicação. Ou seja, quando uma*API* precisa enviar dados através de rede, estamos falando de *Web Services*.

**REST-** "Representational State Transfer" [2], que em português significa tansferência de estado representacional" ****não é um protocolo ou padrão, mas sim um conjunto de restrições de arquitetura. Os desenvolvedores de API podem implementar a arquitetura REST de maneiras variadas.

Quando um cliente faz uma solicitação usando uma API RESTful, essa API transfere uma representação do estado do recurso ao solicitante ou endpoint. Essa informação (ou representação) é entregue via HTTP utilizando um dos vários formatos possíveis: Javascript Object Notation (JSON), HTML, XLT, Python, PHP ou texto sem formatação. O formato JSON é a linguagem de programação mais usada porque, apesar de seu nome, é independente de qualquer outra linguagem e pode ser lido por máquinas e humanos.


[1] [https://cursos.alura.com.br/forum/topico-qual-a-diferenca-entre-web-services-e-api-55330](https://cursos.alura.com.br/forum/topico-qual-a-diferenca-entre-web-services-e-api-55330)

[2] [https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)

Agora que reunimos os conceitos principais necessários, sabemos que um Webservice se trata de uma API que pode usar meios de comunicação e protocolos web para implementar seus serviços. Nosso objeto então é usar a Arquitetura REST para construção dessa API.

### Contexto da aplicação



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
