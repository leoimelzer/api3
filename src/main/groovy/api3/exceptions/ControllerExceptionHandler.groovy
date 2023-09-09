package api3.exceptions

import grails.artefact.controller.RestResponder
import org.springframework.http.HttpStatus

trait ControllerExceptionHandler implements RestResponder {
    Object handleException(Exception ex) {
        respond([success: false, message: ex.getMessage()], status: HttpStatus.BAD_REQUEST)
    }
}
