package View;

import Model.Computador;
import Model.Humano;
import Model.Jogador;
import Model.Jogo;

import javax.swing.*;

import static java.util.Calendar.getInstance;

public class Main {

    public static final int MAX_USUARIOS = 10;
    public static final int HUMANO = 1;
    public static final int COMPUTADOR = 2;

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

    private static int menu2(){
        StringBuffer text = new StringBuffer();

        text.append("[1]- Cadastrar Humano\n");
        text.append("[2]- Computador");

        text.append("\n\n--> Informe a opção que deseja: ");

        return Integer.parseInt(JOptionPane.showInputDialog(null, text,null, 1));
    }

    public static void main(String[] args){


        Jogo game = new Jogo(MAX_USUARIOS);
        String senha, email;
        Humano jogador1;
        boolean go = true;
        int opcao, login;

        while(go) {
            switch (Main.menu()) {
                case 1:
                    opcao = Main.menu2();

                    switch (opcao){
                        case 1:
                            email = JOptionPane.showInputDialog(null, "--> Informe seu email: ", null, 3);
                            senha = JOptionPane.showInputDialog(null,
                                    "--> Informe sua senha: ", null, 3);

                            if (game.validaEmail(email)) {
                                jogador1 = new Humano(email, senha);
                                if(game.addJogador(jogador1)){
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


                            //jogador1 = new Computador();



                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida", null, 0);
                            break;
                    }
                    break;
                case 2:
                    login = game.fazLogin();
                    if(login >= 0){
                        JOptionPane.showMessageDialog(null, "Bem vindo(a) ", null, 1);
                    }else if (login == -2){
                        JOptionPane.showMessageDialog(null, "Está bloqueado", null, 0);
                    }else if(login == -3){
                        JOptionPane.showMessageDialog(null,
                                "Não há nenhum cadastro", null, 0);
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Email/Senha incorretos", null, 0);
                    }
                    break;
                case 99:
                    JOptionPane.showMessageDialog(null, "*** Até Logo ***", null, 1);
                    go = false;
                    break;
            }
        }
    }
}
