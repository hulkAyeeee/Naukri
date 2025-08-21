pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17.0.2'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    triggers {
        cron('0 7,9,12,15 * * *')
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
                    "%JAVA_HOME%\\bin\\javac" -d classes Selenium2025\\src\\com\\Naukri\\*.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                bat '"%JAVA_HOME%\\bin\\java" -cp classes com.Naukri.Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                bat '"%JAVA_HOME%\\bin\\java" -cp classes com.Naukri.Profile2'
            }
        }
    }
}
