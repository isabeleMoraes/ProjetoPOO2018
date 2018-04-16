package Model;

public class Jogo {
    private Jogador arrayJogadores[];
    private int maxJogadores;
    private int jogadoresCadastrados;

    public Jogo(int maxUsuarios) {
        this.arrayJogadores = new Jogador[maxUsuarios];
        this.maxJogadores = maxUsuarios;
        this.jogadoresCadastrados = 0;
    }

    /**
     *Esse método faz o login de um jogador no jogo.
     * @param email Email do jogador.
     * @param senha Senha do jogador.
     * @return Retorna true caso o login tenha sido efetuado e false caso
     * contrário.
     */
    public boolean fazLogin(String email, String senha){
        boolean retorno = false;
        int i=0;

        while((i<this.maxJogadores) && (retorno == false)){
            if(this.arrayJogadores[i].getEmail().equals(email) && /*FALTA A PARTIR DAQUI*/){

                /*
                * && ... (VERIFICAR SE A SENHA NA POSIÇÃO i É IGUAL A SENHA QUE VEIO PELO
                * PARÂMETRO, QUE TAMBÉM DEVE SER CRIPTOGRAFADA PARA FAZER A COMPARAÇÃO) E A PARTIR
                * DAI FAZER A CONTAGEM DE TENTATIVAS DO USUÁRIO EM QUESTÃO.
                * */



                retorno = true;
            }
        }
        return retorno;
    }
    /**
     * Esse método adiciona um jogador ao jogo.
     * @param jog Jogador que será adicionado.
     * @return Retorna true caso o jogador seja cadastrado com sucesso e false
     * caso contrário.
     */
    public boolean addJogador(Jogador jog){
        boolean retorno = false;

        if(this.jogadoresCadastrados < this.maxJogadores){
            this.arrayJogadores[this.jogadoresCadastrados] = jog;
            retorno = true;
        }

        return retorno;
    }

    /**
     * Verifica se o email é valido. É valido quando contém @ e o termino com (.com ou .com.br).
     * @return Verdadeiro se contém e Falso se não contém.
     */
    public boolean validaEmail(String email){
        return email.contains("@")&&(email.contains(".com")||email.contains(".com.br"));
    }
}
