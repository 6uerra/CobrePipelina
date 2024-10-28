pipeline {
    agent any
    stages {
        stage('Execute Existing Job') {
            steps {
                // Invoca la tarea existente llamada 'Karate' el cual ejecuta los test
                build job: 'Karate'
            }
        }
    }
}
