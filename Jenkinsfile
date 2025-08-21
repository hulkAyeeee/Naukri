pipeline {
    agent any

    triggers {
        cron('0 1,3,6,9 * * *')  // Runs at 7 AM, 9 AM, 12 PM, 3 PM IST (adjusted to UTC+0 = IST-5:30)
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Compile') {
            steps {
                echo "Compiling Java source files..."
                bat '''
                    if not exist target mkdir target
                    dir /s /b src\\main\\java\\*.java > sources.txt
                    javac -d target @sources.txt
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                echo "Running Profile1..."
                bat '''
                    cd target
                    java Profile1
                '''
            }
        }

        stage('Run Profile2') {
            steps {
                echo "Running Profile2..."
                bat '''
                    cd target
                    java Profile2
                '''
            }
        }

        stage('Report') {
            steps {
                echo "Build completed successfully!"
            }
        }
    }
}
