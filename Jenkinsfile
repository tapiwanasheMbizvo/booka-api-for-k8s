pipeline {
    agent any

    environment {
        GITHUB_REPOSITORY = 'https://github.com/tapiwanasheMbizvo/booka-api-for-k8s.git'
        DOCKER_HUB_CREDENTIALS = 'dockerhubcreds'
        BUILD_VERSION = "${env.BUILD_NUMBER}"
        DOCKER_HUB_REGISTRY = 'https://hub.docker.com/repository/docker/tapiwanashembizvo/book-api-backend'
        DOCKER_IMAGE = ''
        DOCKER_USER_NAME = 'tapiwanashembizvo'
        DOCKER_REPO_NAME = 'book-api-backend'

    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: "${GITHUB_REPOSITORY}", branch: 'main'
            }
        }

        stage('Maaven Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Docker image build'){
            steps{


            sh "docker build -t ${DOCKER_USER_NAME}/${DOCKER_REPO_NAME}:${BUILD_VERSION} ."
            }
        }


       stage('Push Docker Image') {
             steps {
                 script {
                     docker.withRegistry('', DOCKER_HUB_CREDENTIALS) {
                         docker.image("${DOCKER_USER_NAME}/${DOCKER_REPO_NAME}:${env.BUILD_NUMBER}").push()
                     }
                 }
             }
         }


        stage('Deploy') {
            steps {
               sh 'docker compose -f book-api.yml up -d'

            }
        }
    }

    post{
    always{
    sh 'docker logout'
    }
    }
}