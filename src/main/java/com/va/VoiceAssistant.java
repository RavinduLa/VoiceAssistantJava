package com.va;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class VoiceAssistant {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");


        //config.setDictionaryPath("src/main/resources/2528.dic");
        //config.setLanguageModelPath("src/main/resources/en-70k-0.2.lm");

        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);

            System.out.println("Listening");

            SpeechResult speechResult = null;

            while ( (speechResult = speech.getResult()) != null){
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Voice command is: "+ voiceCommand);

                if (voiceCommand.equalsIgnoreCase("open chrome")){
                    System.out.println("Command detected : open chrome");
                }
                else if(voiceCommand.equalsIgnoreCase("close chrome")){
                    System.out.println("Command detected: close chrome");
                }
                else{
                    System.out.println("Command not recognized");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
