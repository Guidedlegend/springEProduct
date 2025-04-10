pipeline {
    agent {
        docker {
            image 'maven:3.9.9'
            args '''
                -v C:/Users/katar/.m2:/root/.m2
                -v C:/ProgramData/Jenkins/.jenkins/workspace/springEProductPipeline:/workspace
                -w /workspace
            '''.trim()
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
    }
}
