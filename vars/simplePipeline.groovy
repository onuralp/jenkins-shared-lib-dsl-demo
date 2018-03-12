def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipelineJob(params.JobName) {

        parameters {
            string( name: "Timeout", 	description: "Timeout in minutes") 
            string( name: "Message",    description: "Message for console output" )
        }

        stages {
            stage('Greating') {
                steps {
                    sh "echo 'Message: ${params.Message}'"
                }
            }
        }   
    }
}