pipeline {
    agent {
        docker {
            image 'maven'
            args  '-v /Users/zhangyin/.m2/repository:/usr/share/maven/ref/repository -v /Users/zhangyin/.m2:/root/.m2'
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