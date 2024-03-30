/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodavelha;

import digitacao.EntradaTeclado;

/**
 *
 * @author Felipe Gomes Peranovich
 */

public class JogoDaVelha {
    static char[][] tabuleiro = new char[3][3];
    static String nomejg1,nomejg2;
    static boolean jogador1Jogar = true;
    static String vencedor = "";
    static EntradaTeclado teclado = new EntradaTeclado();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("JOGO DA VELHA");
        System.out.println("OBS: as jogas são feitas digitando a coluna e a linha\nexemplo:a2, b1 ou c3");
        // 1 . iniciar os vetores ou a matriz
            processoIniciar();
        // 2 . pedir os nome dos jogadores
            indicarJogadores();
        // 3 . determinar quem iniciará a jogada
            double opcao = Math.random()*100; 
            if (opcao < 50.0){
               jogador1Jogar = true; 
            }
            else{
                jogador1Jogar = false;
            }
                
        // 4 . repetir as próximas etapas até ocorrer um vencedor ou empate
            do {
        // 4.1. Indicar quem deve jogar
                System.out.println("É sua vez de jogar "+(jogador1Jogar ? nomejg1 : nomejg2));
        // 4.2. selecionar a posicao
        // 4.3. verificar se existe a posicao e se não está ocupada
        // 4.4. marcar a posicao
                jogada();
                mostrarTabuleiro();
        // 4.5. verificar se houve ganhador ou empate
                vencedor = verificarGanhador();
                if (vencedor.equals(""))
                    jogador1Jogar = !jogador1Jogar;
                else
                    break;
                
            } while (true);
        // 5. indicar o jogador vencedor ou o empate
        if( vencedor.equals("Empate"))
            System.out.println("Aconteceu um empate");
        else
            System.out.println("Parabens " + vencedor + "!");
        
    }
    
    static String verificarGanhador(){
        for (int linha =0 ; linha < 3 ; linha++){
            if (tabuleiro[linha][0] == tabuleiro[linha][1] &&
                tabuleiro[linha][1] == tabuleiro[linha][2] &&
                tabuleiro[linha][0] != ' '){
                return jogador1Jogar ? nomejg1 : nomejg2;
                
            }
        }
        for (int coluna =0 ; coluna < 3 ; coluna++){
            if (tabuleiro[0][coluna] == tabuleiro[1][coluna] &&
                tabuleiro[1][coluna] == tabuleiro[2][coluna] &&
                tabuleiro[2][coluna] != ' '){
                return jogador1Jogar ? nomejg1 : nomejg2;
            }
        }
            if (tabuleiro[0][0] == tabuleiro[1][1] &&
                tabuleiro[1][1] == tabuleiro[2][2] &&
                tabuleiro[2][2] != ' '){
                return jogador1Jogar ? nomejg1 : nomejg2;
            }
            if (tabuleiro[0][2] == tabuleiro[1][1] &&
                tabuleiro[1][1] == tabuleiro[2][0] &&
                tabuleiro[2][0] != ' '){
                return jogador1Jogar ? nomejg1 : nomejg2;
            }
            int vazios = 9;
            for (int linha = 0; linha <3;linha++){
                for (int coluna = 0 ; coluna < 3; coluna++){
                    if (tabuleiro[linha][coluna] != ' ')
                        vazios--;
                }
            }
            if (vazios == 0){
                return "Empate";
            }
        return "";
    }
    static void jogada(){
        do {
            String posicao = teclado.texto("Qual posição você escolhe?");
            if (posicao.length()!= 2){
                System.out.println("Escolha uma posicao que existe");
                continue;
            }
            char coluna = posicao.toUpperCase().charAt(0);
            char linha = posicao.toUpperCase().charAt(1);
            // testa se a posicao existe
            if (coluna < 'A' || coluna > 'C'){
                System.out.println("Esta coluna não existe.");
                continue;
            }
            if (linha < '1' || linha > '3'){
                System.out.println("Esta linha não existe.");
                continue;
            }
            if (tabuleiro[linha - '1'][coluna - 'A'] != ' '){
                System.out.println("Esta posicao ja está em uso.");
                continue;
            }
            // marcar a posicao com o simbolo do jogador.
            tabuleiro[linha - '1'][coluna - 'A'] = (jogador1Jogar ?  'O' : 'X');

            if (tabuleiro[linha - '1'][coluna - 'A'] != ' '){
                break;
            }
        }
        while (true);
        
    }

    private static void indicarJogadores(){
        do{
           nomejg1 = teclado.texto("Por favor, informe o nome do jogador 1");
           if (! nomejg1.equals("")){
               break;
           }
           else {
               System.out.println("Por favor, um nome é obrigatório.");
           }
        }while (true);
        do {
            nomejg2 = teclado.texto("Por favor, informe o nome do jogador 2");
            if (! nomejg2.equals("")){
               break;
           }
           else {
               System.out.println("Por favor, um nome é obrigatório.");
           }
        } while(true);
        
    }
    private static void processoIniciar() {
        for (int linha = 0 ; linha < tabuleiro.length;linha++){
            for (int coluna = 0 ; coluna < tabuleiro[linha].length;coluna++){
                tabuleiro[linha][coluna] = ' ';
            }
        }
        mostrarTabuleiro();
    }

    private static void mostrarTabuleiro() {
        System.out.println("    A   B   C");
        for (int linha = 0 ; linha < tabuleiro.length;linha++){
            System.out.print( linha+1 + " | ");
            for (int coluna = 0 ; coluna < tabuleiro[linha].length;coluna++){
                System.out.print(tabuleiro[linha][coluna] + " | ");
            }
            System.out.println("");
        }
    }
}
