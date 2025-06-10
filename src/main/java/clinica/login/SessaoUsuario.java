package clinica.login;

import clinica.model.Usuario;

public class SessaoUsuario {
    private static Usuario usuario;

    public static void setUsuario(Usuario u) {
        usuario = u;
    }

    public static Usuario getUsuario() {
        return usuario;
    }
}