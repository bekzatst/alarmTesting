pipeline {
    agent any
    stages {
        stage('Set Up') {
            steps {
                powershell 'avdmanager list avd'
                powershell 'avdmanager create avd -n testEmu -k "system-images;android-33;google_apis;x86_64"'
                powershell 'Start-Job -ScriptBlock {emulator -avd testEmu -gpu host -no-window -no-snapshot-load}'
                powershell 'do { $bootStatus = adb -s emulator-5554 shell getprop sys.boot_completed; Start-Sleep -Seconds 1 } while ($bootStatus -ne "1")'
            }
        }

        stage('Install app') {
            steps {
                powershell 'adb install -r src/test/resources/apps/base.apk'
            }
        }

        stage('Test') {
            steps {
                powershell 'mvn clean test'
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
