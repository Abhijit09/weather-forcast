pipeline {
    agent any
    // We split the work into 3 stages:
    stages {
        // 1. Checkout the files from Git
        stage ('Prep') {
            steps {
                checkout scm
            }
        }
        // 2. Check if 'WeatherForcastApplication.java' exists, 
        stage ('Build') {
            steps {
                script {
                    if (fileExists('WeatherForcastApplication.java') == false) {
                        unstable('Code file not found!')
                    }
                }
            }
        }
        // 3. Dummy deploy
        // Print a message (only done if the build is stable)
        stage ('Deploy') {
            when { not { equals expected: 'UNSTABLE
            steps {
                echo 'Deploying it gently...'
            }
        }
    }
}