pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        sh 'echo $PATH'
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
