#!groovy

@Library('onuralp/shared-libraries') _

def version = 'v1'
def rootPath = 'AutoDSL'
def rootFolderPath = "${rootPath}/CI_Builds/${version}"

folder("${rootPath}")
folder("${rootPath}/CI_Builds")
folder("${rootPath}/CI_Builds/${version}")
folder("${rootPath}/CI_Builds/${version}/SimplePipelines")

// Jobs
simplePipeline {
    JobName = "Brother"
    Message = '1'
}

simplePipeline {
    JobName = "Another"
    Message = '2'
}
