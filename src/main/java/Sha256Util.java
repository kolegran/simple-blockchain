import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public final class Sha256Util {

    // TODO: A1
    public static String applySha256(String input) {
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // TODO: A2
            final byte[] hash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));

            final StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    stringBuilder.append(hex);
                }
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
