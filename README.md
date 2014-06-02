# poet

> Poet elevates your writing, both poetry and prose, to a higher plane of literary existence.

Witness a small sample of its power:
```clojure
(thats-gr8 "ingrate") ;; substitutes the -ate suffix with an 8
;=> "ingr8"

(dalek "next") ;; exterminates 'e's the precede 'x's
;=> "nxt"
```


Just kidding, poet makes your writing terrible. :hankey:

I'm currently reading through the second edition of [The Joy of Clojure](http://www.manning.com/fogus2/) and this project is just a fun way to play around with the language.  It uses `clojure-opennlp` to tokenize and detokenize text and detect sentences and contains a variety of toy functions that can be mapped over tokenized text.

## License

Copyright © 2014 Tim Downey

Distributed under the Eclipse Public License version 1.0.
