import java.util.Set;
import java.util.regex.Pattern;

public class PasswordValidatorFull {
        // Lista de caracteres especiales permitidos

    static final Set<Character> SPECIAL_CHARS = Set.of(
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/'
    );

    public static boolean isValid(String password) {
            if (password == null){
                throw new IllegalArgumentException("Password no puede ser null");
            }


            // Regla 1: Longitud
            if (password.length() < 8 || password.length() > 64) {
                return false;
            }

            // Regla 2: No espacios al inicio ni al final
            if (password.startsWith(" ") || password.endsWith(" ")) {
                return false;
            }

            // Regla 3: No espacios consecutivos
            if (password.contains("  ")) {
                return false;
            }

            // Construir carcEspeciales
            String caracEsp = "^[A-Za-z0-9" + Pattern.quote((SPECIAL_CHARS).toString())+ "]+$";

            if (!password.matches(caracEsp)) {
                return false;
            }

            return true;
        }

        public static void main(String[] args) {
            }
}
