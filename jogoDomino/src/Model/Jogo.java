package Model;


import java.util.Date;

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
    public String fazLogin(String email, String senha){
        String retorno="";
        int i=0;
        int tentativas;
        Date data = new Date();



        while(i<this.maxJogadores){
            retorno = "";
            tentativas = arrayJogadores[i].getTentativas();

            // Primeiro precisamos verificar se o email informado existe e apenas depois verificar a senha correta.
            if(this.arrayJogadores[i].getEmail().equals(email) && tentativas>0){
                if(this.arrayJogadores[i].getSenha().equals(Criptografia.criptografar(senha))){
                    retorno = "Login realizado com sucesso!";
                }else{
                    arrayJogadores[i].setTentativas(tentativas--);
                }
            }else{
                if(tentativas <=0 /*& (arrayJogadores[i].getDataBloqueio() == null || arrayJogadores[i].getDataBloqueio() >= data.getDate())*/){
                    retorno="";
                    retorno = "Esse usuario está bloqueado devido a tentativas esgotadas";
                    i=this.maxJogadores;
                }else{
                    retorno="";
                    retorno = "Usuario não encontrado";
                }
            }
            i++;
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
