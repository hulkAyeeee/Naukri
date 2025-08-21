pipeline {
    agent any

    tools {
        jdk 'jdk-21'   // Uses the JDK you configured in Jenkins
    }

    triggers {
        cron('0 1,3,6,9 * * *') // 7AM, 9AM, 12PM, 3PM IST
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Build') {
            steps {
                bat '''
                if not exist classes mkdir classes
                javac -d classes *.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                bat 'java -cp classes Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                bat 'java -cp classes Profile2'
            }
        }
    }
}
