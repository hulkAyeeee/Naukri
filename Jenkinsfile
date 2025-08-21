pipeline {
    agent any

    triggers {
        // Runs at 7:00, 9:00, 12:00, 15:00 IST (convert IST to UTC -> -5:30)
        // Jenkins uses server timezone, so adjust if needed
        cron('0 1,3,6,9 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Build') {
            steps {
                echo "Compiling Java files..."
                // Adjust path if needed (Workspace + Selenium2025/src)
                sh '''
                    mkdir -p classes
                    javac -d classes Selenium2025/src/com/Naukri/*.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                echo "Running Profile1..."
                sh 'java -cp classes com.Naukri.Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                echo "Running Profile2..."
                sh 'java -cp classes com.Naukri.Profile2'
            }
        }
    }
}
