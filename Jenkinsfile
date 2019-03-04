pipeline {
    agent {
        docker {
            image 'maven'
            args  '-v /Users/zhangyin/.m2/repository:/usr/share/maven/ref/repository'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn install'
            }
        }
    }
}