package Model;

public class Humano extends Jogador {
    private String email;
    private String senha;

    public Humano(String email, String senha) {
        this.email = email;
        setSenha(senha);
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
        //VALIDAR ANTES !
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
