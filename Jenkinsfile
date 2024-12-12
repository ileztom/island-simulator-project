pipeline {
    agent any

    tools {
        jdk 'JDK17'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'javac -d build/classes src/main/java/*.java'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'javac -d build/test-classes -cp build/classes src/test/java/*.java'
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
                junit 'build/test-results/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
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
