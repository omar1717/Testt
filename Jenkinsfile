pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                git branch: 'main',
                    url: 'git@github.com:bitri12/ski_station.git',
                    credentialsId: 'github-credentials-id'
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
