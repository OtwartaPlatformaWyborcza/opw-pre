# Otwarta Platforma Wyborcza
1. [Organizacja](https://github.com/OtwartaPlatformaWyborcza/Organizacja#otwarta-platforma-wyborcza)  
2. [Członkowie](https://github.com/OtwartaPlatformaWyborcza/Organizacja#cz%C5%82onkowie)  
3. [Jak do nas dołączyć?](https://github.com/OtwartaPlatformaWyborcza/Organizacja#jak-do-nas-do%C5%82%C4%85czy%C4%87)  


# OPW-PRE
Wybory prezydenckie

# Linki

| Środowisko | Element  | Link  |
| -------------| ------------- | ------------- |
| - | JIRA | https://otwartapw.atlassian.net/  |
| DEV | Maski administracyjne | http://dev.otwartapw.pl/mgmt/  |
| DEV | Serwis inbound | http://dev.otwartapw.pl/inbound |
| DEV | Serwis outbound | http://dev.otwartapw.pl/outbound |
| TEST | Maski administracyjne | http://test.otwartapw.pl/mgmt/  |
| TEST | Serwis inbound | http://test.otwartapw.pl/inbound |
| TEST | Serwis outbound | http://test.otwartapw.pl/outbound |

# Proces

**Przygotowanie wyborów**  
1. Administrator definiuje / importuje oficjalną listę Komisji Okręgowych  (51)  
2. Administrator definiuje / importuje oficjalną listę Kandydatów (11)  
3. Administrator definiuje / importuje oficjalną listę Komisji Obwodowych (około 27 000)
4. Administrator zakłada / importuje konta użytkowników (wolentariusze, mężowie zaufania, około 25 000)  
5. System automatycznie rozsyła hasła użytkowikom, wraz z linkiem do aktywacji konta, na podany adres E-Mail.  
6. Administrator systemu ma możliwość edycji i weryfikacji kont użytkownków wraz ich danymi (możliwa fluktuacja użytkowników tuż przed wyborami)  

**Dzień wyborczy - perspektywa użytkownika**  
1. Użytkownik loguje się na stronie OPW i wybiera z listy jedną z przypisanych mu Komisji Obwodowych.  
2. Użytkownik widzi na okrenie dokładne informacje dotyczące wybranej Komisji Obwodowej.  
3. Użytkownik wpisuje dane / liczby wyborcze z protokołu do aplikacji OPW.  
4. Walidacja protokołu po stronie klienta (JavaScript/HTML5) dla błędów twardych.  
5. Użytkownik wysyła dane/liczby wyborcze na serwer OPW.

**Dzień wyborczy - perspektywa serwera**  
1. Liczby wyborcze spływają na serwer.
2. Każdy protokół jest walidowany, w przypadku identyfikacji błędu miękkiego protokół protokół zostanie otagowany.  
3. Protokoły są zapisywane w bazie danych.  
4. Aktualny wynik wyborów jest publikowany co 5 minut.  

**Dzień wyborczy / perspektywa gościa**  
1. Gość wchodzi na stronę główną aplikacji OPW-dashboard  
2. OPW/dashboard zapewnia dostęp do aktualnych wyników w skali kraju jak i gminy.

# Specyfikacja

## Grupy użytkowników
1. Administrator (admin)
2. Użytkownik (user)
3. Gość (guest)

## Software stack
### Backend
1. Java 8 / Java EE 7 (JPA2, CDI, EJB, JSF 2.2 (PrimeFaces), JAX-RS, JavaMail)
2. MySQL 5.5 (UTF8, InnoDB, MySQL Workbench)
3. REST (RESTEasy)
4. HTML5
5. CSS3
6. Maven 3

### Frontend
1. HTML5
2. JavaScript (AngularJS)
3. CSS3
4. Bootstrap

## Konfiguracja
Konfiguracja systemu OPW-PRE bazuje w całości na podsystemie `naming` kontenera JEE. Poszczególne parametry konfiguracyjne  umieszczone są bezpośrednio w typowanych parametrach JNDI wedle schematu `java:global/opw-pre/<MODUŁ>/<OPCJA>`. Poszczególne moduły OPW-PRE nie implementują `cache` dla parametrów JNDI. Zmiana konfiguracji nie wymaga restartu kontenera JEE.


| Parametr | Wartość | Opis |
| -------------| ------------- | ------------- |
| /opw-pre/register/baseUrl | http://localhost:8080/opw-pre-register-ws/service | Absolutne URI serwisu rejestracji |
| /opw-pre/inbound/baseUrl | http://localhost:8080/opw-pre-inbound-ws/service | Absolutne URI serwisu zapisu danych |
| /opw-pre/outbound/baseUrl | http://localhost:8080/opw-pre-outbound-ws/service | Absolutne URI serwisu odczytu danych |
## REST
Proces wgrywania protokołu z perspektywy użytkownika.  

| Numer | Metoda | Opis |
| -------------| ------------- | ------------- |
| 1 | `POST` | Zalogowanie |
| 2 | `GET` | Lista komisji obwodowych które użytkownik dodał do własnego profilu  |
| 3 | `GET` | Detale wybranej komisji obwodowej (dane podstawowe, lista kandydatów, lista protokołów) |
| 4 | `POST` | Upload liczb wyborczych |
| 5 | `GET` | Wylogowanie |


### Headers
Jako prefix `X-OPW`
* `X-OPW-login`
* `X-OPW-password`
* `X-OPW-token`
* `X-OPW-API-client`
* `X-OPW-API-token`
* `X-OPW-debug-500`


# Roadmap
Plan realizacji systemu OPW-PRE.

### Wersja 0.4.0
Integracja komisji obwodowej. Integracja standardowego theme [bootstrap](getbootstrap.com).  
* [x] [PRE-30](https://otwartapw.atlassian.net/browse/PRE-30) Migracja WildFly 10.0.0.Final
* [x] [PRE-36](https://otwartapw.atlassian.net/browse/PRE-36) Serwer WildFly jako Maven module projektu
* [x] [PRE-25](https://otwartapw.atlassian.net/browse/PRE-25) Definicja API serwisu REST dla komisji obwodowej
* [ ] [PRE-19](https://otwartapw.atlassian.net/browse/PRE-19) Środowisko DEV i TEST
* [ ] [PRE-26](https://otwartapw.atlassian.net/browse/PRE-26) Implementacja serwisu REST dla komisji obwodowej
* [ ] [PRE-27](https://otwartapw.atlassian.net/browse/PRE-27) Generator danych dla komisji obwodowej  
* [ ] [PRE-18](https://otwartapw.atlassian.net/browse/PRE-18) Integracja bootstrap w panelu administracyjnym
* [ ] [PRE-28](https://otwartapw.atlassian.net/browse/PRE-28) Reset hasła wolontariusza
* [ ]  [PRE-34](https://otwartapw.atlassian.net/browse/PRE-34) Aktywacja i deaktywacja konta wolontariusza w panelu administracyjnym
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35) Zamknięcie listy kandydatów w panelu administracyjnym
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35)Lista komisji wolontariusza w panelu administracyjnym
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35)Zarządzanie listą komisji obwodowych wolontariusza w panelu administracyjnym
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35)Upload liczb wyborczych w panelu administracyjnym
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35)Aktywacja konta wolontariusza poprzez link
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35)Samodzielny reset hasła
* [ ]  [PRE-35](https://otwartapw.atlassian.net/browse/PRE-35)Dane dostępowe wolontariusza poprzez E-Mail  



### Wersja 0.5.0
Integracja docker'a. Import z plików CSV.
* [PRE-4](https://otwartapw.atlassian.net/browse/PRE-4) TBD
* Import CSV dla kont użytkowników
* Import CSV dla kandydatów
* Import CSV dla województw
* Import CSV dla komisji okręgowych
* Import CSV dla komisji obwodowych
* Import CSV dla komisji obwodowych

### Wersja 0.6.0
Zabezpieczenie masek administracyjnych.
* [PRE-24](https://otwartapw.atlassian.net/browse/PRE-24) Zabezpieczenie masek administracyjnych
* [PRE-4](https://otwartapw.atlassian.net/browse/PRE-4) TBD Koncepcja monitoringu serwisów
* Definicja szablonu SMS
* Podbieranie protokołów przesłanych na skrzynke pocztową
* Automatyczne parsowanie protokołów ze skrzynki pocztowej
  * import poprawnych protokołów
  * tagowanie błędnych protokołów
* tagowanie błędnych protokołów


### Wersja 0.7.0
Nowe funkcje TBD.
* [PRE-4](https://otwartapw.atlassian.net/browse/PRE-4) TBD Implementacja monitoringu serwisów

### Wersja 0.8.0
Nowe funkcje TBD.

### Wersja 0.9.0
Implementacja testów wydajnościowych.

### Wersja 0.10.0
Stabilizacja aplikacji.

### Wersja 0.11.0
beta (automatyczna symulacja wyborów)

### Wersja 0.12.0
RC1 (automatyczna symulacja wyborów)

### Wersja 0.13.0
RC2 (automatyczna symulacja wyborów)

### Wersja 1.0.0
stable release

# Changelog

### Wersja 0.3.0 [wydana 2016.07.26]
Rejestracja wolontariusza
* [x] [PRE-1](https://otwartapw.atlassian.net/browse/PRE-1) Formularz rejestracji wolontariusza JSF
* [x] [PRE-21](https://otwartapw.atlassian.net/browse/PRE-21) Definicja API serwisu REST rejestracji wolontariusza
* [x] [PRE-20](https://otwartapw.atlassian.net/browse/PRE-20) Integracja [bootstrap](getbootstrap.com) w formularzu rejestracji wolontariusza
* [x] [PRE-23](https://otwartapw.atlassian.net/browse/PRE-23) Implementacja serwisu REST rejestracji wolontariusza
* [x] [PRE-22](https://otwartapw.atlassian.net/browse/PRE-22) VersionBuilder
* [x] [PRE-29](https://otwartapw.atlassian.net/browse/PRE-29) Definicja struktury JNDI  

### Wersja 0.2.0 [wydana 2015.11.12]
Implementacja masek administracyjnych.  
* [x] [PRE-7](https://otwartapw.atlassian.net/browse/PRE-7) Maski administracyjne: Komisja Okregowa
* [x] [PRE-8](https://otwartapw.atlassian.net/browse/PRE-8) Maski administracyjne: Komisja Obwodowa
* [x] [PRE-9](https://otwartapw.atlassian.net/browse/PRE-9) Maski administracyjne: Województwo
* [x] [PRE-10](https://otwartapw.atlassian.net/browse/PRE-10) Maski administracyjne: Protokół
* [x] [PRE-11](https://otwartapw.atlassian.net/browse/PRE-11) Maski administracyjne: Link
* [x] [PRE-12](https://otwartapw.atlassian.net/browse/PRE-12) Maski administracyjne: Konfiguracja
* [x] [PRE-13](https://otwartapw.atlassian.net/browse/PRE-13) Maski administracyjne: Użytkownik
* [x] [PRE-15](https://otwartapw.atlassian.net/browse/PRE-15) Maski administracyjne: Kandydat

### Wersja 0.1.0 [wydana 2015.10.22]
Refactoring struktury projektu, architektury jak i podstawowych komponentów API.  
* [x] [PRE-2](https://otwartapw.atlassian.net/browse/PRE-2) Refactoring struktury projektu
* [x] [PRE-3](https://otwartapw.atlassian.net/browse/PRE-3) DB limit kandydatów
* [x] [PRE-5](https://otwartapw.atlassian.net/browse/PRE-5) Koncepcja serwisu GET Version
* [x] [PRE-6](https://otwartapw.atlassian.net/browse/PRE-6) Definicja artefaktu commons
