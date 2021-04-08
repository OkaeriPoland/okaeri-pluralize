# Okaeri Pluralize

![License](https://img.shields.io/github/license/OkaeriPoland/okaeri-pluralize)
![Total lines](https://img.shields.io/tokei/lines/github/OkaeriPoland/okaeri-pluralize)
![Repo size](https://img.shields.io/github/repo-size/OkaeriPoland/okaeri-pluralize)
![Contributors](https://img.shields.io/github/contributors/OkaeriPoland/okaeri-pluralize)
[![Discord](https://img.shields.io/discord/589089838200913930)](https://discord.gg/hASN5eX)

Simple pluralization library with support for the rules of 143 locales. 
Based on [translate/l10n-guide](https://github.com/translate/l10n-guide/blob/master/docs/l10n/pluralforms.rst).
Part of the [okaeri-placeholders](https://github.com/OkaeriPoland/okaeri-placeholders).

## Installation
### Maven
Add repository to the `repositories` section:
```xml
<repository>
    <id>okaeri-repo</id>
    <url>https://storehouse.okaeri.eu/repository/maven-public/</url>
</repository>
```
Add dependency to the `dependencies` section:
```xml
<dependency>
  <groupId>eu.okaeri</groupId>
  <artifactId>okaeri-pluralize</artifactId>
  <version>1.0.0</version>
</dependency>
```
### Gradle
Add repository to the `repositories` section:
```groovy
maven { url "https://storehouse.okaeri.eu/repository/maven-public/" }
```
Add dependency to the `maven` section:
```groovy
implementation 'eu.okaeri:okaeri-pluralize:1.0.0'
```

## Usage

```java
Pluralize.pluralize(Locale.ENGLISH, -1, "apple", "apples") // apples
Pluralize.pluralize(Locale.ENGLISH, 0, "apple", "apples") // apples
Pluralize.pluralize(Locale.ENGLISH, 1, "apple", "apples") // apple
Pluralize.pluralize(Locale.ENGLISH, 2, "apple", "apples") // apples

Pluralize.pluralize(Locale.forLanguageTag("pl"), -1, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 0, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 1, "pies", "psy", "psów") // pies
Pluralize.pluralize(Locale.forLanguageTag("pl"), 2, "pies", "psy", "psów") // psy
Pluralize.pluralize(Locale.forLanguageTag("pl"), 3, "pies", "psy", "psów") // psy
Pluralize.pluralize(Locale.forLanguageTag("pl"), 4, "pies", "psy", "psów") // psy
Pluralize.pluralize(Locale.forLanguageTag("pl"), 5, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 6, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 20, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 21, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 22, "pies", "psy", "psów") // psy
Pluralize.pluralize(Locale.forLanguageTag("pl"), 23, "pies", "psy", "psów") // psy
Pluralize.pluralize(Locale.forLanguageTag("pl"), 24, "pies", "psy", "psów") // psy
Pluralize.pluralize(Locale.forLanguageTag("pl"), 25, "pies", "psy", "psów") // psów
Pluralize.pluralize(Locale.forLanguageTag("pl"), 26, "pies", "psy", "psów") // psów
```
