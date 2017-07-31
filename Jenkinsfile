pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''cd todomvc-e2e
./gradlew clean test'''
      }
    }
  }
}