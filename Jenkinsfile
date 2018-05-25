// Example Pipeline: Deploy to Elastic Beanstalk
pipeline {
    agent any
    environment {
        SNOW_AUTH = credentials('snow_auth')
        SNOW_URL = "${env.SNOW_URL}"
    }
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
            post {
                always {
                    echo "RESULT: ${currentBuild.result}"
                }
                failure {
                    sh 'echo failed'
                }
                changed {
                    sh 'echo changed'
                }
            }
            steps {
                echo "RESULT:" ${currentBuild.result}
                script {
                    if (${currentBuild.result} == 'Success' ) {
                        sh "curl -v -H \"Accept: application/json\" -H \"Content-Type: application/json\" -X POST --data '{\"short_description\":\"Test incident creation through REST\", \"comments\":\"These are my comments\"}' -u \"$SNOW_AUTH\" \"https://$SNOW_URL.service-now.com/api/now/v1/table/incident\""
                    }
                }
                mail body: 'project build successful',
                     from: 'xxxx@yyyyy.com',
                     replyTo: 'xxxx@yyyy.com',
                     subject: 'project build successful',
                     to: 'morgantatkins@gmail.com'
            }
        }
    }
}