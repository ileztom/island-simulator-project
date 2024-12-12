pipeline {
    agent any

    stages {
        stage('Run Application') {
            steps {
                echo 'Running the application...'
                // Пример запуска JAR-файла
                bat 'java -jar path/to/your-application.jar'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Пример запуска тестов (если тесты уже скомпилированы)
                bat 'java -cp path/to/test-classes org.junit.runner.JUnitCore TestClass'
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
                bat 'copy path/to/your-application.jar C:\\path\\to\\deploy'
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
