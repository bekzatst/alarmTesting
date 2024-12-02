pipeline {
    agent any
    stages {
        stage('Set Up') {
            parallel {
                stage('Start Emulator') {
                    steps {
                        bat 'start cmd /k "emulator -avd MyEmulator -no-snapshot-load"'
                    }
                }
                stage('Start Appium') {
                    steps {
                        bat 'start cmd /k "appium"'
                    }
                }
                stage('Test') {
                    steps {
                        bat 'timeout /t 90'
                        bat 'start cmd /k "mvn test"'
                    }
                }    
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
