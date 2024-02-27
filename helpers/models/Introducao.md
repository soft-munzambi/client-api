# Modelos "Models"

Os modelos são classes que representam as nossas entidades. No entanto, tendo já conhecimento de orientação a objetos, entendemos que as entidades têm suas características, seus atributos, suas ações, etc.

No projeto apresentado como guia básico de Spring Boot, temos quatro entidades:

* Tipo de cliente (TypeClient)
* Clientes (RegisterClient)
* Contatos (RegisterContact)
* País (Country)

Falar sobre todas essas entidades ou documentá-las levará tempo desnecessário. No entanto, irei descrever apenas uma entidade para que tenhamos uma noção do que é e como funciona.

**Clientes**

É uma classe que contém os atributos que serão apresentados na tabela abaixo, e em seguida, explicaremos cada anotação presente no modelo. Esta classe serve como uma representação estruturada dos dados que queremos armazenar ou manipular em nossa aplicação. Ao detalhar cada anotação, garantimos uma compreensão completa da funcionalidade e do propósito de cada elemento dentro do modelo, facilitando a manutenção e o desenvolvimento futuro da aplicação.

| Order | Atributte name | type       | Description Português | Valor                                             |
| ----- | -------------- | ---------- | ---------------------- | ------------------------------------------------- |
| 1     | uuid           | String     | chave primaria (uuid)  | "7a0a1c4b-6776-494e-92d8-628d91f9bff7"            |
| 2     | name           | String     | Nome                   | "Munzambi Miguel"                                 |
| 3     | nif            | String     | identificação fiscal | "000234543OSD29348"                               |
| 4     | typeClient     | TypeClient | Entidade Tipo Cliente  | "8a0a1c4b-6776-494e-92d8-628d91f9bff7"            |
| 5     | details        | String     | detalhes do cliente    | Toda possivel informação longa do cliente....   |
| 6     | createdAt      | Instant    | criado at ...          | "2024-02-27T21:31:29.749822372Z",                 |
| 7     | updatedAt      | Instant    | atualizado at          | "2024-02-27T21:31:29.749822372Z",                 |
| 8     | deletedAt      | Instant    | eliminado at           | Caso eliminado "2024-02-27T21:31:29.749822372Z", |

**Anotações spring boot.	Lombok**

O Projeto Lombok é uma biblioteca do Java que oferece recursos para reduzir a verbosidade do código, automatizando a geração de métodos comuns, como getters, setters, construtores e métodos `toString()`. No contexto do Spring Boot, o Lombok é frequentemente usado para simplificar a criação de classes de modelo, eliminando a necessidade de escrever manualmente código repetitivo. Isso torna o desenvolvimento mais rápido e limpo, permitindo que os desenvolvedores se concentrem na lógica de negócios em vez de na boilerplate. Além disso, o Lombok oferece suporte para anotações como `@Data`, `@Getter`, `@Setter` e `@NoArgsConstructor`, que podem ser aplicadas diretamente às classes de modelo para gerar automaticamente os métodos correspondentes, melhorando a legibilidade e a manutenção do código. Em resumo, o Lombok no Spring facilita a criação de classes de modelo concisas e eficientes, aumentando a produtividade do desenvolvedor.

```
import lombok.Getter -> @Getter
import lombok.Setter -> @Setter
import lombok.AllArgsConstructor -> @AllArgsConstructor
import lombok.NoArgsConstructor -> @NoArgsConstructor
```

O Projeto Lombok foi criado por **Reinier Zwitserloot e Roel Spilker.** É um projeto de código aberto que visa simplificar o desenvolvimento Java, reduzindo a quantidade de código boilerplate.  O Projeto Lombok foi desenvolvido pela primeira vez em **2009**. Desde então, tem sido uma ferramenta popular entre os desenvolvedores Java, continuando a evoluir e receber atualizações regularmente para melhorar sua funcionalidade e compatibilidade com novas versões da linguagem Java.

**jakarta persistence**

É um pacote Java que faz parte do Jakarta EE (Enterprise Edition), uma plataforma para desenvolvimento de aplicativos corporativos em Java. Este pacote contém classes e interfaces que definem a especificação de persistência de dados para aplicativos Java, conhecida como Jakarta Persistence API (JPA).

A Jakarta Persistence API é uma especificação que define um conjunto de classes e métodos para persistência de dados em bancos de dados relacionais utilizando o paradigma de mapeamento objeto-relacional (ORM). Ela simplifica o acesso e a manipulação de dados em bancos de dados através de objetos Java, permitindo que os desenvolvedores trabalhem com modelos de objetos em vez de lidar diretamente com SQL.

Com o uso do JPA, os desenvolvedores podem mapear classes Java para tabelas de banco de dados e realizar operações de CRUD (Create, Read, Update, Delete) de forma mais simples e intuitiva, facilitando o desenvolvimento de aplicativos que necessitam de armazenamento de dados.


```
import jakarta.persistence.Table; -> @Entity
import jakarta.persistence.Entity; -> @Table(name = "clients")
```

A anotação `@Entity` é uma anotação fornecida pelo framework JPA (Java Persistence API) que indica que a classe Java está mapeada para uma tabela em um banco de dados relacional. Quando uma classe é marcada com `@Entity`, o JPA reconhece essa classe como uma entidade persistente e permite que ela seja armazenada e recuperada de um banco de dados.

Já a anotação `@Table(name = "clients")` é usada para especificar o nome da tabela correspondente no banco de dados. Neste caso, a tabela no banco de dados será nomeada "clients".

Essas anotações são comumente usadas em aplicações Spring Boot que utilizam o Spring Data JPA para persistência de dados.

Quanto ao criador dessas anotações, elas fazem parte da especificação do Java Persistence API (JPA), que é uma parte do Java EE (Enterprise Edition) e foi desenvolvido por um grupo de especialistas da indústria, liderados pela Oracle Corporation. O JPA foi introduzido como parte do Java EE 5 em 2006 e tem sido mantido e atualizado pela comunidade Java desde então.
