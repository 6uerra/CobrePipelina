pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm // Clona el repositorio
            }
        }
        stage('Run Karate Tests') {
            steps {
                // Asegúrate de que Maven esté instalado y configurado en Jenkins
                sh 'mvn clean test"' 
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml' // Publicar resultados de las pruebas
        }
    }
}
