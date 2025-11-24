//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//public class EmailTest {
//        @Test
//        void testValidEmail() {
//            assertTrue(new Email().isValidEmail("cliente123@tienda.com"), "Debe ser válido");
//        }
//
//        @Test
//        void testEmailTooShort() {
//            assertFalse(new Email().isValidEmail("a@b.c"), "Debe ser inválido por longitud mínima");
//        }
//
//        @Test
//        void testEmailWithoutAtOrDomain() {
//            assertAll("Formato inválido",
//                    () -> assertFalse(new Email().isValidEmail("usuario.gmail.com"), "Falta @"),
//                    () -> assertFalse(new Email().isValidEmail("usuario@com"), "Dominio inválido")
//            );
//        }
//
//        @Test
//        void testEmailNullThrowsException() {
//            Exception ex = assertThrows(IllegalArgumentException.class, () -> new Email().isValidEmail(null));
//            assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
//        }
//
//        @Test
//        void testEmailEmptyThrowsException() {
//            assertThrows(IllegalArgumentException.class, () -> new Email().isValidEmail(""), "Debe lanzar excepción por vacío");
//        }
//
//        @Test
//        void testEmailEqualsExpected() {
//            String email = "cliente123@tienda.com";
//            assertEquals(true, new Email().isValidEmail(email), "Debe coincidir con el valor esperado");
//        }
//}
//
