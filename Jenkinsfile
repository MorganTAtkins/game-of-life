// Example Pipeline: Deploy to Elastic Beanstalk
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                mvn install

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                mvn clean verify
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
