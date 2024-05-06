package com.example.hhd;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;
import java.util.Locale;

public class TTS {
    String voiceName = "kevin16";

    public TTS() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    }

    public void speak(String text) {
        System.out.println("Try speak " + text);
        //System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        try {
            SynthesizerModeDesc desc = new SynthesizerModeDesc(
                    "FUCK YOU",          // engine name
                    "general",     // mode name
                    Locale.US,     // locale
                    null,          // running
                    null);         // voice
            Synthesizer synthesizer = Central.createSynthesizer(desc);

            /* Get the synthesizer ready to speak
             */
            synthesizer.allocate();
            synthesizer.resume();

            /* Choose the voice.
             */
            desc = (SynthesizerModeDesc) synthesizer.getEngineModeDesc();
            Voice[] voices = desc.getVoices();
            Voice voice = null;
            for (int i = 0; i < voices.length; i++) {
                if (voices[i].getName().equals(voiceName)) {
                    voice = voices[i];
                    break;
                }
            }
            synthesizer.getSynthesizerProperties().setVoice(voice);

            /* The synthesizer to speak and wait for it to
             * complete.
             */
            synthesizer.speakPlainText(text, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

            /* Clean up and leave.
             */
            // synthesizer.deallocate();
//            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
