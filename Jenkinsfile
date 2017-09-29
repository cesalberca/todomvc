#!/usr/bin/env groovy

pipeline {
  agent any

  stages {
    stage('Test') {
      steps {
        sh 'ls'
        sh './gradlew npmInstall'
        sh 'node -v'
        sh './gradlew -P env="prod" clean test'
      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}