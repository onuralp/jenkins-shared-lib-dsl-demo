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
        stages {
            stage('Greating') {
            
                steps {
                    echo("Name: ${params.Name}")
                    echo("Message: ${params.Message}")
                }
            }
        }
    }
}
