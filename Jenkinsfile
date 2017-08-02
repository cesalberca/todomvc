pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo '$PATH'
        sh 'npm -v'
        sh 'node -v'
      }
    }
    stage('Build') {
      steps {
        sh './gradlew test'
      }
    }
  }
}
