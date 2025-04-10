pipeline {
    agent none
    stages {
        stage('Build') {
            steps {
                script {
                    docker.image('maven:3.9.9').inside("-v C:\\Users\\katar\\.m2:/root/.m2 -v C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\springEProductPipeline:/workspace") {
                        dir('/workspace') {
                            sh 'mvn clean install'
                        }
                    }
                }
            }
        }
    }
    post {
        failure {
            echo 'Build failed!'
        }
    }
}
