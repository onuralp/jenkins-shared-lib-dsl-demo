def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {

        parameters {
            string( name: "Name" ) 
            string( name: "Message" )
        }

        stage('Greating') {
            
            steps {
                sh "echo 'Message: ${params.Name}'"
                sh "echo 'Message: ${params.Message}'"
            }
        }         
    }
}
