#!/usr/bin/env groovy

pipeline {
  agent any

  stages {
    stage('Test') {
      steps {
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