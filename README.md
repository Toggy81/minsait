# Project Name: PRUEBA MINSAIT

## Overview
These are the steps to upload the application to Docker.

## Prerequisites
Make sure you have the following installed on your machine:
- Docker
- Docker Compose

## Getting Started
1. Unzip the project to your local machine.


2. Navigate to the directory containing your Docker Compose file.
   ```bash
   cd path/to/docker-compose-directory
   ```

3. Run the following Docker Compose command to start the project containers in the background (detached mode):
   ```bash
   docker-compose -f path/to/docker-compose.yaml -p project-name up -d
   ```
    - `-f`: Specifies the path to the Docker Compose YAML file.
    - `-p`: Specifies a project name. Replace `project-name` with your desired project name.


4. Verify that the containers are running:
   ```bash
   docker ps
   ```

## Access Swagger OpenAPI
To access the swagger use the following url on your browser:
   ```bash
   http://localhost:9090/swagger-ui/index.html
   ```

## Stopping the Project
To stop the project and remove the containers, run the following command:
   ```bash
   docker-compose -f path/to/docker-compose.yaml -p project-name down
   ```
