pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                bat 'mvn test'
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
