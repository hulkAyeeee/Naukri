pipeline {
    agent any

    triggers {
        cron('0 1,3,6,9 * * *') // 7 AM, 9 AM, 12 PM, 3 PM IST (adjusted for UTC)
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
                    // Create output folder
                    bat 'if not exist out mkdir out'

                    // Compile both Profile1.java and Profile2.java
                    bat 'javac -d out Profile1.java Profile2.java'
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
                echo "Both profiles executed successfully!"
            }
        }
    }
}
