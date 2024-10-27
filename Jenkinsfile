pipeline {
    agent any
    stages {
        stage('Execute Existing Job') {
            steps {
                // Invoca la tarea existente llamada 'Karate'
                build job: 'Karate'
            }
        }
    }
}
