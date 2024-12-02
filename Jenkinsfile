pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                bat 'mvn test"'
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
