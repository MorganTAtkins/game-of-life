// Example Pipeline: Deploy to Elastic Beanstalk
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "/usr/bin/mvn install"

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "/usr/bin/mvn clean verify"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
