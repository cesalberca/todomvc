#!/usr/bin/env groovy

pipeline {
  agent any

  stages {
    stage('Test') {
      steps {
        sh './gradlew clean build -P env=prod'
      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}