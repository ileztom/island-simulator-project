pipeline {
    agent any

    // Инструменты, которые будут использоваться
    tools {
        jdk 'JDK17' // Укажите версию JDK, которую вы настроили в Jenkins
    }

    // Переменные окружения
    environment {
        // Пример переменных окружения (если требуется)
        GRADLE_HOME = tool 'Gradle' // Укажите путь к Gradle, если используется
    }

    // Этапы конвейера
    stages {
        // Этап 1: Сборка проекта
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh './gradlew clean build' // Команда для сборки проекта с помощью Gradle
            }
        }

        // Этап 2: Запуск тестов
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test' // Команда для запуска тестов
            }
            post {
                // Пост-действия после тестов
                success {
                    echo 'All tests passed!'
                }
                failure {
                    echo 'Some tests failed!'
                }
            }
        }

        // Этап 3: Развертывание (опционально)
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Здесь можно добавить команды для развертывания
                // Например, sh './deploy.sh'
            }
        }
    }

    // Пост-действия после выполнения всех этапов
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
