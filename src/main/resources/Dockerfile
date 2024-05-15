# Utiliser une image de base officielle de Java 17
FROM openjdk:17-jdk-slim

# Ajouter des labels pour les métadonnées
LABEL maintainer="tagnehilaire90@gmail.com"
LABEL version="1.0"
LABEL description="Cette image contient une application Spring Boot utilisant Java 17"

# Définir l'argument pour la version de l'application
ARG JAR_FILE=target/*.jar

# Copier le fichier JAR généré dans l'image Docker
COPY ${JAR_FILE} app.jar

# Exposer le port que l'application Spring Boot utilise
EXPOSE 8888

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]
