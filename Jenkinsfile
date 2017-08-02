pipeline {
  agent none
  stages {
    stage('Initialize') {
      agent {
        label 'node-server'
      }
      nodejs(nodeJSInstallationName: 'node:8.2.1') {
        steps {
          sh 'echo $PATH'
          sh 'npm -v'
          sh 'node -v'
          
          dir('src/webapp') {
            sh 'ls'
            sh 'npm install'
            sh 'npm start'
          }
        }
      }
    }
    stage('Test') {
      agent {
        label 'selenium-test-server'
      }
      steps {
        echo 'hi'
      }
    }
  }
}
