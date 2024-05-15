# Event Manager
This is a web-based project called Event Management System. It allows users to view upcoming events, register for events, and manage their own profile.

## Dependencies
* Java 21
* Maven
* Docker


## Features
1. View upcoming events
1. Register for events
1. Manage user profile
1. View event details
1. Ticket management

## Installation
1. Clone the repository
   ```bash
   git clone https://github.com/sembekov/event-manager.git
   cd event-manager
   ```
2. Make sure that Docker is running and build the container
   ```bash
   docker-compose build
   ```
3. Start the Docker container
   ```bash
   docker-compose up
   ```
4. The service is accessible at 'locahost:8080'


## Technologies used
* Spring Framework
* PostgreSQL
* Docker


## Notes
If you experience issues with Docker and PostgreSQL connections, ensure ports 5432 (PostgreSQL) and 8080 (Spring Boot) are open and not occupied by other processes.
Ensure any SQL initialization scripts are correct if you're using them to pre-populate the database. I'm currently working on enhancing the security and updating SQL
database. Expect new updates soon.