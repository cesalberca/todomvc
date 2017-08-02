pipeline {
  stages {
    stage('Initialize') {
      steps {
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
