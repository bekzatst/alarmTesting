pipeline {
    agent any
    stages {
        stage('Set Up') {
            steps {
                script {
                    powershell '''
                        Start-Job -ScriptBlock {emulator -avd MyEmulator -no-snapshot-load}
                        Start-Sleep -Seconds 10
                        do { $bootStatus = adb -s emulator-5554 shell getprop sys.boot_completed; Start-Sleep -Seconds 1 } while ($bootStatus -ne "1")
                        adb devices
                        adb install -r src/test/resources/apps/base.apk
                        Start-Job -ScriptBlock {cmd /c "appium"}
                        mvn clean test
                        adb emu kill
                    '''
                }
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
