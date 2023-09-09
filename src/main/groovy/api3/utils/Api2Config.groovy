package api3.utils

class Api2Config {
    static String getBaseUrl() {
        ApplicationConfig.getConfigProperty("api2.baseUrl")
    }

    static String getCidadeEndpoint() {
        ApplicationConfig.getConfigProperty("api2.endpoint.cidade")
    }

    static String getFuncionarioEndpoint() {
        ApplicationConfig.getConfigProperty("api2.endpoint.funcionario")
    }

    static String getReajusteSalarioEndpoint() {
        ApplicationConfig.getConfigProperty("api2.endpoint.reajusteSalario")
    }

    static String getGetAction() {
        ApplicationConfig.getConfigProperty("api2.action.get")
    }

    static String getListAction() {
        ApplicationConfig.getConfigProperty("api2.action.list")
    }

    static String getSaveAction() {
        ApplicationConfig.getConfigProperty("api2.action.save")
    }

    static String getUpdateAction() {
        ApplicationConfig.getConfigProperty("api2.action.update")
    }

    static String getDeleteAction() {
        ApplicationConfig.getConfigProperty("api2.action.delete")
    }

    static String getCidadeUrl() {
        baseUrl + cidadeEndpoint
    }

    static String getFuncionarioUrl() {
        baseUrl + funcionarioEndpoint
    }

    static String getReajusteSalarioUrl() {
        baseUrl + reajusteSalarioEndpoint
    }
}
