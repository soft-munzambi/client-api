# Repositorio Cliente

Esta classe Java é como uma espécie de 'assistente' que ajuda nosso aplicativo a lidar com informações sobre clientes. Ela está equipada com habilidades especiais para acessar e modificar dados dos clientes em nosso sistema, tudo de forma muito inteligente e eficiente.

Vamos analisar o que ela faz:

1. **Ela sabe onde encontrar os dados dos clientes** :
   Ela sabe exatamente onde procurar as informações dos clientes no nosso sistema. Imagine que ela tem um mapa que a guia diretamente para a 'prateleira' certa onde os dados dos clientes estão guardados.
2. **Ela pode fazer muitas coisas úteis com esses dados** :
   Não só ela pode encontrar os dados dos clientes, mas também pode fazer uma série de coisas úteis com eles. Por exemplo, ela pode mostrar uma lista de todos os clientes que temos, ou filtrar essa lista com base em certos critérios, como datas específicas ou o nome dos clientes. Ela até mesmo consegue verificar se um cliente com um determinado número de identificação fiscal já está registrado em nosso sistema.
3. **Ela entende o que você precisa, mesmo que você não diga diretamente** :
   Ela é muito inteligente e atenciosa. Mesmo que você não diga exatamente o que precisa, ela é capaz de entender e fornecer exatamente o que você está procurando. Por exemplo, se você quiser encontrar clientes dentro de um certo período de tempo ou que tenham um nome específico, ela pode fazer isso para você sem problema algum.

Então, basicamente, esta classe é como uma assistente muito habilidosa que simplifica muito o nosso trabalho ao lidar com informações sobre os clientes em nosso sistema. É como ter um assistente pessoal confiável que sempre está lá para nos ajudar quando precisamos lidar com os dados dos nossos clientes.

# **Anotações da Classe** :

### * **`@Repository`: Indica que esta classe é um componente de repositório do Spring, responsável por acessar e manipular dados.**

Vamos falar sobre uma anotação especial chamada `@Repository` que está presente nesta classe. Imagine que essa anotação é como um distintivo que diz: "Ei, sou especialista em lidar com dados!".

***Então, quando você vê essa anotação em uma classe como esta, você sabe que ela é como uma super-heroína dos dados, pronta para entrar em ação sempre que precisarmos de informações ou quiser fazer alguma alteração nelas.***

Basicamente, essa anotação ajuda o nosso aplicativo a ser muito mais inteligente quando se trata de lidar com os dados. É como ter um assistente pessoal confiável sempre à disposição para garantir que nossos dados sejam acessados e manipulados da melhor forma possível


# Querys


Uma query é uma instrução ou comando que é enviada a um banco de dados para recuperar, inserir, atualizar ou excluir dados. Em termos simples, é uma pergunta que você faz ao banco de dados para obter informações específicas ou realizar uma operação sobre os dados armazenados nele.

*Existem diferentes tipos de queries, dependendo da operação que você deseja realizar:*

1. **Consulta (Select)** : *Uma query de consulta é usada para recuperar dados do banco de dados. Ela geralmente começa com a palavra-chave `SELECT` e pode ser usada para filtrar, ordenar e limitar os resultados conforme necessário*.
2. **Inserção (Insert)** : *Uma query de inserção é usada para adicionar novos registros ao banco de dados. Ela começa com a palavra-chave `INSERT INTO` seguida pelo nome da tabela e os valores a serem inseridos*.
3. **Atualização (Update)** : *Uma query de atualização é usada para modificar dados existentes no banco de dados. Ela começa com a palavra-chave `UPDATE` seguida pelo nome da tabela e as colunas que devem ser atualizadas, juntamente com os novos valores.*
4. **Exclusão (Delete)** : *Uma query de exclusão é usada para remover registros do banco de dados. Ela começa com a palavra-chave `DELETE FROM` seguida pelo nome da tabela e, opcionalmente, uma condição que especifica quais registros devem ser excluídos.*

Em resumo, uma query é uma maneira de interagir com um banco de dados para acessar, modificar ou manipular os dados armazenados nele.

# Interface

Uma interface, em programação, é uma coleção de métodos abstratos, constantes e, em algumas linguagens, também métodos padrão ou estáticos, que definem um contrato para classes que as implementam.

Em termos mais simples, uma interface especifica um conjunto de comportamentos que uma classe pode adotar. Isso permite a criação de código mais flexível e modular, pois as classes podem implementar várias interfaces, o que permite a composição de diferentes funcionalidades.

As interfaces são usadas para definir um contrato entre diferentes partes de um sistema de software, garantindo que as classes que as implementam forneçam a funcionalidade especificada pela interface. Isso promove a reutilização de código e facilita a manutenção, já que as classes podem ser trocadas ou estendidas sem afetar outras partes do sistema.

Em linguagens de programação como Java, C# e TypeScript, as interfaces desempenham um papel fundamental na implementação de polimorfismo e abstração. Elas permitem que as classes sejam tratadas de forma polimórfica por meio de referências de interface, o que significa que diferentes objetos podem ser tratados de maneira uniforme, independentemente de sua classe concreta. Isso promove um design de código mais flexível e extensível.

# Interface RegisterClientRepository

```java


package ntemo.com.apiclientes.providers.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntemo.com.apiclientes.models.RegisterClient;

@Repository
public interface RegisterClientRepository
                extends CrudRepository<RegisterClient, String>, SrcGenericRepository<RegisterClientRepository> {

        @Query("SELECT t FROM RegisterClient t WHERE t.deletedAt IS NULL")
        List<RegisterClient> all();

        @Query("SELECT t FROM RegisterClient t " +
                        "WHERE (t.createdAt BETWEEN :startDate AND :endDate) "
                        + "AND (COALESCE(:name, '') = '' OR t.name LIKE CONCAT(:name, '%')) "
                        + "AND (COALESCE(:uuidList, '') = '' OR t.uuid IN :uuidList) AND t.deletedAt IS NULL")

        List<RegisterClient> allWithParamAnDateBETWEEN(
                        @Param("name") String name,
                        @Param("uuidList") List<String> uuidList,
                        @Param("startDate") Instant startDate,
                        @Param("endDate") Instant endDate);

        boolean existsByNif(String nif);
}
```

# Heraça 

Herança é um princípio de programação orientada a objetos em que uma classe (subclasse) pode herdar atributos e métodos de outra classe (superclasse). Isso promove a reutilização de código, permitindo que classes compartilhem características comuns e estendam ou modifiquem o comportamento herdado conforme necessário. A subclasse pode acessar e usar os membros herdados da superclasse, além de adicionar novos membros específicos. Este conceito facilita a criação de hierarquias de classes, promovendo a organização e a manutenção do código.

# Exemplo de Query no JPA

```java
@Query("SELECT t FROM RegisterClient t " +
                        "WHERE (t.createdAt BETWEEN :startDate AND :endDate) "
                        + "AND (COALESCE(:name, '') = '' OR t.name LIKE CONCAT(:name, '%')) "
                        + "AND (COALESCE(:uuidList, '') = '' OR t.uuid IN :uuidList) AND t.deletedAt IS NULL")
// Metodo com paramentros
List<RegisterClient> allWithParamAnDateBETWEEN(
                        @Param("name") String name,
                        @Param("uuidList") List<String> uuidList,
                        @Param("startDate") Instant startDate,
                        @Param("endDate") Instant endDate);

        boolean existsByNif(String nif);
```

```java
@Query("SELECT t FROM RegisterClient t WHERE t.deletedAt IS NULL")
List<RegisterClient> all();
```

# Doc - 002 Munzambi
