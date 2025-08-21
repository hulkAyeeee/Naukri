pipeline {
    agent any

    tools {
        jdk 'JDK17'   // make sure you installed JDK 17 in Jenkins Global Tool Configuration
    }

    environment {
        JAVA_HOME = "${tool 'JDK17'}"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/hulkAyeeee/Naukri.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat '''
                if not exist classes mkdir classes
                javac -cp "lib/*" -d classes *.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                bat 'java -cp "lib/*;classes" Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                bat 'java -cp "lib/*;classes" Profile2'
            }
        }
    }
}
