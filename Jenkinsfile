pipeline {
    agent any

    tools {
        jdk 'JDK11' // Укажите версию Java, которую вы хотите использовать
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew build' // Сборка проекта с помощью Gradle
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test' // Запуск тестов
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...' // Шаги для развертывания (если требуется)
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
