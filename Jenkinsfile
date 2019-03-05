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
        stage('kubectl'){
              agent{
                docker{
                    image 'k8s-kubectl:v1.11.8'
                    args '-v /Users/zhangyin/.kube:/root/.kube'

                }
                }
                steps{

                    sh 'kubectl get pods'

                }
              }


    }
}