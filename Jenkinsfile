pipeline {
  agent {
    docker {
      image 'node:8'
    }
    
  }
  stages {
    stage('Initialize') {
      steps {
        sh '''node -v
npm -v'''
      }
    }
    stage('Build') {
      steps {
        sh '''cd ./src/webapp/
npm install
npm start'''
      }
    }
  }
}