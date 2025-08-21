pipeline {
    agent any

    tools {
        // Make sure these match your Jenkins configuration
        jdk 'JDK17'   // JDK you installed in Jenkins
        git 'Default' // Git installation configured in Jenkins
    }

    environment {
        // Add any environment variables if needed
        CHROME_DRIVER_PATH = 'D:\\Classes 2025\\ChromeDriver Jenkins Check\\chrome-win32\\chrome.exe'

    }

    stages {
        stage('Checkout SCM') {
            steps {
                git branch: 'main', url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Build') {
            steps {
                bat '''
                    if not exist classes mkdir classes
                    javac -cp "lib/*" -d classes *.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                bat """
                    set PATH=%CHROME_DRIVER_PATH%;%PATH%
                    java -cp "lib/*;classes" Profile1
                """
            }
        }

        stage('Run Profile2') {
            steps {
                bat """
                    set PATH=%CHROME_DRIVER_PATH%;%PATH%
                    java -cp "lib/*;classes" Profile2
                """
            }
        }
    }

    post {
        failure {
            echo "Build failed. Check errors above."
        }
        success {
            echo "Build and tests completed successfully!"
        }
    }
}
