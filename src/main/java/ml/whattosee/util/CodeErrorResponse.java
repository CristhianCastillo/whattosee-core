package ml.whattosee.util;

public enum CodeErrorResponse {

    ERROR_CREATING_USER("99", "No fue posible crear el usuario. Intente nuevamente."),
    ERROR_LOGIN ("98", "Nombre de usuario y/o password no son validos."),
    ERROR_GET_GENDERS ("97", "No es posible obtener los generos de peliculas."),
    ERROR_CREATING_COMMENT("96", "No fue posible crear un comentario"),
    ERROR_CREATING_DISCUSSION("95", "No fue posible crear un foro de pelicula"),
    ERROR_CREATING_DISCUSSION_COMMENT("94", "No fue posible crear un comentario a un foro");

    private final String code;
    private final String description;

    CodeErrorResponse(String code, String description) {
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
