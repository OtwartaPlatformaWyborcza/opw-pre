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

### Wersja 0.3.0
Rejestracja wolontariusza
* [PRE-1](https://otwartapw.atlassian.net/browse/PRE-1) Formularz rejestracji wolontariusza JSF
* [PRE-4](https://otwartapw.atlassian.net/browse/PRE-4) Definicja serwisu rejestracji REST
* [PRE-20](https://otwartapw.atlassian.net/browse/PRE-20) Integracja [bootstrap](getbootstrap.com)

### Wersja 0.4.0
Integracja komisji obwodowej. Zabezpieczenie masek administracyjnych. Integracja standardowego theme [bootstrap](getbootstrap.com).  
* [PRE-4]((https://otwartapw.atlassian.net/browse/PRE-4) TBD
* Zabezpieczenie masek administracyjnych (Autoryzacja / Autentyfikacja)
* Generator danych dla komisji obwodowej.  
* [PRE-18]((https://otwartapw.atlassian.net/browse/PRE-18) Integracja bootstrap
* [PRE-19]((https://otwartapw.atlassian.net/browse/PRE-19) Środowisko DEV i TEST
* Dodanie

### Wersja 0.5.0
Integracja docker'a.
* [PRE-4](https://otwartapw.atlassian.net/browse/PRE-4) TBD

### Wersja 0.6.0
Nowe funkcje TBD.
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
