pipeline {
    agent any
    
    tools {
        maven 'maven3'
    }
    
    stages{
        stage('Git checkout') {
            steps{
                git credentialsId: 'git_credentials',
                url: 'https://github.com/Angelo1625/triangle-app.git',
                branch: 'main'
            }
        }
        stage('Build the application') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Unit test execution') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Build the docker image') {
            steps {
                bat 'docker build -t nirinarivelo/triangle-app:1.0.0 .'
            }
        }
        stage('Push DockerHub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhubpass',
                                        variable: 'dockerHubPass')]) {
                    bat 'docker login -u nirinarivelo -p %dockerHubPass%'
                    bat 'docker push nirinarivelo/triangle-app:1.0.0'
                }

            }
        }
    }
}