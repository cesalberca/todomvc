pipeline {
  agent any
  node {
    env.NODEJS_HOME = "${tool 'Node 6.x'}"
    env.PATH="${env.NODEJS_HOME}:${env.PATH}"
    sh 'npm -v'
  }
  stages {
    stage('Initialize') {
      steps {
        nodejs(nodeJSInstallationName: 'node:8.2.1') {
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
    stage('Build') {
      steps {
        sh './gradlew clean test'
      }
    }
  }
}
