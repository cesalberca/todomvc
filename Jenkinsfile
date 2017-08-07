#!/usr/bin/env groovy

pipeline {
  agent any

  stages {
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