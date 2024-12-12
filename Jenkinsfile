pipeline {
    agent any

    tools {
        jdk 'JDK17' // Укажите имя, которое вы задали в настройках Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                // Используйте скрипт для компиляции всех файлов
                bat '''
                for %%f in (src/main/java/*.java) do (
                    javac -d build/classes %%f
                )
                '''
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Пример запуска тестов (если тесты написаны на JUnit)
                bat 'java -cp build/classes org.junit.runner.JUnitCore TestClass'
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
                junit 'build/test-results/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Пример развертывания
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
