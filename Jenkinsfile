pipeline {
    agent any

    triggers {
        // Schedule build at 7 AM, 9 AM, 12 PM, 3 PM IST
        // Jenkins cron is in UTC, IST = UTC+5:30
        // So 7 AM IST = 1:30 AM UTC → nearest hour = 1, etc.
        cron('30 1,3,6,9 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Compile') {
    steps {
        script {
            bat '''
                if not exist out mkdir out
                dir /B /S Selenium2025\\src\\*.java > sources.txt
                javac -d out @sources.txt
            '''
        }
    }
}


        stage('Run Profile1') {
            steps {
                script {
                    bat 'java -cp out com.Naukri.Profile1'
                }
            }
        }

        stage('Run Profile2') {
            steps {
                script {
                    bat 'java -cp out com.Naukri.Profile2'
                }
            }
        }

        stage('Report') {
            steps {
                echo "✅ Both Profile1 and Profile2 executed successfully!"
            }
        }
    }
}
