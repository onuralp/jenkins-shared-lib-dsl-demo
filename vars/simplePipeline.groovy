def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {

        parameters {
            string( name: "Timeout", 	description: "Timeout in minutes") 
            string( name: "Message",    description: "Message for console output" )
        }

        stage('Greating') {
            steps {
                script {
                    currentBuild.displayName = "${params.JobName}"
                    currentBuild.description = "${params.JobName} description."
                }
            }
            steps {
                sh "echo 'Message: ${params.Message}'"
            }
        }         
    }
}