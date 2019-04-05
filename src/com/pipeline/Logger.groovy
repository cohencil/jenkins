package com.pipeline

class Logger implements Serializable {

    def script
    boolean debugLogging

    Logger(script) {
        this.script = script
        this.debugLogging = script.params.debugLogging ?: false
    }

    void info(String message) {
        script.echo message
    }

    void debug(String message) {
        if (debugLogging) {
            script.echo message
        }
    }
}
