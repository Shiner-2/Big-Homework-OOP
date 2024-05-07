import com.example.hhd.TextToSpeech;

public class TTSTest2 {

    public static void main(String[] args) {
        // Test Google Translator TTS for English to Vietnamese
        System.out.println("Google Translator TTS - English to Vietnamese:");
        TextToSpeech.playSoundGoogleTranslateEnToVi("Hello");

        // Test Google Translator TTS for Vietnamese to English
        System.out.println("Google Translator TTS - Vietnamese to English:");
        TextToSpeech.playSoundGoogleTranslateViToEn("Xin chào");

    }
}