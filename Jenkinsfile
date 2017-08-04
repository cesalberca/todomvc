#!groovy

pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        nodejs(nodeJSInstallationName: 'node:8.2.0') {
          sh 'echo $PATH'
          sh 'npm -v'
          sh 'node -v'

          dir('src/webapp') {
            sh 'npm install'
            sh 'nohup npm start &> todomvc.out &'
            
            script{
              withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                sh "nohup java -jar test-0.0.1-SNAPSHOT.war &"
              }
            }
          }

          sh './gradlew clean test'
        }
      }
    }
    stage('Clean up') {
      steps {
        deleteDir()
      }
    }
  }
}