# 📱 LAB 15 — SQLite et Android : Gestion des étudiants

## 🎯 Objectif

Ce laboratoire a pour but de développer une application Android permettant de gérer une liste d’étudiants en utilisant une base de données locale SQLite.

L’application permet :

* d’ajouter un étudiant
* de rechercher un étudiant par ID
* de supprimer un étudiant
* d’afficher la liste des étudiants avec possibilité de modification et suppression

---

## 🧱 Architecture du projet

Le projet est structuré en plusieurs couches :

### 📦 `projet.fst.ma.app.classes`

Contient les classes métier :

* `Etudiant.java` → représente un étudiant (id, nom, prénom)

---

### 📦 `projet.fst.ma.app.util`

Contient la gestion de la base de données :

* `MySQLiteHelper.java` → création et gestion de la base SQLite

---

### 📦 `projet.fst.ma.app.service`

Contient la logique métier (CRUD) :

* `EtudiantService.java`

  * insertion
  * recherche
  * suppression
  * modification
  * affichage de la liste

---

### 📦 `projet.fst.ma.app`

Contient les activités :

* `MainActivity.java` → interface principale
* `ListEtudiantActivity.java` → affichage avec RecyclerView

---

## 🗄️ Base de données SQLite

* Nom : `gestion_etudiants.db`
* Table : `etudiant`

### Structure :

| Champ  | Type    | Description                   |
| ------ | ------- | ----------------------------- |
| id     | INTEGER | clé primaire auto-incrémentée |
| nom    | TEXT    | nom de l’étudiant             |
| prenom | TEXT    | prénom de l’étudiant          |

---

## 🔧 Fonctionnalités principales

### ✔ Ajouter un étudiant

* saisie du nom et prénom
* insertion dans SQLite

### ✔ Rechercher un étudiant

* saisie de l’ID
* affichage du résultat

### ✔ Supprimer un étudiant

* suppression via ID

### ✔ Afficher la liste

* utilisation de `RecyclerView`
* affichage dynamique

### ✔ Modifier un étudiant

* modification via une boîte de dialogue
* mise à jour en base de données

---

## 🧪 Test (Logcat)

Un test a été réalisé dans `MainActivity` pour vérifier :

* insertion
* lecture
* suppression

Les résultats sont visibles dans **Logcat**.

---

## 🖥️ Interface utilisateur

### MainActivity :

* champs Nom / Prénom
* bouton Ajouter
* champ ID
* boutons Chercher / Supprimer
* bouton Voir la liste

### ListEtudiantActivity :

* RecyclerView
* boutons Modifier / Supprimer

---

## 🛠️ Technologies utilisées

* Java
* Android SDK
* SQLite
* RecyclerView

---

## ⚠️ Difficultés rencontrées

* gestion des erreurs AndroidX (ActionBarActivity obsolète)
* configuration des layouts XML
* liaison RecyclerView + Adapter
* gestion des IDs dans SQLite

---

## ✅ Résultat

Application fonctionnelle permettant :

* gestion complète CRUD
* interface moderne
* persistance des données locale


https://github.com/user-attachments/assets/68b33c9f-87d2-4459-9875-199dce15de60


---

## 🚀 Améliorations possibles

* ajout d’un tri ou recherche avancée
* ajout d’images étudiants
* utilisation de Room Database
* amélioration UI avec Material Design

---

## 👨‍💻 Auteur
Nom:Ouirouane Hiba
Projet réalisé dans le cadre du module :
**Programmation Mobile : Android avec Java**

---
