# SauceDemo Automation Test Framework

## Opis projekta
Ovaj projekt predstavlja automatizirani testni framework za web stranicu [SauceDemo](https://www.saucedemo.com/).  
Omogućava testiranje ključnih funkcionalnosti web aplikacije, uključujući:

- Login s različitim korisnicima  
- Dodavanje proizvoda u košaricu  
- Checkout procesa  
- Sorting (Price: Low to High)

Projekt je razvijen koristeći Javu, Maven, Selenium WebDriver, JUnit 5 i ExtentReport.

---

## Tehnologije i alati

- Java 17  
- Maven (za upravljanje ovisnostima)  
- Selenium WebDriver 4.18.1  
- WebDriverManager 5.5.1 (automatsko preuzimanje drivera)  
- JUnit 5 (test runner)  
- ExtentReports 5.0.9 (generiranje izvještaja i screenshotova)  
- Brave i Chrome browseri  
- Page Object Model (POM)  
- Objektno orijentirani pristup s utils paketom  

---

## Struktura projekta

- `src/test/java/base` – sadrži `BaseTest.java` za setup i teardown testova  
- `src/test/java/pages` – sadrži POM klase: `LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`, `ProducttsPage`  
- `src/test/java/tests` – sadrži test klase: `LoginTest`, `AddToCartTest`, `CheckoutTest`, `SortTest`  
- `src/test/java/utils` – sadrži `DriverFactory`, `ReportManager`, `ScreenshotUtils`  
- `pom.xml` – Maven konfiguracija projekta  
- `.gitignore` – datoteke i folderi koji se ne trebaju pushati  

---


## Izvještaji

- ExtentReports se generiraju u folderu `test-output` pod nazivom `ExtentReport.html`  
- Značajke izvještaja:  
  - Status testova (PASS/FAIL)  
  - Automatski screenshotovi za testove   
  - Vrijeme izvršavanja testova  

- Screenshoti se spremaju u folder `test-output/screenshots`  

---

## Napredne opcije

- Cross-browser testiranje (Brave i Chrome)  
- ScreenshotUtils za automatsko spremanje screenshotova  
- Page Object Model (POM) za organizaciju koda  
- WebDriverManager za automatsko preuzimanje drivera  
- JUnit 5 i Maven Surefire za automatsko pokretanje testova  
- Objektno orijentirani pristup sa BaseTest, utils i pages paketima  
- CI spremno za integraciju s GitHub Actions ili drugim CI/CD alatima  

---

## Testni korisnici

- `standard_user / secret_sauce` – valid login  
- `locked_out_user / secret_sauce` – neuspjeli login  
