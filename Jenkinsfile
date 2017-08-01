pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
    }
    
  }
  stages {
    stage('Initialize') {
      steps {
        sh 'node -v'
      }
    }
  }
}