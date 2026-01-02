# TP-23 Migration de Eureka vers Consul

## Auteur
Olaya Layadi

## Description
Ce projet est une migration d'une architecture microservices basée sur Eureka vers Consul. Il comprend plusieurs modules :
- **car** : Microservice de gestion des voitures
- **client** : Microservice de gestion des clients
- **gateway** : API Gateway pour le routage dynamique
- **server_eureka** : Serveur Eureka (pour référence ou migration)

Chaque module est adapté avec des commentaires détaillés et une structure modernisée.

## Structure du projet
```
tp23/
  car/
  client/
  gateway/
  server_eureka/
```

## Lancement rapide
1. Démarrer Consul sur `localhost:8500`.
2. Démarrer la base de données MySQL (voir `application.yml` de chaque service).
3. Compiler et lancer chaque microservice avec Maven :
   ```sh
   ./mvnw spring-boot:run
   ```

## Remarques
- Les noms de package et d'application sont remplacés par `olaya.layadi`.
- Les fichiers sont commentés pour faciliter la compréhension.
- Le serveur Eureka est conservé pour référence.

---
TP réalisé par Olaya Layadi
