
import java.util.Set;

public class Email {

    private static final Set<String> VALID_EXTENSIONS = Set.of(
            "com", "net", "org", "edu", "gov", "pe"
    );

    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        if (email.contains(" ")) {
            return false;
        }

        // Debe contener '@'
        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            return false;
        }

        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // Validar parte local
        if (localPart.startsWith(".") || localPart.endsWith(".")) {
            return false;
        }
        if (localPart.contains("..")) {
            return false;
        }
        if (!localPart.matches("[A-Za-z0-9._-]+")) {
            return false;
        }

        // Validar dominio
        if (!domainPart.contains(".")) {
            return false;
        }
        String[] domainParts = domainPart.split("\\.");
        if (domainParts.length < 2) {
            return false;
        }

        String extension = domainParts[domainParts.length - 1];
        if (!VALID_EXTENSIONS.contains(extension)) {
            return false;
        }

        // Al menos 2 caracteres antes del primer punto
        if (domainParts[0].length() < 2) {
            return false;
        }

        return true;
    }
}
