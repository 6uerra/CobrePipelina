pipeline {
    agent any
    tools {
        maven 'maven' // Usar el nombre que asignaste a la instalación de Maven
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm // Clona el repositorio
            }
        }
        stage('Run Karate Tests') {
            steps {
                // Ejecuta Maven desde la raíz del repositorio donde está pom.xml
                sh 'mvn clean test -Dkarate.env=qa'
            }
        }
    }
}
