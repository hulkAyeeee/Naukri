pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }
        stage('Build') {
            steps {
                bat "mvn clean compile"
            }
        }
        stage('Run Profile1') {
            steps {
                bat "mvn exec:java -Dexec.mainClass=com.Naukri.Profile1"
            }
        }
        stage('Run Profile2') {
            steps {
                bat "mvn exec:java -Dexec.mainClass=com.Naukri.Profile2"
            }
        }
    }
}
