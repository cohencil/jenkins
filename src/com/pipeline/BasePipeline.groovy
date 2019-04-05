package com.pipeline

abstract class BasePipeline implements Serializable {

    def logger
    def script

    BasePipeline(script) {
        this.script = script
        logger = new Logger(script)
    }

    void run() {
        logger.info('in BasePipeline.run()')
        runImpl()
    }

    void runImpl() {
        logger.info('in BasePipeline.runImpl()')
        runStage('Test Stage', this.&testStage)
    }

    void runStage(String name, Closure stage) {
        if (currentBuildResult in ['SUCCESS', null]) {
            script.stage(name, stage)

        } else {
            script.stage(name) {
                logger.info "Build is unstable, skipping stage $name"
            }
        }
    }

    void testStage() {
        script.echo 'in BasePipeline.testStage'
    }

    String getCurrentBuildResult() {
        return script.currentBuild.result
    }

}

@interface Library {
    String value()
}