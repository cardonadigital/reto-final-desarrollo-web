package org.sofka.mykrello.utilities;

import org.springframework.stereotype.Component;

/**
 * Contains all methods to the Custom Response
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */
@Component
public class MyResponseUtility {
    public Boolean error;
    public String message;
    public Object data;

    public MyResponseUtility() {
        error = false;
        message = "Success";
        data = null;
    }

    public void restart() {
        error = false;
        message = "Success";
        data = null;
    }

    public void error(String err) {
        restart();
        error = true;
        message = err;
        data = null;
    }

    public void response(Object object) {
        restart();
        error = false;
        message = "Success";
        data = object;
    }
}
