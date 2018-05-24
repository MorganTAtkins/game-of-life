// Example Pipeline: Deploy to Elastic Beanstalk

@Library('jenkins-pipeline-library') _

pipeline {
  agent any
  environment {
    github_api_url="${env.GITHUB_API_URL}"
    github_repo_https="${env.GIT_URL}"
    github_org="${env.GIT_URL.tokenize('/')[2]}"
    github_repo="${env.GIT_URL.tokenize('/')[3]}"
    version="${env.GIT_COMMIT}"
  }
  stages {
    stage('Checkout SCM') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        mvn install
      }
    }
    stage('test') {
      steps {
        mvn clean verify
      }
    }
    stage('Deploy to Development'){
      environment {
        environment="development"
      }
      when {
        beforeAgent true
        allOf {
          branch 'development'
        }
      }
      steps {
        deployToDev()
      }
    }
    stage('Deploy to Staging'){
      environment {
        environment="staging"
      }
      when {
        beforeAgent true
        allOf {
          branch 'release/*'
        }
      }
      steps {
        deployToEB()
      }
    }
    stage('Check Production deploy') {
      when {
        beforeAgent true
        allOf {
          branch 'master'
        }
      }
      environment {
        environment="Production"
      }
      steps {
        script {
          env.DEPLOY_PROD = input message: 'User input required', parameters: [choice(name: 'Deploy to Prod?', choices: 'no\nyes', description: 'Choose "yes" if you want to deploy this build', submitter: 'admin')]
        }
        if (env.DEPLOY_PROD) {
          deployToProd()
        }
      }
    }
  }
}
