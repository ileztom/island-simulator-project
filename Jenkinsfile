pipeline {
    agent any

    tools {
        jdk 'JDK17' // Укажите версию JDK, если она настроена в Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                // Компиляция Java-кода с использованием javac
                bat 'javac -d build/classes src/main/java/*.java'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Компиляция тестов
                bat 'javac -d build/test-classes -cp build/classes src/test/java/*.java'
                // Запуск тестов с использованием JUnit (если тесты написаны на JUnit)
                bat 'java -cp build/classes;build/test-classes org.junit.runner.JUnitCore TestClass'
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
                // Если вы используете JUnit, вы можете собирать результаты тестов
                junit 'build/test-results/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Пример развертывания (например, копирование файлов)
                bat 'copy build/classes/*.class C:\\path\\to\\deploy'
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
