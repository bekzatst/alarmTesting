pipeline {
    agent any
    stages {
        stage('Set Up') {
            stage('Test') {
                steps {
                    bat 'start cmd /k "mvn test"'
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
