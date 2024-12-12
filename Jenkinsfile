pipeline {
    agent any
    tools {
        jdk 'JDK17'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test'
            }
            post {
                success {
                    echo 'All tests passed!'
                }
                failure {
                    echo 'Some tests failed!'
                }
            }
        }
        stage('Collect Test Results') {
            steps {
                echo 'Collecting test results...'
                junit 'build/test-results/test/*.xml' // Укажите путь к результатам тестов
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
            }
        }
    }
   post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
