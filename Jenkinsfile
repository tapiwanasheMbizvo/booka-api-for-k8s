pipeline {
    agent any

    environment {
        GITHUB_REPOSITORY = 'https://github.com/tapiwanasheMbizvo/booka-api-for-k8s.git'
        DOCKER_IMAGE_NAME = 'book-api-docker'
        DOCKER_HUB_USERNAME = 'tapiwanashembizvo'
        DOCKER_HUB_PASSWORD = credentials('dockerHubCreds')
        AWS_EC2_INSTANCE_ID = 'i-043dca8522150d5ca'
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

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_NAME} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', usernameVariable: 'DOCKER_HUB_USERNAME', passwordVariable: 'DOCKER_HUB_PASSWORD')]) {
                    sh "docker login -u ${DOCKER_HUB_USERNAME} -p ${DOCKER_HUB_PASSWORD}"
                    sh "docker push ${DOCKER_IMAGE_NAME}"
                }
            }
        }

        stage('Deploy to AWS EC2') {
            steps {
               sh '''
                  aws ec2 start-instances --instance-ids ${AWS_EC2_INSTANCE_ID}
                  aws ec2 wait instance-running --instance-ids ${AWS_EC2_INSTANCE_ID}
                  aws ec2 describe-instances --instance-ids ${AWS_EC2_INSTANCE_ID}
                  docker run -d ${DOCKER_IMAGE_NAME}
                  '''
            }
        }
    }
}