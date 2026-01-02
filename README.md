# 🚀 Migration de Eureka vers Consul - Microservices

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Consul](https://img.shields.io/badge/HashiCorp%20Consul-1.15.0-FF4088?style=for-the-badge&logo=consul&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8.1-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## 📝 Présentation du Projet
Ce projet illustre la migration d'une architecture microservices basée sur **Netflix Eureka** vers **HashiCorp Consul** pour la découverte de services et la gestion de la configuration. L'objectif est de moderniser l'infrastructure en utilisant des outils plus robustes et polyvalents.

---

## 🏗️ Architecture du Système
Le projet est composé des modules suivants :

1.  **🚗 Car Service** : Gère l'inventaire des véhicules.
2.  **🌉 Gateway Service** : Point d'entrée unique utilisant Spring Cloud Gateway pour le routage dynamique via Consul.
3.  **📡 Server Eureka** : Conservé à titre de référence pour la comparaison post-migration.

---

## 🛠️ Stack Technique
- **Framework** : Spring Boot 3.1.0 / Spring Cloud 2022.0.3
- **Service Discovery** : HashiCorp Consul
- **Base de données** : MySQL
- **ORM** : Spring Data JPA / Hibernate
- **Outils** : Lombok, Actuator

---

## 🚀 Guide de Démarrage Rapide

### 1. Prérequis
- Java 17+
- Docker (recommandé pour Consul)
- MySQL

### 2. Lancement de Consul
Utilisez Docker pour démarrer rapidement une instance Consul :
```bash
docker run -d -p 8500:8500 -p 8600:8600/udp --name consul-service consul
```
Accédez à l'interface via [http://localhost:8500](http://localhost:8500)

### 3. Configuration de la Base de Données
Créez les bases de données nécessaires dans MySQL (par exemple `db_car`).

### 4. Compilation et Exécution
Dans chaque répertoire de module (`car`, `gateway`) :
```bash
mvn clean install
mvn spring-boot:run
```

---

## 📂 Structure du Projet
```text
tp23/
├── car/             # Microservice de gestion des voitures
├── gateway/         # API Gateway configurée avec Consul
├── server_eureka/   # Ancien serveur de découverte (Optionnel)
└── README.md        # Documentation
```

---

## 👨‍💻 Auteur
**Olaya Layadi**
*Expert en Architecture Microservices*

---
✨ *Projet réalisé dans le cadre du TP-23 - Migration d'Infrastructure.*
