pipeline {
    agent any

    triggers {
        // Schedule build at 7 AM, 9 AM, 12 PM, 3 PM IST
        cron('0 1,3,6,9 * * *')  
        // Note: Jenkins uses UTC by default. IST = UTC+5:30
        // So: 7 AM IST = 1:30 AM UTC → nearest hour = 1, etc.
        // Adjust if needed.
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
                    // Compile all .java files in src directory
                    bat 'javac -d out src/*.java'
                }
            }
        }

        stage('Run Profile1') {
            steps {
                script {
                    bat 'java -cp out Profile1'
                }
            }
        }

        stage('Run Profile2') {
            steps {
                script {
                    bat 'java -cp out Profile2'
                }
            }
        }

        stage('Report') {
            steps {
                echo "Profiles executed successfully!"
            }
        }
    }
}
