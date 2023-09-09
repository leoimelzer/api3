package api3

import api3.utils.Api2Config
import api3.exceptions.ControllerExceptionHandler
import api3.plugin.LogService
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import org.grails.web.json.JSONObject

import java.time.LocalDate

class CidadeController implements ControllerExceptionHandler {
    static responseFormats = ['json']
    static defaultAction = 'get'
    static allowedMethods = [
            list: 'GET',
            get: 'GET',
            save: 'POST',
            update: 'PUT',
            delete: 'DELETE'
    ]

    RestBuilder rest = new RestBuilder()
    LogService logService = new LogService()

    Object list() {
        String url = "${Api2Config.cidadeUrl}${Api2Config.listAction}"
        RestResponse resp = rest.get(url)
        JSONObject jsonResp = resp.json as JSONObject

        respond(jsonResp, status: resp.status)
    }

    Object get(Long id) {
        String url = "${Api2Config.cidadeUrl}${Api2Config.getAction}?id=${id}"
        RestResponse resp = rest.get(url)
        JSONObject jsonResp = resp.json as JSONObject

        respond(jsonResp, status: resp.status)
    }

    Object save() {
        String url = "${Api2Config.cidadeUrl}${Api2Config.saveAction}"
        RestResponse resp = rest.post(url) { json(nome: request.JSON.nome) }
        JSONObject jsonResp = resp.json as JSONObject

        logService.salvarLog(request, jsonResp, LocalDate.now())
        respond(jsonResp, status: resp.status)
    }

    Object update(Long id) {
        String url = "${Api2Config.cidadeUrl}${Api2Config.updateAction}?id=${id}"
        RestResponse resp = rest.put(url) { json(nome: request.JSON.nome) }
        JSONObject jsonResp = resp.json as JSONObject

        logService.salvarLog(request, jsonResp, LocalDate.now())
        respond(jsonResp, status: resp.status)
    }

    Object delete(Long id) {
        String url = "${Api2Config.cidadeUrl}${Api2Config.deleteAction}?id=${id}"
        RestResponse resp = rest.delete(url)
        JSONObject jsonResp = resp.json as JSONObject

        logService.salvarLog(request, jsonResp, LocalDate.now())
        respond(jsonResp, status: resp.status)
    }
}
