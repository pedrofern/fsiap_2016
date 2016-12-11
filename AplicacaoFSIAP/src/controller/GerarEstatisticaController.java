/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacaofsiap.LightGo;
import aplicacaofsiap.Reflexao.PolarizacaoPorReflexao;
import java.util.Collections;
import java.util.List;

/**
 * * Classe que coordena as operações relacionadas com a geração de estatísticas
 * @author DianaSilva
 */
public class GerarEstatisticaController {
    
    LightGo lg;
    public GerarEstatisticaController(LightGo lg){
        this.lg=lg;
    }

    public String getValorMedioSubmissaoGlobal() {
        return "media: ";
    }

    public String getTaxaAceitacaoGlobal() {
        return "ola taxa";
    }

    public List<PolarizacaoPorReflexao> getListaPolarizacoesReflexao() {
        return lg.getListaSimulacoes().getListaPolarizacoesReflexao();
    }
    
    public void ordenar(){
        Collections.sort(getListaPolarizacoesReflexao());
        
    }
}
