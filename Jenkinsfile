#!groovy

pipeline {
  agent any

  environment {
    BUILD_ID = 'dontKillMe'
  }

  stages {
    stage('Initialize') {
      steps {
        parallel(
          launch: {
            sh './gradlew launchWeb'
          },
          test: {
            sh './gradlew clean test'
          }
        )

      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}