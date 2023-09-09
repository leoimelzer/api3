package api3.utils

import grails.util.Holders

class ApplicationConfig {
    static String getConfigProperty(String property) {
        return Holders.grailsApplication.config.getProperty(property)
    }
}
