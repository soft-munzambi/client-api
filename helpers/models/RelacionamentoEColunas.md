# Colunm "Culunas"

Considerando a introdução que tivemos aos modelos, já adquirimos uma compreensão do que é necessário para o desenvolvimento de um modelo no Spring Boot, seguindo boas práticas. No entanto, é importante ressaltar que uma coluna em um modelo representa um atributo de uma entidade. Em outras palavras, cada coluna na tabela do banco de dados é mapeada para um atributo na classe de modelo correspondente. Esses atributos representam as características ou propriedades da entidade que estamos modelando. Ao definir esses atributos de forma adequada, podemos garantir que nossa aplicação seja capaz de armazenar e manipular os dados de maneira eficiente e precisa.


```
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "uuid", columnDefinition = "VARCHAR(250)")
private String uuid;
```

Essas anotações são usadas para configurar a identificação única de uma entidade em um banco de dados relacional em um projeto Java com Spring Boot, usando o Hibernate como implementação JPA.

* `@Id`: Indica que o campo `uuid` é a chave primária da entidade.
* `@GeneratedValue(strategy = GenerationType.UUID)`: Define a estratégia de geração de valor automático para a chave primária, neste caso, utilizando UUIDs.
* `@Column(name = "uuid", columnDefinition = "VARCHAR(250)")`: Mapeia o campo `uuid` para a coluna "uuid" no banco de dados, especificando que é do tipo VARCHAR com tamanho máximo de 250 caracteres.

Essas configurações garantem que cada instância da entidade tenha um UUID único como identificador no banco de dados.

```
@Column(name = "createdAt", columnDefinition = "TIMESTAMP")
private Instant createdAt;
```


**Relacionamento**

Essa anotação é usada para estabelecer um relacionamento de muitos-para-um entre duas entidades em um projeto Java com Spring Boot, utilizando o framework Hibernate como implementação JPA.

* `@ManyToOne`: Indica que a entidade atual tem um relacionamento de muitos-para-um com a entidade referenciada pela propriedade `typeClient`.

Essa configuração sugere que muitas instâncias da entidade atual podem estar associadas a uma única instância da entidade `TypeClient`.

```
@ManyToOne
private TypeClient typeClient;
```
