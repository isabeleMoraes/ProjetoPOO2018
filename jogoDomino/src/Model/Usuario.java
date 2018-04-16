package Model;


public abstract class Usuario {
    private String email;
    private String senha;

    public Usuario(String email, String senha){
        this.email = email;
        setSenha(senha);
    }

    /**
     * Verifica se o email é valido. É valido quando contém @ e o termino com (.com ou .com.br).
     * @return Verdadeiro se contém e Falso se não contém.
     */
    public boolean validaEmail(){
        return this.email.contains("@")&&(this.email.contains(".com")||this.email.contains(".com.br"));
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

public class Usuario {

}
