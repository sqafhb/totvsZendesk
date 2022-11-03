package modulos.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Teste de Login Web")
public class LoginTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver 107.0.5304.62\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.navegador.get("https://totvscst.zendesk.com/hc/pt-br/#home");
        this.navegador.findElement(By.id("user-info-login")).click();
    }

    @Test
    @DisplayName("Não é permitido realizar login com usuário/senha inválido")
    public void testLoginInvalido (){
        new LoginPage(navegador)
            .informarOUsuario("frndb90@gmail.com")
            .informarSenha("Test123")
            .submeterLogin();
    }

    @AfterEach
    public void afterEach() {
        this.navegador.quit();
    }
}