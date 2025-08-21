pipeline {
    agent any

    tools {
        // "jdk11" must match the name you configure in Jenkins → Global Tool Configuration → JDK installations
        jdk 'jdk11'
    }

    triggers {
        // Runs daily at 7, 9, 12, and 15 IST
        cron('0 7,9,12,15 * * *')
    }

    environment {
        JAVA_HOME = tool 'jdk11'     // ensure JAVA_HOME points to Jenkins JDK
        PATH = "${JAVA_HOME}/bin:${env.PATH}" // prepend Java bin to PATH
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Build') {
            steps {
                echo "Compiling Java files with Jenkins JDK..."
                bat '''
                    if not exist classes mkdir classes
                    "%JAVA_HOME%\\bin\\javac" -d classes Selenium2025\\src\\com\\Naukri\\*.java
                '''
            }
        }

        stage('Run Profile1') {
            steps {
                echo "Running Profile1..."
                bat '"%JAVA_HOME%\\bin\\java" -cp classes com.Naukri.Profile1'
            }
        }

        stage('Run Profile2') {
            steps {
                echo "Running Profile2..."
                bat '"%JAVA_HOME%\\bin\\java" -cp classes com.Naukri.Profile2'
            }
        }
    }
}
