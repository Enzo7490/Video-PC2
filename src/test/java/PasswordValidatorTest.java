//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//public class PasswordValidatorTest {
//
//    @Test
//    void testValidPassword() {
//        assertTrue(PasswordValidatorFull.isValid("Hola123!"), "Debe ser válida");
//    }
//
//    @Test
//    void testPasswordTooShort() {
//        assertFalse(PasswordValidatorFull.isValid("123"), "Debe ser inválida por longitud");
//    }
//
//    @Test
//    void testPasswordWithSpaces() {
//        assertFalse(PasswordValidatorFull.isValid(" Hola123!"), "Espacio al inicio");
//    }
//
//    @Test
//    void testPasswordNullThrowsException() {
//        assertFalse(PasswordValidatorFull.isValid("Hola123! "), "Debe ser inválida por espacio al final");    }
//
//    @Test
//    void testPasswordEqualsExpected() {
//        assertFalse(PasswordValidatorFull.isValid("Hola  !123"), "Debe ser inválida por doble espacio");
//    }
//
//    @Test
//    void testPasswordInvalidCharacter() {
//        assertFalse(PasswordValidatorFull.isValid("Hola123€"), "Debe ser inválida por caracter no permitido");
//    }
//
//}
