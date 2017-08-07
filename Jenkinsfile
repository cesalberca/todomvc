#!groovy

pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        lock('webapp') {
          nodejs(nodeJSInstallationName: 'node:8.2.0') {
            sh 'echo $PATH'
            sh 'npm -v'
            sh 'node -v'

            dir('src/webapp') {
              sh 'npm install'
              sh 'nohup npm start &> todomvc.out &'
            }
          }
        }
      }
    }
    stage('Test') {
      steps {
        sh './gradlew clean test'
      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}