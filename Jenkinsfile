pipeline {
    agent any
    stages {
        stage('Set Up') {
            steps {
                bat 'emulator -avd MyEmulator -no-snapshot-load'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
            post {
                always {
                    allure includeProperties: 
                        false, 
                        jdk: '', 
                        results: [[path: 'target/allure-results']]
                }
            }
        }
    }
} 
