package cl.usm.taller1.utils;

import cl.usm.taller1.entities.Cliente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteValidations {

    public static boolean checkIfFieldsAreNulls(Cliente cliente){
        return cliente.getNombre() != null && cliente.getApellidos() != null && cliente.getRut() != null;
    }

    public static boolean verifyRutValid(Cliente cliente) {

        boolean allIsOK = false;
        String rut =  cliente.getRut().toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            allIsOK = true;
        }

        return allIsOK;
    }

}
