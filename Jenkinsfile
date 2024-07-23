pipeline {
    agent any

    environment {
        GITHUB_REPOSITORY = 'https://github.com/tapiwanasheMbizvo/booka-api-for-k8s.git'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: "${GITHUB_REPOSITORY}", branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Deploy to AWS EC2') {
            steps {
               sh '''
                  sh 'docker compose -f docker-compose-book-api.yml up -d'
                  '''
            }
        }
    }
}