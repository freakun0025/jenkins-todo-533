pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
        // Your Image Name: username/repo:tag
        IMAGE_NAME = "freakun/todo-app:533" 
    }

    stages {
        stage('Checkout') {
            steps {
                // Jenkins automatically checks out code from SCM defined in configuration
                checkout scm
            }
        }
        
        stage('Build Code') {
            steps {
                echo 'Building the application environment...'
                // Since we are in a basic Jenkins container, we skip pip install 
                // and rely on the Docker build step for the actual app environment.
                echo 'Build Setup Complete.'
            }
        }

        stage('Test Code') {
            steps {
                echo 'Running Tests...'
                // For this lab, we will verify the files exist as a "Test"
                sh 'ls -l app.py test_app.py'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker Image...'
                    sh "docker build -t $IMAGE_NAME ."
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    echo 'Pushing to DockerHub...'
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh "docker push $IMAGE_NAME"
                }
            }
        }
    }
}