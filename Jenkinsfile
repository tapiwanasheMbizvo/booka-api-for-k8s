pipeline {
    agent any

    environment {
        GITHUB_REPOSITORY = 'https://github.com/tapiwanasheMbizvo/booka-api-for-k8s.git'
        DOCKER_HUB_CREDENTIALS = 'dockerhubcreds'
        BUILD_VERSION = "${env.BUILD_NUMBER}"
        DOCKER_HUB_REGISTRY = 'https://hub.docker.com/repository/docker/tapiwanashembizvo/book-api-backend'
        DOCKER_IMAGE = ''
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

            script{
                DOCKER_IMAGE = docker.build DOCKER_REPO_NAME +":$BUILD_VERSION"
               // DOCKER_IMAGE.push()
            }
          }
        }

        steps ('Push to Docker Hub'){
        steps{
        script{
            docker.withRegistry('', DOCKER_HUB_CREDENTIALS){

            DOCKER_IMAGE.push()
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