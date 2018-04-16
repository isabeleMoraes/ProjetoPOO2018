package Model;

public abstract class Usuario {
    protected String email;
    protected String senha;
    private int tentativas;

    public Usuario(String email, String senha){
        this.email = email;
        setSenha(senha);
        this.tentativas = 3;
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
