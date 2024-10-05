pipeline {
    agent any

  

    stages {
        stage('Checkout Source Code') {
            steps {
                // Récupération du code depuis le référentiel Git
                git branch: 'main', 
                    url: 'https://github.com/omar1717/Testt.git', 
                    
            }
        }

        stage('Display System Date') {
            steps {
                // Affiche la date système
                script {
                    def currentDate = new Date()
                    echo "La date système actuelle est : ${currentDate}"
                }
            }
        }
    }

    post {
        always {
            // Actions à réaliser après chaque exécution, succès ou échec
            echo 'Pipeline terminé'
        }
    }
}
