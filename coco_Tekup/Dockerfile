# 1. Utilisation de l'image OpenJDK 17 légère comme base
FROM openjdk:17-jdk-slim  

# 2. Définition du répertoire de travail dans le conteneur
WORKDIR /app  

# 3. Copie du fichier JAR généré dans le conteneur
COPY target/*.jar app.jar  

# 4. Exposition du port 8080 (port par défaut de Spring Boot)
EXPOSE 8080  

# 5. Commande de lancement de l’application
CMD ["java", "-jar", "app.jar"]
