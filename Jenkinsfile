// Example Pipeline: Deploy to Elastic Beanstalk
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                /usr/bin/mvn install

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                /usr/bin/mvn clean verify
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
