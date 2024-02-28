# Use uma imagem base do OpenJDK para Java 21
FROM openjdk:21-jdk

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app


# Copia o arquivo JAR do seu projeto Spring para o diretório de trabalho no contêiner
COPY target/api-clientes-0.0.1-SNAPSHOT.jar /app

# Comando para executar o aplicativo Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "api-clientes-0.0.1-SNAPSHOT.jar"]
