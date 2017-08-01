pipeline {
  agent {
    docker {
      image 'node:8.2.1'
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