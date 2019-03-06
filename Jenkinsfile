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
                    args '--net=host -v /Users/zhangyin/.kube:/root/.kube    -v /Users/zhangyin/.helm:/root/.helm -v /var/run/docker.sock:/var/run/docker.sock -v /Users/zhangyin/.docker:/root/.docker --entrypoint=\'\' '

                }
                }
                steps{
                    sh 'file /.helm'
                    sh 'file /.kube'
                    sh 'helm version'

                }
              }


    }
}