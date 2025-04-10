pipeline {
    agent {
        docker {
            image 'maven:3.9.9' // Official Maven image with Maven 3.9.9
            args '-v /c/ProgramData/Jenkins/.jenkins/.m2:/root/.m2' // Mount local Maven repo from Jenkins host
        }
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile package'
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
