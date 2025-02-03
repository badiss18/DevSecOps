# 1. Étape de build avec Node.js  
FROM node:20-alpine as build  

# 2. Définition du répertoire de travail  
WORKDIR /app   

# 3. Copie des fichiers package.json et package-lock.json pour optimiser le cache  
COPY package*.json ./  

# 4. Installation des dépendances  
RUN npm install  

# 5. Copie des autres fichiers du projet  
COPY . .  

# 6. Build du projet  
RUN npm run build  

# 7. Utilisation de Nginx comme serveur web pour le frontend  
FROM nginx:alpine  

# 8. Copie des fichiers générés vers le dossier de déploiement de Nginx  
COPY --from=build /app/dist /usr/share/nginx/html  

# 9. Exposition du port 80  
EXPOSE 80  

# 10. Démarrage de Nginx  
CMD ["nginx", "-g", "daemon off;"]
