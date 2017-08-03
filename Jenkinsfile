#!groovy

pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        nodejs(nodeJSInstallationName: 'node:8.2.0') {
          sh 'echo $PATH'
          sh 'npm -v'
          sh 'node -v'

          dir('src/webapp') {
            sh 'ls'
            sh 'npm install'
            sh 'nohup npm start &'
          }
        }
      }
    }
    stage('Test') {
      steps {
        sh './gradlew clean test'
      }
    }
  }
}