pipeline {
    agent any
    stages {
        stage('Set Up') {
            steps {
                bat 'start /b appium'
                bat 'start /b emulator -avd MyEmulator -no-snapshot-load'
                bat 'adb wait-for-device'
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
