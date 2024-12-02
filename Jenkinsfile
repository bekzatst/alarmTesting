pipeline {
    agent any
    stages {
        stage('Set Up') {
            steps {
                bat 'adb wait-for-device'
                bat 'adb install -r src/test/resources/apps/base.apk'
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
