package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Anotacao;

public class EditAnotacaoForm {
    private String texto;

    public EditAnotacaoForm(String texto) {
        this.texto = texto;
    }

    public EditAnotacaoForm() {
    }

    public String getTexto() {
        return texto;
    }

    public void atualizar(Anotacao anotacao){
        anotacao.setTexto(texto);
    }
}
