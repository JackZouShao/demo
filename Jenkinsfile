pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''node{
stage(\'Build\'){
checkout scm
echo \'start build\'
}
stage(\'Test\'){
echo \'start test\'
}
stage(\'Deploy\'){
echo \'start deploy\'
}
}'''
        }
      }

    }
  }