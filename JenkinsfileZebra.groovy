pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'maven3'
    }
    
    stages {
        stage('download_stash_code') {
            steps {
                checkout scm
            }
        }

        stage('clean') {
            steps {
                sh "mvn clean"
            }
        }


        stage('tag the build') {
            steps { 

                    withCredentials([
                        [$class: 'UsernamePasswordMultiBinding', credentialsId: '7943607d-b421-4237-bc45-c7cef3fb3904', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS'],
                            ]){     

                                    sh """(
                                     mvn install -Ptest -Dusername=riddhi_thacker@yahoo.com -Dpassword=Ridz94_@
                                    )"""
                                }
                                

            }
        }        
        
    }
    
}

