pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/hulkAyeeee/Naukri.git'
            }
        }

        stage('Compile') {
            steps {
                echo "Compiling Java source files..."
                bat '''
                    if not exist target mkdir target
                    dir /s /b src\\main\\java\\*.java > sources.txt
                    javac -d target @sources.txt
                '''
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Tests..."
                bat '''
                    cd target
                    java com.Naukri.YourMainClass
                '''
            }
        }

        stage('Report') {
            steps {
                echo "Build finished. (You can later add reports here)"
            }
        }
    }
}
