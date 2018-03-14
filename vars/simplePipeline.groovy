def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {

        parameters {
            string( name: "projectName", 	description: "Timeout in minutes") 
            string( name: "serverDomain",   description: "Message for console output" )
        }

        stage('Greating') {
            steps {
                sh "echo 'Message: ${params.serverDomain}'"
                sh "echo 'Message: ${params.projectName}'"
            }
        }         
    }
}
