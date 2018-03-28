package model;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jarbas.ActionTaker.BasicActionTaker;
import br.com.jarbas.model.entity.Acao;
import br.com.jarbas.service.AcaoService;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import tts.TextToSpeech;

@Component
public class Main {
	// private static ApplicationContext ac = new
	// ClassPathXmlApplicationContext(new String[]
	// {"/META-INF/spring-autoscan.xml"});
//	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
//			"/META-INF/spring-autoscan.xml");

	@Autowired(required=true)
	public AcaoService acaoService;

	// Necessary
	EnglishNumberToString numberToString = new EnglishNumberToString();
	EnglishStringToNumber stringToNumber = new EnglishStringToNumber();
	static TextToSpeech textToSpeech = new TextToSpeech();
	static EntityManager em;

	// Logger
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	// Variables
	private String result;
	private boolean talkingToMe;
	
	List<Acao> acoes;

	static BasicActionTaker actiontaker;
	// Threads
	Thread speechThread;
	Thread resourcesThread;

	// LiveRecognizer
	private static LiveSpeechRecognizer recognizer;


	public static void main(String[] args) {
		
		Main m = new Main();
		
		textToSpeech.setVoice("cmu-slt-hsmm");
		// Loading Message
//		logger.log(Level.INFO, "Loading..\n");

		// Configuration
//		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		String acousticModelPath = "resource:/edu/cmu/sphinx/models/en-us/en-us";
//		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		String dictionaryPath = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
//		configuration.setGrammarPath("resource:/grammars");
		String grammarPath = "resource:/grammars";
		
//		configuration.setGrammarName("grammar");
		String grammarName = "grammar";
		m.setupRecognizer(acousticModelPath,dictionaryPath, grammarPath, grammarName);

		// Start the Thread
		m.startSpeechThread();
		m.startResourcesThread();
	}
	
	private void setupRecognizer(String acusticModelPath, String dictionaryPath, String grammarPath, String grammarName) {
		Configuration configuration = new Configuration();

		// Load model from the jar
		configuration.setAcousticModelPath(acusticModelPath);
		configuration.setDictionaryPath(dictionaryPath);

		// if you want to use LanguageModelPath disable the 3 lines after which
		// are setting a custom grammar->

		// configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin")

		// Grammar
		configuration.setGrammarPath(grammarPath);
		configuration.setGrammarName(grammarName);
		// configuration.
		configuration.setUseGrammar(true);

		try {
			if (recognizer != null) {
				recognizer.stopRecognition();
				recognizer.setGrammar(configuration);
				
				
			}
			else {
				recognizer = new LiveSpeechRecognizer(configuration);
			}
			
			
		} catch (IOException ex) {
//			logger.log(Level.SEVERE, null, ex);
		}

		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);
	}
	/**
	 * Starting the main Thread of speech recognition
	 */
	protected void startSpeechThread() {
		
		// alive?
		if (speechThread != null && speechThread.isAlive())
			return;

		// initialise
		speechThread = new Thread(() -> {
			logger.log(Level.INFO, "You can start to speak...\n");
			try {

				while (true) {
					/*
					 * This method will return when the end of speech is
					 * reached. Note that the end pointer will determine the end
					 * of speech.
					 */
					SpeechResult speechResult = recognizer.getResult();
					if (speechResult != null) {

						result = speechResult.getHypothesis();
						if ("computer".equals(result) && !talkingToMe) {
							textToSpeech.speak("What can i do for you sir?", 1.0f, false, true);
							talkingToMe = true;
						} else if (talkingToMe) {
							makeDecision(result);
						}
						System.out.println("You said: [" + result + "]\n");

						// logger.log(Level.INFO, "You said: " + result + "\n")

					}

				}
			} catch (Exception ex) {
				logger.log(Level.WARNING, null, ex);
			}

			logger.log(Level.INFO, "SpeechThread has exited...");
		});

		// Start
		speechThread.start();

	}

	/**
	 * Starting a Thread that checks if the resources needed to the
	 * SpeechRecognition library are available
	 */
	protected void startResourcesThread() {

		// alive?
		if (resourcesThread != null && resourcesThread.isAlive())
			return;

		resourcesThread = new Thread(() -> {
//			try {
//
//				// Detect if the microphone is available
//				while (true) {
//					if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
//						// logger.log(Level.INFO, "Microphone is available.\n")
//					} else {
//						// logger.log(Level.INFO, "Microphone is not
//						// available.\n")
//
//					}
//
//					// Sleep some period
//					Thread.sleep(350);
//				}
//
//			} catch (InterruptedException ex) {
//				logger.log(Level.WARNING, null, ex);
//				resourcesThread.interrupt();
//			}
		});

		// Start
//		resourcesThread.start();
	}

	/**
	 * Takes a decision based on the given result
	 */
	public void makeDecision(String speech) {
		if ("end computer".equals(speech)) {
			textToSpeech.speak("i am glad to serve you  sir", 1.5f, false, true);
			talkingToMe = false;
			return;
		}
		if ("fuck you mary".equalsIgnoreCase(speech)) {
			textToSpeech.speak("You too, motherfucker", 1.0f, false, true);
			return;
		} 
		else if ("how are you".equalsIgnoreCase(speech)) {
			textToSpeech.speak("i am bored, do you wanna fuck?", 1.5f, false, true);
			return;
		} 
		else if ("market list".equalsIgnoreCase(speech)) {
			String acusticModelPath = "resource:/edu/cmu/sphinx/models/en-us/en-us";
//			configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
			String dictionaryPath = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
//			configuration.setGrammarPath("resource:/grammars");
			String grammarPath = "resource:/grammars";
			
//			configuration.setGrammarName("grammar");
			String grammarName = "marketList";
			setupRecognizer(acusticModelPath, dictionaryPath, grammarPath, grammarName);
			return;
		}
		

		// Split the sentence
		String[] array = speech.split(" ");

		// return if user said only one number
		if (array.length != 3)
			return;

		// Find the two numbers
		int number1 = stringToNumber.convert(array[0]);
		int number2 = stringToNumber.convert(array[2]);

		// Calculation result in int representation
		int calculationResult = 0;
		String symbol = "?";

		// Find the mathematical symbol
		if ("plus".equals(array[1])) {
			calculationResult = number1 + number2;
			symbol = "+";
		} else if ("minus".equals(array[1])) {
			calculationResult = number1 - number2;
			symbol = "-";
		} else if ("multiply".equals(array[1])) {
			calculationResult = number1 * number2;
			symbol = "*";
		} else if ("division".equals(array[1])) {
			calculationResult = number1 / number2;
			symbol = "/";
		}

		String res = numberToString.convert(Math.abs(calculationResult));

		// With words
		System.out.println("Said:[ " + speech + " ]\n\t\t which after calculation is:[ "
				+ (calculationResult >= 0 ? "" : "minus ") + res + " ] \n");

		// With numbers and math
		System.out.println("Said:[ " + number1 + " " + symbol + " " + number2 + "]\n\t\t which after calculation is:[ "
				+ calculationResult + " ]");

		// Speak Mary Speak
		textToSpeech.speak((calculationResult >= 0 ? "" : "minus ") + res, 1.5f, false, true);

	}

	/**
	 * Java Main Application Method
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//
////		Main atd = new Main(); // get instance
////		// the magic: auto-wire the instance with all its dependencies:
////		ctx.getAutowireCapableBeanFactory().autowireBeanProperties(atd, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,
////				true);
//		
//
//		tentaSalvar();
//		// // Be sure that the user can't start this application by not giving
//		// the
//		// // correct entry string
//		// if (args.length == 1 && "SPEECH".equalsIgnoreCase(args[0]))
//		new Main();
//		// else
//		// Logger.getLogger(Main.class.getName()).log(Level.WARNING, "Give me
//		// the correct entry string..");
//
//	}

}