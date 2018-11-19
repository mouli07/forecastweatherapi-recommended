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

 /*       stage('clean') {
            steps {
				sh """(
				cd src/gateway/forecastweatherapi
				ls
                mvn clean
				
				)"""
				
            }
        }

*/
        stage('tag the build') {
            steps { 
     

                                    sh """(
									 cd src/gateway/forecastweatherapi
                                     mvn install -X -Ptest -Dusername=riddhi_thacker@yahoo.com -Dpassword=Ridz94_@
                                    )"""
                                
                                

            }
        }        
        
    }
    
}

