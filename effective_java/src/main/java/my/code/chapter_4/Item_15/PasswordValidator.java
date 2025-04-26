package my.code.chapter_4.Item_15;

/**
 * ✏️ Завдання:
 * Напиши клас PasswordValidator, який перевіряє,
 * чи є пароль надійним (містить хоча б 8 символів, хоча б одну цифру і одну велику літеру).
 * І зроби так, щоб допоміжні методи не були доступні ззовні.
 */
public class PasswordValidator {

    public static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               containsDigit(password) &&
               containsUpperCase(password);
    }

    private static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}
