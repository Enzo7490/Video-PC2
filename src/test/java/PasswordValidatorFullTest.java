import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidatorFullTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidatorFull.isValid("Hola123!"), "Debe ser válido");
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(PasswordValidatorFull.isValid("Hi!"), "Debe ser inválido por longitud");
    }

    @Test
    void testPasswordWithSpacesRules() {
        assertAll("Espacios inválidos",
                () -> assertFalse(PasswordValidatorFull.isValid(" Hola123!"), "Espacio al inicio"),
                () -> assertFalse(PasswordValidatorFull.isValid("Hola123! "), "Espacio al final"),
                () -> assertFalse(PasswordValidatorFull.isValid("Hola  123!"), "Espacios consecutivos")
        );
    }

    @Test
    void testPasswordNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidatorFull.isValid(null));
    }


    @Test
    void testPasswordEqualsExpected() {
        String password = "Hola123!";
        assertEquals(true, PasswordValidatorFull.isValid(password), "Debe coincidir con el valor esperado");
    }


    @Test
    void testPasswordTooLong() {
        String longPass = "A".repeat(65);
        assertFalse(PasswordValidatorFull.isValid(longPass), "Debe ser inválido por longitud > 64");
    }

    @Test
    void testPasswordInvalidCharacter() {
        assertFalse(PasswordValidatorFull.isValid("Hola123!€"), "Debe ser inválido por caracter no permitido");

    }
}
