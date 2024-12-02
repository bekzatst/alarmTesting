pipeline {
    agent any
    stages {
        stage('Set Up') {
            steps {
                bat 'sdkmanager "system-images;android-33;google_apis;x86_64"'
                bat 'echo no | avdmanager create avd -n testEmulator -k "system-images;android-33;google_apis;x86_64" --force'
                bat 'emulator -avd MyEmulator -no-snapshot-load'
                bat 'adb wait-for-device'
                bat 'adb install src/test/resources/apps/base.apk'
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
