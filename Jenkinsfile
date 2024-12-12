pipeline {
    agent any

    tools {
        jdk 'JDK17' // Укажите имя, которое вы задали в настройках Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                // Используйте Gradle Wrapper для сборки
                bat './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Используйте Gradle Wrapper для запуска тестов
                bat './gradlew test'
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
                // Собирайте результаты тестов в формате JUnit XML
                junit 'build/test-results/test/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Пример развертывания (например, копирование файлов)
                bat 'copy build/libs/*.jar C:\\path\\to\\deploy'
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
