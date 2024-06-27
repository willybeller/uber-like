# uber-like
Evaluation du module Architecture Distribué du CDAN SOPRA B3 à l'IPI

## Table des Matières
1. [Introduction](#introduction)
2. [Technologies Utilisées](#technologies-utilisées)
3. [Architecture du Projet](#architecture-du-projet)
4. [Répertoires et Fichiers](#répertoires-et-fichiers)
5. [Requêtes API](#requêtes-api)
6. [Lien GitHub du projet](#github)
## Introduction
Ce document technique décrit la structure et les composants de l'application de gestion de transport, de style Uber, développée en Java avec le framework Spring Boot et utilisant une base de données MySQL.

## Technologies Utilisées
- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- MySQL (instance  "bdd-cdan-sopra-wbr" sur AWS : 34.245.224.113)
- Maven
- Postman (pour les tests d'API)
- Déployé sur l'instance "apache-cdan-wbr" sur AWS (3.253.100.181)

## Architecture du Projet
Le projet suit une architecture standard MVC (Modèle-Vue-Contrôleur) avec les composants principaux suivants :
- Modèle : Entités représentant les tables de la base de données.
- Vue : Points de terminaison REST exposés via les contrôleurs.
- Contrôleur : Gère les requêtes HTTP et les délègue aux services.
- Service : Contient la logique métier de l'application.

## Répertoires et Fichiers

**Structure du Projet :**
```
evalUber/
├── src/
│   ├── main/
│   │   ├── java/ipi/willy/evaluber/
│   │   │   ├── EvalUberApplication.java
│   │   │   ├── controller/
│   │   │   │   ├── ChauffeurController.java
│   │   │   │   ├── UserController.java
│   │   │   │   ├── RideController.java
│   │   │   ├── model/
│   │   │   │   ├── Chauffeur.java
│   │   │   │   ├── User.java
│   │   │   │   ├── Ride.java
│   │   │   ├── repository/
│   │   │   │   ├── ChauffeurRepository.java
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── RideRepository.java
│   │   │   ├── service/
│   │   │   │   ├── ChauffeurService.java
│   │   │   │   ├── UserService.java
│   │   │   │   ├── RideService.java
│   ├── resources/
│   │   ├── application.properties
```

## Requêtes API
URL : http://3.253.100.181:8080/evalUberWBR

### **Utilisateurs**
- **Créer un utilisateur (Client):**
  - **URL:** `POST /users`
  - **Body:**
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "dateOfBirth": "1990-01-01"
    }
    ```

- **Obtenir tous les utilisateurs:**
  - **URL:** `GET /users`

- **Obtenir un utilisateur par ID:**
  - **URL:** `GET /users/{id}`

- **Supprimer un utilisateur par ID:**
  - **URL:** `DELETE /users/{id}`

### **Chauffeurs**
- **Créer un chauffeur:**
  - **URL:** `POST /chauffeurs`
  - **Body:**
    ```json
    {
      "firstName": "Jane",
      "lastName": "Doe",
      "dateOfBirth": "1985-05-15",
      "vehicleType": "voiture" // ou "moto"
    }
    ```

- **Obtenir tous les chauffeurs:**
  - **URL:** `GET /chauffeurs`

- **Obtenir un chauffeur par ID:**
  - **URL:** `GET /chauffeurs/{id}`

- **Supprimer un chauffeur par ID:**
  - **URL:** `DELETE /chauffeurs/{id}`

- **Compter les chauffeurs par type de véhicule:**
  - **URL:** `GET /chauffeurs/count/{vehicleType}`

### **Courses**
- **Créer une course:**
  - **URL:** `POST /rides`
  - **Body:**
    ```json
    {
      "client": {
        "id": 1
      },
      "chauffeur": {
        "id": 2
      },
      "rideDate": "2024-06-27",
      "duration": 30,
      "distance": 15.5
    }
    ```

- **Obtenir toutes les courses:**
  - **URL:** `GET /rides`

- **Compter les courses d'un client:**
  - **URL:** `GET /rides/count/{clientId}`

- **Obtenir la distance totale parcourue par un client:**
  - **URL:** `GET /rides/distance/{clientId}`

- **Obtenir les statistiques d'un client:**
  - **URL:** `GET /rides/statistics/{clientId}`
 
 
## GitHub
https://github.com/willybeller/uber-like
