# 1. Étape de build avec Node.js  
FROM node:20-alpine as build  

# 2. Définition du répertoire de travail  
WORKDIR /app  

# 3. Copie des fichiers du projet dans le conteneur  
COPY . .  

# 4. Installation des dépendances et build du projet  
RUN npm install && npm run build  

# 5. Utilisation de Nginx comme serveur web pour le frontend  
FROM nginx:alpine  

# 6. Copie des fichiers générés vers le dossier de déploiement de Nginx  
COPY --from=build /app/dist/* /usr/share/nginx/html  

# 7. Exposition du port 80  
EXPOSE 80  

# 8. Démarrage de Nginx  
CMD ["nginx", "-g", "daemon off;"]
