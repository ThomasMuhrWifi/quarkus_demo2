

def test_Variable = "test"

pipeline {
    // agent any
    // agent { label 'aws' }
    agent any

    parameters {
        booleanParam(defaultValue: false,
                     description: 'If checked downstream pipeline is also',
                    name: 'build_downstream'
        )
        string(name: 'STATEMENT',
            defaultValue: 'hello; ls /', description: 'What should I say?'
        )
    }

    tools {
        maven 'maven_3.8.x'
        jdk 'java11'
    }

    stages {
        stage('Introduction and Pre Checks') {
            steps {
                echo 'This is a minimal pipeline.'
                script {
                    sh 'df -h'
                    sh 'java -version'
                    sh 'mvn --version'
                }
            }
        }
        stage('build') {
            steps {
                echo 'This is the build step'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build quarkus container image') {
            steps {
                echo "Build and Unit Test"
                sh "mvn -B package -Dquarkus.container-image.build=true -DskipTests=true"
            }
        }
        stage('Docker push quarkus container image') {
            steps {
                echo "Docker push quarkus container image"
                sh "mvn -B package -Dquarkus.container-image.push=true -DskipTests=true"
            }
        }
    }
    post {
        failure {
            echo "Build POST  FAILURE action "
        }
        always {
            echo "Build POST action"
        }
    }
}