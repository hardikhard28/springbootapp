pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Use the checkout step to clone the Git repository
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/master']], // Specify the branch you want to checkout
                        userRemoteConfigs: [[url: 'https://github.com/hardikhard28/springbootapp.git']] // Specify your Git repository URL
                    ])
                }
            }
        }
        stage('mvn cleaning ') {
            steps {
                script {
                    // Use the checkout step to clone the Git repository
                    sh "mvn clean package"
                }
            }
        }

        
    }
}