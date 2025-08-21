pipeline {
    agent any

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17.0.2"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
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
                    "%JAVA_HOME%\\bin\\javac" -d classes *.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                bat '"%JAVA_HOME%\\bin\\java" -cp classes Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                bat '"%JAVA_HOME%\\bin\\java" -cp classes Profile2'
            }
        }
    }
}
