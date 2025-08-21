pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17.0.2'
        PATH = "${JAVA_HOME}\\bin;${PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Build') {
            steps {
                bat '''
                if not exist classes mkdir classes
                for %%f in (src\\com\\Naukri\\*.java) do (
                    javac -d classes %%f
                )
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
