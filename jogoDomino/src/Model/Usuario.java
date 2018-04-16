package Model;

import java.util.Date;

public abstract class Usuario {
    protected String email;
    protected String senha;
    private int tentativas;
    private int dataBloqueio;


    public Usuario(String email, String senha){
        this.email = email;
        setSenha(senha);
        this.tentativas = 3;
    }

    public int getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(int dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    /**
     * Metodo responsavel por retornar a quantidade de tentativas dispoviveis no momento.
     * @return
     */
    public int getTentativas() {
        return tentativas;
    }

    /**
     * Metodo responsavel por setar a quantidade de tentativas do usuario de acordo com o numero de erros no momento do login.
     * @param tentativas
     */
    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Altera o email do usuario.
     * @param email definido para alteração.
     */
    public void setEmail(String email) {
        this.email = email;
        //VALIDAR
    }

    public String getSenha() {
        return senha;
    }

    /**
     * Altera a senha do usuario.
     * @param senha definida para alteração.
     */
    public void setSenha(String senha) {
        this.senha = Criptografia.criptografar(senha);
    }
}
