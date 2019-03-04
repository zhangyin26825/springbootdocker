pipeline {
    agent none
    stages {
        stage('mavenPackage') {
             agent {
                    docker {
                        image 'maven'
                        args  '-v /Users/zhangyin/.m2/repository:/usr/share/maven/ref/repository -v /Users/zhangyin/.m2:/root/.m2'
                    }
                }
             steps {
                sh 'mvn install'
             }
        }

        stage('docker'){
            agent{
                docker{
                    image 'docker'
                }
            }
            steps{
                sh 'docker build -t spring-boot-docker:0.0.1 .'
                sh 'docker push docker-image.mqcoding.com:5000/spring-boot-docker:0.0.1'
            }

        }
    }
}