pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile package'

            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn clean compile package'

            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
    }
}
