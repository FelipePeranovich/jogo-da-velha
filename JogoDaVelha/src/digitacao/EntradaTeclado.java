/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitacao;

import java.util.Scanner;

/**
 *
 * @author Felipe Gomes Peranovich
 */
public class EntradaTeclado {
    Scanner t = new Scanner(System.in);
    
    public String texto(String mensagem){
        System.out.println(mensagem);
        String dado = t.nextLine();
        return dado;
    }
    public int inteiro(String mensagem,
                        String msgErro,
                        boolean repetir){
        int dado = 0;
        boolean erro = false;
        do{
            String aux = texto(mensagem);
            try{
                dado = Integer.parseInt(aux);
                erro = false;
            }
            catch(RuntimeException e){
                System.out.println(msgErro);
                erro = repetir;
            }
        }while (erro);
        return dado;
    }
    
    public double decimal(String mensagem) throws Exception{
        double dado = 0.0;
        String aux = texto(mensagem);
        aux = aux.replaceAll(",", ".");
        try{
            dado = Double.parseDouble(aux);
        }
        catch (Exception ex) {
            throw new Exception("Erro de digitação.");
        }
        return dado;
    }
     
   
}
