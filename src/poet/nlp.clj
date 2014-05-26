(ns poet.nlp
  (:require [opennlp.nlp]))

(def get-sentences (opennlp.nlp/make-sentence-detector "models/en-sent.bin"))
(def tokenize (opennlp.nlp/make-tokenizer "models/en-token.bin"))
(def de-tokenize (opennlp.nlp/make-detokenizer "models/en-detoken.xml"))
(def pos-tag (opennlp.nlp/make-pos-tagger "models/en-pos-maxent.bin"))
