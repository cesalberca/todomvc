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
            sh 'npm install'
            sh 'BUILD_ID=dontKillMe nohup npm start &'
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