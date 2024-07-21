pipeline {
    agent any

    environment {
        GITHUB_REPOSITORY = 'https://github.com/tapiwanasheMbizvo/booka-api-for-k8s.git'
        DOCKER_IMAGE_NAME = 'book-api-docker'
        DOCKER_HUB_USERNAME = 'tapiwanashembizvo'
        DOCKER_HUB_PASSWORD = credentials('dockerHubCreds')
        AWS_EC2_INSTANCE_ID = 'i-043dca8522150d5ca'
        ECR_REPOSITORY_URI= '211125663777.dkr.ecr.af-south-1.amazonaws.com/bookapi-devops'
        AWS_ECR_CREDS
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

/* stage('Push to AWS ECR') {
    steps {
       docker.withRegistry(ECR_REPOSITORY_URI, "ecr:af-south-1:credential-id") {
         docker.image(DOCKER_IMAGE_NAME).push()
       }
    }
} */

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