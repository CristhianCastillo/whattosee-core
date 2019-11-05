package ml.whattosee.util;

public enum CodeResponse {

    OK_COMMON("00", "Peticion procesada correctamente"),
    OK_CREATING_USER("101", "Usuario creado correctamente"),
    OK_LOGIN ("102", "Usuario autenticado correctamente");

    private final String code;
    private final String description;

    CodeResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
