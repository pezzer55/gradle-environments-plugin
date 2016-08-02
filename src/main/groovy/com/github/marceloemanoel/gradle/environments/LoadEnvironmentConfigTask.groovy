package com.github.marceloemanoel.gradle.environments

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class LoadEnvironmentConfigTask extends DefaultTask {

    String group = "Environments"
    String description = "Reads information from file env-properties.groovy and stores in the environment property"
    
    LoadEnvironmentConfigTask(){
    }
    
    def File configFile() {
        project.file('env-properties.groovy')
    }
    
    @TaskAction
    def loadEnvironmentConfig() {
        project.ext.environment = new ConfigSlurper().parse(configFile().toURL()).environment
        logger.info("Configuration values: ")
        logger.info(project.ext.environment.toString())
    }

}
