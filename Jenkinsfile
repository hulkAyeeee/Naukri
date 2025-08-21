pipeline {
    agent any

    triggers {
        // Run at 7AM, 9AM, 12PM, 3PM IST daily
        cron('0 1,3,6,9 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Compile') {
            steps {
                echo "Compiling Java source files..."
                bat 'javac -d target src\\main\\java\\**\\*.java src\\test\\java\\**\\*.java'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Selenium tests..."
                bat 'java -cp target org.testng.TestNG testng.xml'
            }
        }

        stage('Report') {
            steps {
                echo "Archiving results..."
                junit '**/test-output/*.xml'
            }
        }
    }
}
