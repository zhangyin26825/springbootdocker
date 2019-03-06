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
                    image 'dtzar/helm-kubectl:2.11.0'
                    args '--net=host -v /Users/zhangyin/.kube:/root/.kube    -v /Users/zhangyin/.kube:/home/.kube -v /var/run/docker.sock:/var/run/docker.sock -v /Users/zhangyin/.docker:/root/.docker --entrypoint=\'\' --server=http://192.168.0.101:80'

                }
                }
                steps{

                    sh 'kubectl get pods'

                }
              }


    }
}