pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat "${tool 'Maven-3.9.9'}\\bin\\mvn clean compile package"
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}