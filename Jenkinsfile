pipeline {
  agent any
  nodejs(nodeJSInstallationName: 'node:8.2.1') {
    stages {
      stage('Initialize') {
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
      stage('Build') {
        steps {
          sh './gradlew clean test'
        }
      }
    }
  }
}
