package edu.cmu.sphinx.linguist.dictionary;

import edu.cmu.sphinx.linguist.acoustic.UnitManager;
import edu.cmu.sphinx.util.props.Configurable;
import edu.cmu.sphinx.util.props.S4Component;
import edu.cmu.sphinx.util.props.S4Integer;
import edu.cmu.sphinx.util.props.S4String;
import java.io.IOException;

public abstract interface Dictionary
  extends Configurable
{
  public static final String SENTENCE_START_SPELLING = "<s>";
  public static final String SENTENCE_END_SPELLING = "</s>";
  public static final String SILENCE_SPELLING = "<sil>";
  @S4String
  public static final String PROP_DICTIONARY = "dictionaryPath";
  @S4String(defaultValue="")
  public static final String PROP_G2P_MODEL_PATH = "g2pModelPath";
  @S4Integer(defaultValue=1)
  public static final String PROP_G2P_MAX_PRONUNCIATIONS = "g2pMaxPron";
  @S4String
  public static final String PROP_FILLER_DICTIONARY = "fillerPath";
  @S4String(mandatory=false)
  public static final String PROP_WORD_REPLACEMENT = "wordReplacement";
  @S4Component(type=UnitManager.class, defaultClass=UnitManager.class)
  public static final String PROP_UNIT_MANAGER = "unitManager";
  @S4String(mandatory=false)
  public static final String PROP_ADDENDA = "addenda";
  
  public abstract Word getWord(String paramString);
  
  public abstract Word getSentenceStartWord();
  
  public abstract Word getSentenceEndWord();
  
  public abstract Word getSilenceWord();
  
  public abstract Word[] getFillerWords();
  
  public abstract void allocate()
    throws IOException;
  
  public abstract void deallocate();
}