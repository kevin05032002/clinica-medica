package clinica.login;

import clinica.model.Usuario;

public class SessaoUsuario {
    private static Usuario usuarioLogado;

    public static void setUsuarioLogado(Usuario usuario) {
        SessaoUsuario.usuarioLogado = usuario;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void limpar() {
        usuarioLogado = null;
    }
}
