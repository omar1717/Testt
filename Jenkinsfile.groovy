pipeline {
    agent any

    triggers {
        // Déclenche le pipeline lorsqu'un push est détecté sur Git
        pollSCM('* * * * *') // Vérifie le dépôt toutes les minutes
    }

    stages {
        stage('Checkout Source Code') {
            steps {
                // Récupération du code depuis le référentiel Git
                git branch: 'main', 
                    url: 'https://github.com/votre-utilisateur/votre-repo.git', 
                    credentialsId: 'votre-identifiant-cred'
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
