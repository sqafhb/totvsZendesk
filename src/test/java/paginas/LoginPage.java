package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver navegador;
    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario (String usuario) {
        this.navegador.findElement(By.cssSelector(".f-field-container #emailAddress")).sendKeys(usuario);
        return this;
    }

    public LoginPage informarSenha (String senha) {
        this.navegador.findElement(By.cssSelector("#password")).sendKeys(senha);
        return this;
    }

    public LoginPage submeterLogin () {
        this.navegador.findElement(By.cssSelector(".login-label")).click();
        return this;
    }

    public LoginPage messageError () {
        String messageError = this.navegador.findElement(By.cssSelector(".cp-error-message")).getText();
        Assertions.assertEquals("Credenciais inválidas", messageError);
        return this;
    }
}