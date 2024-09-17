package pe.edu.upc.talent_tune.securities;

import java.io.Serializable;

public class JWTResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public String getJwttoken() {
        return jwttoken;
    }

    public JWTResponse(String jwttoken) {
        super();
        this.jwttoken = jwttoken;
    }
}
