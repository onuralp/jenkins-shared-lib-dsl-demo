def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    
        node {
            
            try {
                stage ('Build') {
                    sh "echo 'building ${params.Name} ...'"
                }
            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
}
