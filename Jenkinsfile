pipeline {
    agent {
        docker {
            image 'maven:3.9.9' // Official Maven image with Maven 3.9.9
            args '-v $HOME/.m2:/root/.m2' // Mount local Maven repo to avoid re-downloading dependencies
        }
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile package' // Use 'sh' instead of 'bat' since we're in a Linux-based Docker container
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
    }
}