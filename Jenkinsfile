#!groovy

pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        nodejs(nodeJSInstallationName: 'node:8.2.0') {
          sh 'echo $PATH'
          sh 'npm -v'
          sh 'node -v'

          dir('src/webapp') {
            sh 'npm install'
            
            script{
              withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                sh 'nohup npm start &> todomvc.out &'
              }
            }
          }

          sh './gradlew clean test'
        }
      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}