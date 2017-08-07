#!groovy

pipeline {
  agent any

  environment {
    BUILD_ID = 'dontKillMe'
  }

  stages {
    stage('Initialize') {
      steps {
        nodejs(nodeJSInstallationName: 'node:8.2.0') {
          sh 'echo $PATH'
          sh 'npm -v'
          sh 'node -v'

          dir('src/webapp') {
            sh 'npm install'
            sh 'chmod +x build.sh'
            sh 'env'
            sh './build.sh &'
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