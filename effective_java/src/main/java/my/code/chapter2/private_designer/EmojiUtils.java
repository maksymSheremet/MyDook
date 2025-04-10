package my.code.chapter2.private_designer;

import java.util.Map;

public class EmojiUtils {

    private EmojiUtils() {
        throw new AssertionError("Цей клас не можна створити! Користуйся static методами 😜");
    }

    private static final Map<String, String> moodEmojis = Map.of(
            "happy", "😄",
            "sad", "😢",
            "angry", "😡",
            "love", "❤️",
            "party", "🥳",
            "nerdy", "🤓"
    );

    private static final Map<String, String> animalEmojis = Map.of(
            "cat", "🐱",
            "dog", "🐶",
            "monkey", "🐵",
            "unicorn", "🦄",
            "fox", "🦊"
    );

    public static String getMoodEmoji(String mood) {
        return moodEmojis.getOrDefault(mood.toLowerCase(), "🤷‍♂️");
    }

    public static String getAnimalEmoji(String animal) {
        return animalEmojis.getOrDefault(animal.toLowerCase(), "❓");
    }
}
