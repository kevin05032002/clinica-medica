package clinica.login;

import clinica.model.Medico;

public class SessaoMedico {

    private static Medico medicoLogado;

    public static Medico getMedicoLogado() {
        return medicoLogado;
    }

    public static void setMedicoLogado(Medico medico) {
        medicoLogado = medico;
    }

    public static void limpar() {
        medicoLogado = null;
    }
}
