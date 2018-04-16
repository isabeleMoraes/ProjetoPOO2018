package View;

import Model.Jogador;
import Model.Jogo;

import javax.swing.*;

public class Main {

    public static final int MAX_USUARIOS = 10;

    /**
     * Esse método mostra as opções que poderão ser escolhidas.
     * @return Retorna o número que corresponde a opção escolhida.
     */
    private static int menu(){
        StringBuffer text = new StringBuffer();

        text.append("[1]- Cadastrar jogador\n");
        text.append("[2]- Fazer login\n");
        //...
        text.append("[99]- SAIR");
        text.append("\n\n--> Informe a opção que deseja: ");

        return Integer.parseInt(JOptionPane.showInputDialog(null, text, "Bem Vindo ao jogo", 1));
    }

    public static void main(String[] args){
        Jogo game = new Jogo(MAX_USUARIOS);
        String senha, email;
        Jogador jogador;
        boolean go = true;

        while(go) {
            switch (Main.menu()) {
                case 1:
                    email = JOptionPane.showInputDialog(null, "--> Informe seu email: ", null, 3);
                    senha = JOptionPane.showInputDialog(null,
                            "--> Informe sua senha: ", null, 3);

                    if (game.validaEmail(email)) {
                        jogador = new Jogador(email, senha);
                        if(game.addJogador(jogador)){
                            JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso",
                                    null, 1);
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "Erro ao cadastrar jogador", null, 0);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Email inválido !",
                                null, 0);
                    }
                    break;
                case 2:
                    email = JOptionPane.showInputDialog(null,
                            "--> Informe seu email: ", null, 3);
                    senha = JOptionPane.showInputDialog(null,
                            "--> Informe sua senha: ", null, 3);
                    if(game.fazLogin(email, senha)){
                        //...
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Email/Senha incorretos", null, 0);
                    }
                case 99:
                    JOptionPane.showMessageDialog(null, "*** Até Logo ***", null, 1);
                    go = false;
                    break;
            }
        }
    }
}
