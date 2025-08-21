pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17.0.2'
        PATH = "${JAVA_HOME}\\bin;${PATH}"
    }

    stages {
        stage('Build') {
    steps {
        bat '''
        if not exist classes mkdir classes
        javac -cp "lib/*" -d classes *.java
        '''
    }
}


        stage('Build') {
    steps {
        bat '''
        if not exist classes mkdir classes
        javac -cp "lib/*" -d classes src\\com\\Naukri\\*.java
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
