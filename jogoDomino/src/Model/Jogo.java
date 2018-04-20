package Model;


import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Jogo {
    private Humano arrayHumanos[];
    private int maxUsuarios;
    private int humanosCadastrados;
    private boolean bloqueado;
    private int tentativas;
    GregorianCalendar gc;


    public Jogo(int maxUsuarios) {
        this.arrayHumanos = new Humano[maxUsuarios];
        this.maxUsuarios = maxUsuarios;
        this.humanosCadastrados = 0;
        this.bloqueado = false;
        this.tentativas = 3;
        this.gc = new GregorianCalendar();
    }

    /**
     *Esse método faz o login de um jogador no jogo.
     * @return Retorna true caso o login tenha sido efetuado e false caso
     * contrário.
     */

    public int fazLogin(){
        int retorno;
        int comparacao;
        GregorianCalendar now = new GregorianCalendar();

        if(this.bloqueado) {
            now.setTime(new Date());
            comparacao = now.compareTo(this.gc);
            /*CASO ESTEJA BLOQUEADO, PEGA O HORÁRIO ATUAL E COMPARA COM O HORÁRIO EM QUE FOI FEITO O BLOQUEIO
              SE JÁ PASSOU O TEMPO, FAZ O DESBLOQUEIO E LIBERA PARA NOVAS TENTATIVAS DE LOGIN.
             */
            if(comparacao >= 0){
                this.bloqueado = false;
                retorno = doLogin();
            }else{
                retorno = -2;    //CONTINUA BLOQUEADO, POIS O TEMPO AINDA NÃO PASSOU COMPLETAMENTE.
            }
        }else{
            retorno = doLogin();
        }

        return retorno;
    }

    private int doLogin() {
        /*
            OPTEI POR DEIXAR AS TENTATIVAS NA CLASSE JOGO, POIS NÃO VEJO POSSIBILIDADES DE TÊ-LAS EM CADA USUÁRIO
            POIS SE ALGUÉM ESTÁ TENTANDO LOGAR E ACABA SENDO BLOQUEADO, COMO IREMOS SABER EM QUEM ATRIBUIR ESSE BLOQUEIO? OU SEJA,
            EM QUAL USUÁRIO IRIAMOS DECREMENTAR AS TENTATIVAS? POIS SÓ PODERÍAMOS IDENTIFICÁ-LO PELO EMAIL E SENHA, E ESTÃO ERRADOS.
         */


        int i=0, aux = -1;
        this.tentativas = 3;
        String email, senha;

        if(this.humanosCadastrados > 0) {
            while ((this.tentativas > 0) && (aux < 0)) {

                email = JOptionPane.showInputDialog(null,
                        "--> Informe seu email: ", null, 3);
                senha = JOptionPane.showInputDialog(null,
                        "--> Informe sua senha: ", null, 3);

                // Primeiro precisamos verificar se o email informado existe e apenas depois verificar a senha correta.
                while ((i < this.humanosCadastrados) && (aux < 0)) {
                    if (this.arrayHumanos[i].getEmail().equals(email)) {
                        if (this.arrayHumanos[i].getSenha().equals(Criptografia.criptografar(senha))) {
                            aux = i;
                        }
                    }
                    i++;
                }
                this.tentativas -= 1;
                JOptionPane.showMessageDialog(null, "Restam "+this.tentativas+" tentativas.", null, 1);
            }
        }else{
            aux = -3;
        }

        if ((this.tentativas == 0) && (aux < 0)) {
            /*
                CASO AS TENTATIVAS ACABEM, DEVE SER FEITO O BLOQUEIO, POR ISSO, gc.setTime() ESTÁ PEGANDO A HORA ATUAL
                E EM SEGUIDA ADICIONA 2 HORAS(TEMPO QUE SERÁ IMPOSSIBILITADO DE NOVAS TENTATIVAS DE LOGIN).
             */

            gc.setTime(new Date());
            gc.add(Calendar.HOUR, 2);
            aux = -2;
            this.bloqueado = true;
        }

        return aux;
    }

    /**
     * Esse método adiciona um jogador ao jogo.
     * @param jog Jogador que será adicionado.
     * @return Retorna true caso o jogador seja cadastrado com sucesso e false
     * caso contrário.
     */
    public boolean addJogador(Humano jog){
        boolean retorno = false;

        if(this.humanosCadastrados < this.maxUsuarios){
            this.arrayHumanos[this.humanosCadastrados] = jog;
            this.humanosCadastrados += 1;
            retorno = true;
        }

        return retorno;
    }

    /**
     * Realiza a ordenação do array de jogadores, ordenando do melhor score até o pior.
     */

    public void ordenaJogadores(){
        int i, j;
        Humano elemento_auxiliar;
        boolean trocou = true;

        for(i=0; i<humanosCadastrados && trocou; i++) {
            trocou = false;
            for (j = 0; j < humanosCadastrados - (1 + i); j++) {
                if (arrayHumanos[j].getScore() < arrayHumanos[j + 1].getScore()) {
                    elemento_auxiliar = arrayHumanos[j];
                    arrayHumanos[j] = arrayHumanos[j + 1];
                    arrayHumanos[j + 1] = elemento_auxiliar;
                    trocou = true;
                }
            }
        }
    }

    /**
     * Verifica se o email é valido. É valido quando contém @ e o termino com (.com ou .com.br).
     * @return Verdadeiro se contém e Falso se não contém.
     */
    public boolean validaEmail(String email){
        return email.contains("@")&&(email.contains(".com")||email.contains(".com.br"));
    }

    public Humano[] getArrayHumanos() {
        return arrayHumanos;
    }

    public void setArrayHumanos(Humano[] arrayHumanos) {
        this.arrayHumanos = arrayHumanos;
    }

    public int getMaxUsuarios() {
        return maxUsuarios;
    }

    public void setMaxUsuarios(int maxUsuarios) {
        this.maxUsuarios = maxUsuarios;
    }

    public int getHumanosCadastrados() {
        return humanosCadastrados;
    }

    public void setHumanosCadastrados(int humanosCadastrados) {
        this.humanosCadastrados = humanosCadastrados;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public GregorianCalendar getGc() {
        return gc;
    }

    public void setGc(GregorianCalendar gc) {
        this.gc = gc;
    }
}
