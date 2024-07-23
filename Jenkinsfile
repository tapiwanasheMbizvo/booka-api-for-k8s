pipeline {
    agent any

    environment {
        GITHUB_REPOSITORY = 'https://github.com/tapiwanasheMbizvo/booka-api-for-k8s.git'
        DOCKER_HUB_CREDENTIALS = credentials('dockerhubcreds')
        BUILD_VERSION = "${env.BUILD_NUMBER}"
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
            sh "docker build -t tapiwanashembizvo/book-api:${BUILD_VERSION}"
            }
        }
        stage('Login'){
            steps{
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('Push'){

        steps{
            sh "docker push tapiwanashembizvo/book-api:${BUILD_VERSION}"
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