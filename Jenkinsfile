pipeline {
    agent any

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
                javac -d classes src/com/Naukri/*.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                bat 'java -cp classes com.Naukri.Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                bat 'java -cp classes com.Naukri.Profile2'
            }
        }
    }
}
