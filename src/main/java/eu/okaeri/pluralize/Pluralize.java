package eu.okaeri.pluralize;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public final class Pluralize {

    private static final Map<String, Function<Integer, Integer>> PLURALIZERS = new HashMap<>();
    private static final Map<String, Integer> PLURALS = new HashMap<>();

    static {
        add("ach", 2, n -> (n > 1) ? 1 : 0); // Acholi
        add("af", 2, n -> (n == 1) ? 0 : 1); // Afrikaans
        add("ak", 2, n -> (n > 1) ? 1 : 0); // Akan
        add("am", 2, n -> (n > 1) ? 1 : 0); // Amharic
        add("an", 2, n -> (n == 1) ? 0 : 1); // Aragonese
        add("anp", 2, n -> (n == 1) ? 0 : 1); // Angika
        add("ar", 6, n -> ((n == 0) ? 0 : ((n == 1) ? 1 : ((n == 2) ? 2 : ((((n % 100) >= 3) && ((n % 100) <= 10)) ? 3 : (((n % 100) >= 11) ? 4 : 5)))))); // Arabic [#f1]_
        add("arn", 2, n -> (n > 1) ? 1 : 0); // Mapudungun
        add("as", 2, n -> (n == 1) ? 0 : 1); // Assamese
        add("ast", 2, n -> (n == 1) ? 0 : 1); // Asturian
        add("ay", 1, n -> 0); // Aymará
        add("az", 2, n -> (n == 1) ? 0 : 1); // Azerbaijani
        add("be", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Belarusian
        add("bg", 2, n -> (n == 1) ? 0 : 1); // Bulgarian
        add("bn", 2, n -> (n == 1) ? 0 : 1); // Bengali
        add("bo", 1, n -> 0); // Tibetan
        add("br", 2, n -> (n > 1) ? 1 : 0); // Breton
        add("brx", 2, n -> (n == 1) ? 0 : 1); // Bodo
        add("bs", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Bosnian
        add("ca", 2, n -> (n == 1) ? 0 : 1); // Catalan
        add("cgg", 1, n -> 0); // Chiga
        add("cs", 3, n -> (n == 1) ? 0 : (((n >= 2) && (n <= 4)) ? 1 : 2)); // Czech
        add("csb", 3, n -> (n == 1) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2)); // Kashubian
        add("cy", 4, n -> (n == 1) ? 0 : ((n == 2) ? 1 : (((n != 8) && (n != 11)) ? 2 : 3))); // Welsh
        add("da", 2, n -> (n == 1) ? 0 : 1); // Danish
        add("de", 2, n -> (n == 1) ? 0 : 1); // German
        add("doi", 2, n -> (n == 1) ? 0 : 1); // Dogri
        add("dz", 1, n -> 0); // Dzongkha
        add("el", 2, n -> (n == 1) ? 0 : 1); // Greek
        add("en", 2, n -> (n == 1) ? 0 : 1); // English
        add("eo", 2, n -> (n == 1) ? 0 : 1); // Esperanto
        add("es", 2, n -> (n == 1) ? 0 : 1); // Spanish
        add("es_AR", 2, n -> (n == 1) ? 0 : 1); // Argentinean Spanish
        add("et", 2, n -> (n == 1) ? 0 : 1); // Estonian
        add("eu", 2, n -> (n == 1) ? 0 : 1); // Basque
        add("fa", 2, n -> (n > 1) ? 1 : 0); // Persian
        add("ff", 2, n -> (n == 1) ? 0 : 1); // Fulah
        add("fi", 2, n -> (n == 1) ? 0 : 1); // Finnish
        add("fil", 2, n -> (n > 1) ? 1 : 0); // Filipino
        add("fo", 2, n -> (n == 1) ? 0 : 1); // Faroese
        add("fr", 2, n -> (n > 1) ? 1 : 0); // French
        add("fur", 2, n -> (n == 1) ? 0 : 1); // Friulian
        add("fy", 2, n -> (n == 1) ? 0 : 1); // Frisian
        add("ga", 5, n -> (n == 1) ? 0 : ((n == 2) ? 1 : (((n > 2) && (n < 7)) ? 2 : (((n > 6) && (n < 11)) ? 3 : 4)))); // Irish
        add("gd", 4, n -> ((n == 1) || (n == 11)) ? 0 : (((n == 2) || (n == 12)) ? 1 : (((n > 2) && (n < 20)) ? 2 : 3))); // Scottish Gaelic
        add("gl", 2, n -> (n == 1) ? 0 : 1); // Galician
        add("gu", 2, n -> (n == 1) ? 0 : 1); // Gujarati
        add("gun", 2, n -> (n > 1) ? 1 : 0); // Gun
        add("ha", 2, n -> (n == 1) ? 0 : 1); // Hausa
        add("he", 2, n -> (n == 1) ? 0 : 1); // Hebrew
        add("hi", 2, n -> (n == 1) ? 0 : 1); // Hindi
        add("hne", 2, n -> (n == 1) ? 0 : 1); // Chhattisgarhi
        add("hr", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Croatian
        add("hu", 2, n -> (n == 1) ? 0 : 1); // Hungarian
        add("hy", 2, n -> (n == 1) ? 0 : 1); // Armenian
        add("ia", 2, n -> (n == 1) ? 0 : 1); // Interlingua
        add("id", 1, n -> 0); // Indonesian
        add("is", 2, n -> (((n % 10) != 1) || ((n % 100) == 11)) ? 1 : 0); // Icelandic
        add("it", 2, n -> (n == 1) ? 0 : 1); // Italian
        add("ja", 1, n -> 0); // Japanese
        add("jbo", 1, n -> 0); // Lojban
        add("jv", 2, n -> (n == 0) ? 0 : 1); // Javanese
        add("ka", 1, n -> 0); // Georgian
        add("kk", 2, n -> (n == 1) ? 0 : 1); // Kazakh
        add("kl", 2, n -> (n == 1) ? 0 : 1); // Greenlandic
        add("km", 1, n -> 0); // Khmer
        add("kn", 2, n -> (n == 1) ? 0 : 1); // Kannada
        add("ko", 1, n -> 0); // Korean
        add("ku", 2, n -> (n == 1) ? 0 : 1); // Kurdish
        add("kw", 4, n -> (n == 1) ? 0 : ((n == 2) ? 1 : ((n == 3) ? 2 : 3))); // Cornish
        add("ky", 2, n -> (n == 1) ? 0 : 1); // Kyrgyz
        add("lb", 2, n -> (n == 1) ? 0 : 1); // Letzeburgesch
        add("ln", 2, n -> (n > 1) ? 1 : 0); // Lingala
        add("lo", 1, n -> 0); // Lao
        add("lt", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Lithuanian
        add("lv", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((n != 0) ? 1 : 2))); // Latvian
        add("mai", 2, n -> (n == 1) ? 0 : 1); // Maithili
        add("me", 3, n -> (((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2)); // Montenegro
        add("mfe", 2, n -> (n > 1) ? 1 : 0); // Mauritian Creole
        add("mg", 2, n -> (n > 1) ? 1 : 0); // Malagasy
        add("mi", 2, n -> (n > 1) ? 1 : 0); // Maori
        add("ml", 2, n -> (n == 1) ? 0 : 1); // Malayalam
        add("mn", 2, n -> (n == 1) ? 0 : 1); // Mongolian
        add("mni", 2, n -> (n == 1) ? 0 : 1); // Manipuri
        add("mnk", 3, n -> ((n == 0) ? 0 : ((n == 1) ? 1 : 2))); // Mandinka
        add("mr", 2, n -> (n == 1) ? 0 : 1); // Marathi
        add("ms", 1, n -> 0); // Malay
        add("mt", 4, n -> ((n == 1) ? 0 : (((n == 0) || (((n % 100) > 1) && ((n % 100) < 11))) ? 1 : ((((n % 100) > 10) && ((n % 100) < 20)) ? 2 : 3)))); // Maltese
        add("my", 1, n -> 0); // Burmese
        add("nah", 2, n -> (n == 1) ? 0 : 1); // Nahuatl
        add("nap", 2, n -> (n == 1) ? 0 : 1); // Neapolitan
        add("nb", 2, n -> (n == 1) ? 0 : 1); // Norwegian Bokmal
        add("ne", 2, n -> (n == 1) ? 0 : 1); // Nepali
        add("nl", 2, n -> (n == 1) ? 0 : 1); // Dutch
        add("nn", 2, n -> (n == 1) ? 0 : 1); // Norwegian Nynorsk
        add("no", 2, n -> (n == 1) ? 0 : 1); // Norwegian (old code)
        add("nso", 2, n -> (n == 1) ? 0 : 1); // Northern Sotho
        add("oc", 2, n -> (n > 1) ? 1 : 0); // Occitan
        add("or", 2, n -> (n == 1) ? 0 : 1); // Oriya
        add("pa", 2, n -> (n == 1) ? 0 : 1); // Punjabi
        add("pap", 2, n -> (n == 1) ? 0 : 1); // Papiamento
        add("pl", 3, n -> ((n == 1) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Polish
        add("pms", 2, n -> (n == 1) ? 0 : 1); // Piemontese
        add("ps", 2, n -> (n == 1) ? 0 : 1); // Pashto
        add("pt", 2, n -> (n == 1) ? 0 : 1); // Portuguese
        add("pt_BR", 2, n -> (n > 1) ? 1 : 0); // Brazilian Portuguese
        add("rm", 2, n -> (n == 1) ? 0 : 1); // Romansh
        add("ro", 3, n -> ((n == 1) ? 0 : (((n == 0) || (((n % 100) > 0) && ((n % 100) < 20))) ? 1 : 2))); // Romanian
        add("ru", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Russian
        add("rw", 2, n -> (n == 1) ? 0 : 1); // Kinyarwanda
        add("sah", 1, n -> 0); // Yakut
        add("sat", 2, n -> (n == 1) ? 0 : 1); // Santali
        add("sco", 2, n -> (n == 1) ? 0 : 1); // Scots
        add("sd", 2, n -> (n == 1) ? 0 : 1); // Sindhi
        add("se", 2, n -> (n == 1) ? 0 : 1); // Northern Sami
        add("si", 2, n -> (n == 1) ? 0 : 1); // Sinhala
        add("sk", 3, n -> (n == 1) ? 0 : (((n >= 2) && (n <= 4)) ? 1 : 2)); // Slovak
        add("sl", 4, n -> (((n % 100) == 1) ? 0 : (((n % 100) == 2) ? 1 : ((((n % 100) == 3) || ((n % 100) == 4)) ? 2 : 3)))); // Slovenian
        add("so", 2, n -> (n == 1) ? 0 : 1); // Somali
        add("son", 2, n -> (n == 1) ? 0 : 1); // Songhay
        add("sq", 2, n -> (n == 1) ? 0 : 1); // Albanian
        add("sr", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Serbian
        add("su", 1, n -> 0); // Sundanese
        add("sv", 2, n -> (n == 1) ? 0 : 1); // Swedish
        add("sw", 2, n -> (n == 1) ? 0 : 1); // Swahili
        add("ta", 2, n -> (n == 1) ? 0 : 1); // Tamil
        add("te", 2, n -> (n == 1) ? 0 : 1); // Telugu
        add("tg", 2, n -> (n > 1) ? 1 : 0); // Tajik
        add("th", 1, n -> 0); // Thai
        add("ti", 2, n -> (n > 1) ? 1 : 0); // Tigrinya
        add("tk", 2, n -> (n == 1) ? 0 : 1); // Turkmen
        add("tr", 2, n -> (n > 1) ? 1 : 0); // Turkish
        add("tt", 1, n -> 0); // Tatar
        add("ug", 1, n -> 0); // Uyghur
        add("uk", 3, n -> ((((n % 10) == 1) && ((n % 100) != 11)) ? 0 : ((((n % 10) >= 2) && ((n % 10) <= 4) && (((n % 100) < 10) || ((n % 100) >= 20))) ? 1 : 2))); // Ukrainian
        add("ur", 2, n -> (n == 1) ? 0 : 1); // Urdu
        add("uz", 2, n -> (n > 1) ? 1 : 0); // Uzbek
        add("vi", 1, n -> 0); // Vietnamese
        add("wa", 2, n -> (n > 1) ? 1 : 0); // Walloon
        add("wo", 1, n -> 0); // Wolof
        add("yo", 2, n -> (n == 1) ? 0 : 1); // Yoruba
        add("zh", 1, n -> 0); // Chinese [#f2]_
//        add("zh", 2, n -> (n > 1) ? 1 : 0); // Chinese [#f3]_
    }

    private static void add(@NonNull String isoLocale, int nplurals, @NonNull Function<Integer, Integer> pluralizer) {
        PLURALIZERS.put(isoLocale, pluralizer);
        PLURALS.put(isoLocale, nplurals);
    }

    public static Optional<Function<Integer, Integer>> getPluralizer(@NonNull Locale locale) {

        String lang = locale.getLanguage();
        String country = locale.getCountry();

        if (!lang.isEmpty() && !country.isEmpty()) {
            Function<Integer, Integer> pluralizer = PLURALIZERS.get(lang + "_" + country);
            if (pluralizer != null) return Optional.of(pluralizer);
        }

        Function<Integer, Integer> pluralizer = PLURALIZERS.get(lang);
        return Optional.ofNullable(pluralizer);
    }

    @Deprecated
    public static Optional<Function<Integer, Integer>> getPluralizer(@NonNull String isoLocale) {
        return Optional.ofNullable(PLURALIZERS.get(isoLocale));
    }

    public static String pluralize(@NonNull Locale locale, int n, @NonNull String... plurals) {

        Optional<Function<Integer, Integer>> pluralizer = getPluralizer(locale);
        if (!pluralizer.isPresent()) {
            throw new IllegalArgumentException("no pluralizer for locale: " + locale);
        }

        int form = pluralizer.get().apply(n);
        if (form > plurals.length) {
            throw new IllegalArgumentException("not enough plurals provided: " + form + ">" + plurals.length);
        }

        return plurals[form];
    }

    @Deprecated
    public static String pluralize(@NonNull String isoLocale, int n, @NonNull String... plurals) {

        Optional<Function<Integer, Integer>> pluralizer = getPluralizer(isoLocale);
        if (!pluralizer.isPresent()) {
            throw new IllegalArgumentException("no pluralizer for locale: " + isoLocale);
        }

        int form = pluralizer.get().apply(n);
        if (form > plurals.length) {
            throw new IllegalArgumentException("not enough plurals provided: " + form + ">" + plurals.length);
        }

        return plurals[form];
    }

    public static int plurals(@NonNull Locale locale) {

        String lang = locale.getLanguage();
        String country = locale.getCountry();

        if (!lang.isEmpty() && !country.isEmpty()) {
            Integer plurals = PLURALS.get(lang + "_" + country);
            if (plurals != null) return plurals;
        }

        Integer plurals = PLURALS.get(lang);
        if (plurals == null) {
            throw new IllegalArgumentException("no plurals info for locale: " + locale);
        }

        return plurals;
    }

    @Deprecated
    public static int plurals(@NonNull String isoLocale) {

        Integer plurals = PLURALS.get(isoLocale);
        if (plurals == null) {
            throw new IllegalArgumentException("no plurals info for locale: " + isoLocale);
        }

        return plurals;
    }
}
