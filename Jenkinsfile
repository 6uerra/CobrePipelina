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
                // Especifica la ruta donde está el archivo pom.xml
                sh 'mvn -f karate/pom.xml clean test -Dkarate.env=qa'
            }
        }
    }
}
