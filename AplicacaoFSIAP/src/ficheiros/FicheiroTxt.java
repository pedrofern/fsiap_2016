/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheiros;

import aplicacaofsiap.Absorcao.PolarizacaoPorAbsorcao;
import aplicacaofsiap.Polarizacao;
import aplicacaofsiap.Simulacao;
import aplicacaofsiap.TipoDPolarizacao;
import controller.PolarAbsorcaoController;
import java.io.File;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Pedro Fernandes
 */
public class FicheiroTxt {
    
    private JFileChooser fileChooser;
    
    public FicheiroTxt(){
        
        fileChooser = new JFileChooser();
        
        personalizarFileChooserEmPortugues();
        definirFiltroExtensaoTXT(fileChooser);
    }
    
    public void gravar(Simulacao sim){
        if(sim.getTipoDPolarizacao()==TipoDPolarizacao.ABSORCAO){
            sim.getPolarizacaoPorAbsorcao().resultadosCompletosFormatados_toString();
        }else{
            sim.getPolarizacaoPorReflexao().toString();
        }
    }
    
     private static void personalizarFileChooserEmPortugues() {

        // Títulos das Caixas de Diálogo
        UIManager.put("FileChooser.openDialogTitleText", "Importar Ficheiro");
        UIManager.put("FileChooser.saveDialogTitleText", "Exportar Ficheiro");

        // Botão "Importar"
        UIManager.put("FileChooser.openButtonText", "Importar");
        UIManager.put("FileChooser.openButtonMnemonic", "I");
        UIManager.put("FileChooser.openButtonToolTipText", "Importar Ficheiro");

        // Botão "Exportar"
        UIManager.put("FileChooser.saveButtonText", "Exportar");
        UIManager.put("FileChooser.saveButtonMnemonic", "E");
        UIManager.put("FileChooser.saveButtonToolTipText", "Exportar Ficheiro");

        // Botão "Cancelar"
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");

        // Botão "Ajuda"
        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonMnemonic", "A");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");

        // Legenda "Procurar em:"
        UIManager.put("FileChooser.lookInLabelMnemonic", "E");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em:");

        // Legenda "Guardar em:"
        UIManager.put("FileChooser.saveInLabelText", "Guardar em:");
        UIManager.put("FileChooser.saveInLabelMnemonic", "G");

        // Legenda "Tipo de ficheiros:"
        UIManager.put("FileChooser.filesOfTypeLabelText", "Ficheiros do tipo:");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "F");

        // Legenda "Nome do ficheiro:"
        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do ficheiro:");

        // Filtro "Todos os Ficheiros"
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os Ficheiros");

        // Botão "Um nível acima"
        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

        // Botão "Ambiente de Trabalho"
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente");
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente de Trabalho");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Ambiente de Trabalho");

        // Botão "Nova Pasta"
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

        // Botão "Vista Lista"
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

        // Botão "Vista Detalhada"
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");

        // Cabeçalhos da "Vista Lista Detalhada"
        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");
    }
    
    private void definirFiltroExtensaoTXT(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extensao = extensao(f);
                if (extensao != null) {
                    return extensao.equals("txt");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.txt";
            }

            private String extensao(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }
    
}
