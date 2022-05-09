package br.com.projectapi.data.pojo.conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyCadastrarConta {
    //Quando o json tiver vários niveis, inves chamar string [nomevariavel], vc chama a classe do outro body que vc deseja juntar
    private String nome;

}
