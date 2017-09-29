#!/usr/bin/env groovy

pipeline {
  agent any

  stages {
    stage('Test') {
      steps {
        sh './gradlew clean build -P env=prod -P hub.url=http://192.168.99.1:4444/wd/hub -P base.url=http://192.168.99.1:3000'
      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}