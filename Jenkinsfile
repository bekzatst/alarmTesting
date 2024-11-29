pipeline {
    agent any
    stages {
        stage('Set Up') {
            parallel {
                stage('Start Emulator') {
                    steps {
                        bat 'emulator -avd MyEmulator -no-snapshot-load'
                    }
                }
                stage('Start Appium') {
                    steps {
                        bat 'appium'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
    post {
        always {
            script {
                bat 'mvnw.cmd allure:report'
                archiveArtifacts artifacts: '**/target/allure-results/**', allowEmptyArchive: false

                allure([
                    results: [[path: 'target/allure-results']],
                    reportBuildPolicy: 'ALWAYS'
                ])
            }
        }
    }
} 
