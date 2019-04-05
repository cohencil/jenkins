package com.pipeline

@Library('pipeline-library') _

node() {
    def pipeline = new TestPipeline(this)
    pipeline.run()
}
