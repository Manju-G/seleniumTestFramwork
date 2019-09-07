pipeline {
  agent any
  stages {
    stage('Stage1') {
      parallel {
        stage('Stage1') {
          steps {
            echo 'Hello Stage1'
          }
        }
        stage('Stage2') {
          steps {
            build(quietPeriod: 2, job: 'buildbmc1')
          }
        }
      }
    }
    stage('BlueStage1') {
      steps {
        sleep 1
      }
    }
  }
}