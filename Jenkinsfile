pipeline {
    agent any
    stages {
      stages {
        stage('Checkout Source Code') {
            steps {
                // Récupération du code depuis le référentiel Git
                git branch: 'main', 
                    url: 'https://github.com/omar1717/Testt.git'
                    
            }
        }
        stage('Maven Clean') {
            steps {
                sh "mvn clean"
            }
        }
        stage('Maven Package') {
            steps {
                sh "mvn package -DskipTests"
            }
        }
    }
    post {
        success {
            slackSend channel: '#jenkins', 
                      color: 'good', 
                      message: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' succeeded. Check it here: ${env.BUILD_URL}"
        }
        failure {
            slackSend channel: '#jenkins', 
                      color: 'danger', 
                      message: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' failed. Check it here: ${env.BUILD_URL}"
        }
    }
}
}