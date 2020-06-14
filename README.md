# Pig Latin
## Business requirements
It translates a string (word, sentence, or paragraph) into “pig-latin” using the
following rules:
1. Words that start with a consonant have their first letter moved to the end of the word and the
 letters “ay” added to the end.
   > Hello becomes Ellohay
2. Words that start with a vowel have the letters “way” added to the end.
   > apple becomes appleway
3. Words that end in “way” are not modified.
   > stairway stays as stairway
4. Punctuation must remain in the same relative place from the end of the word.
   > can’t becomes antca’y<br/>
   > end. becomes endway.
5. Hyphens are treated as two words
   > this-thing becomes histay-hingtay
6. Capitalization must remain in the same place.
   > Beach becomes Eachbay<br/>
   > McCloud becomes CcLoudmay

## Open questions
1. Input validation
    1. Numbers, other unicode symbols
    2. Max length
1. Issue: separators (e.g. " ", "-") are erased from the end. Is it acceptable?

## Points to improve
1. To extend language support:
    1. VOWELS should be extended
    1. Locale should be configurable
1. Functional interface can be used instead of "implements Function"
1. Cover TranslateWord with tests
1. Performance improvements are possible
1. Add project management tool
1. Add JavaDoc on public API
1. Use logging (probably, slf4j)
1. Lombok can be used to make code more laconic