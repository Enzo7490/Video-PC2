
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailFullTest {

    Email validator = new Email();

    // 1. Correo válido (Happy Path)
    @Test
    void testValidEmail() {
        assertTrue(validator.isValidEmail("cliente123@tienda.com"), "Debe ser válido");
    }

    // 2. Correo nulo (excepción)
    @Test
    void testEmailNullThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail(null));
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    // 3. Correo vacío (excepción)
    @Test
    void testEmailEmptyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail(""), "Debe lanzar excepción por vacío");
    }

    // 4. Correo demasiado corto (<6)
    @Test
    void testEmailTooShort() {
        assertFalse(validator.isValidEmail("a@b.c"), "Debe ser inválido por longitud mínima");
    }

    // 5. Correo demasiado largo (>254)
    @Test
    void testEmailTooLong() {
        String longEmail = "a".repeat(250) + "@dominio.com";
        assertFalse(validator.isValidEmail(longEmail), "Debe ser inválido por longitud máxima");
    }

    // 6. Correo con espacios
    @Test
    void testEmailWithSpaces() {
        assertFalse(validator.isValidEmail("cliente @tienda.com"), "Debe ser inválido por contener espacios");
    }

    // 7. Correo sin '@'
    @Test
    void testEmailWithoutAt() {
        assertFalse(validator.isValidEmail("usuario.gmail.com"), "Debe ser inválido por falta de @");
    }

    // 8. Correo sin punto en dominio
    @Test
    void testEmailWithoutDotInDomain() {
        assertFalse(validator.isValidEmail("usuario@dominio"), "Debe ser inválido por falta de punto en dominio");
    }
    @Test
    void testEmailWithDotInDomain() {
        assertTrue(validator.isValidEmail("usuario@dominio.com"), "Debe ser válido ");
    }

    // 9. Correo con extensión inválida
    @Test
    void testEmailInvalidExtension() {
        assertFalse(validator.isValidEmail("usuario@dominio.xyz"), "Debe ser inválido por extensión no permitida");
    }

    // 10. Correo con punto al inicio o final en parte local
    @Test
    void testEmailStartsOrEndsWithDot() {
        assertAll("Punto inválido en parte local",
                () -> assertFalse(validator.isValidEmail(".usuario@tienda.com"), "No debe iniciar con punto"),
                () -> assertFalse(validator.isValidEmail("usuario.@tienda.com"), "No debe terminar con punto")
        );
    }

    // 11. Correo con dos puntos consecutivos en parte local
    @Test
    void testEmailWithDoubleDot() {
        assertFalse(validator.isValidEmail("usu..ario@tienda.com"), "No debe tener dos puntos consecutivos");
    }

    // 12. Correo con menos de 2 caracteres antes del punto en dominio
    @Test
    void testEmailDomainTooShortBeforeDot() {
        assertFalse(validator.isValidEmail("usuario@a.com"), "Debe ser inválido por dominio corto");
    }

    // 13. Comparación explícita (assertEquals)
    @Test
    void testEmailEqualsExpected() {
        String email = "cliente123@tienda.com";
        assertEquals(true, validator.isValidEmail(email), "Debe coincidir con el valor esperado");
    }

    @Test
    void testEmailInvalidCharacterInLocalPart() {
        assertFalse(new Email().isValidEmail("cli*ente@tienda.com"), "Debe ser inválido por caracter no permitido en la parte local");
    }

}
