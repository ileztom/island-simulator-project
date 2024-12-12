pipeline {
    agent any

    tools {
        // Укажите версию Java, которую вы хотите использовать
        jdk 'JDK17'
    }

    stages {
        stage('Build') {
            steps {
                // Сборка проекта с помощью Gradle
                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                // Запуск тестов
                sh './gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                // Шаги для развертывания (если требуется)
                echo 'Deploying application...'
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}