# Pet project

### Project of collection and interaction with external services

# Target

Show my ability to solve tasks ( in this case, set yourself :) )

# Description

External API service collects information on open APIs, such as currency rates or weather information and send it (REST / Message broker) to the Main service for processing and saving into DB. Main service receives information by REST / Message broker, processes and saves it, and also allows you to interact with the DB through REST endpoints.

# Architecture

[Pet project architecture image](https://disk.yandex.ru/i/2bSS6Ug3QKBqcg)

# For start

1. git clone https://github.com/VorobevOleg/pet.git
2. cd pet
3. mvn clean install
4. docker-compose up -d
