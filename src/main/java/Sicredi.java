/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro Teodoro
 */
public class Sicredi {
    public static void main(String[] args) throws InterruptedException
    {
        // ********* CHALLENGE 1 ********* //
        Challenge1 challenge1 = new Challenge1();
        // Observação: O script deve executar no browser Google Chrome
        Challenge1.openBrowser();
        // Passos do Desafio 1
        challenge1.stepsChallenge1();
        // Fecha o browser web do desafio 1
        Challenge1.closeBrowser();
        
        // ---------------------------------------------------------------- //
        
        // ********* CHALLENGE 2 ********* //
        Challenge2 challenge2 = new Challenge2();
        // Observação: O script deve executar no browser Google Chrome
        Challenge2.openBrowser();
        // Pré-condição: Executa todos os passos do Desafio 1
        challenge2.stepsChallenge1();
        // Passos do Desafio 2
        challenge2.stepsChallenge2();
        // Fecha o browser web do desafio 2
        Challenge2.closeBrowser();
    }
}
