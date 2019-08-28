pipeline {
	agent any
	stages{
		stage('Build'){		
			steps{
			echo 'Running build phase...'
			}
		}
		stage('Test'){
			steps{
			echo 'Running test phase...'
			}
		}
		stage('QA'){
			steps{
			echo 'Running QA phase...'
			}
		}
		stage('Deploy'){
			steps{
			input('do you want to proceed')
			echo 'Running deploy  phase...'
			}
		}
	}
}