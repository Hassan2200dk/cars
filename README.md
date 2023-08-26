# cars
orm opgave

The idea with, and reasons for why to use, a ORM-mapper?

Den primære tanke bag at bruge en ORM-mapper 
er en mere effektiv måde at interagere med en database ved hjælp af objektorienterede programmeringskoncepter, hvor databasetabeller er repræsenteret som klasser, og rækker i disse tabeller er repræsenteret som objekter.

The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected?

JPA: Definerer standardsættet af annoteringer og grænseflader til objektrelationel kortlægning.

Dvale: Implementerer JPA-specifikationen og giver yderligere funktioner ud over JPA.

Spring Data JPA: Bygger på JPA og Hibernate og giver en mere strømlinet måde at arbejde med databaser på i Spring-applikationer på højere niveau.

How to create simple Java entities and map them to a database via the Spring Data API?

1. Opret en Java Entity Class:
2. Opsæt databasekonfiguration i application.properties og brug miljøvariabler:
3. Definer en lagergrænseflade, der udvider JpaRepository og er knyttet til din enhed. Spring Data JPA giver mange indbyggede metoder til almindelige databaseoperationer.
4. Brug lageret i en udviklerdataklasse og brug lageret til at gemme de tilføjede objekter.






