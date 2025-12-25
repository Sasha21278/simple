PrimeReader – Uživatelská dokumentace

Verze: 1.0 Datum: 25.12.2025

Udelal: Bc.Diakonov Aleksandr

________________________________________
1. O projektu
PrimeReader je konzolová aplikace v jazyce Java, která slouží k automatizované analýze Excel souborů (.xlsx). Program načte data ze souboru, extrahuje číselné hodnoty z druhého sloupce (sloupec B) a identifikuje všechna prvočísla. Nalezená prvočísla jsou následně vypsána do konzole.
Hlavní funkce:
•	Rychlé čtení formátu .xlsx (pomocí knihovny Apache POI).
•	Efektivní algoritmus pro hledání prvočísel.
•	Ignorování textu a prázdných buněk.
•	Přehledné logování výsledků.
________________________________________
2. Systémové požadavky
Pro správné fungování aplikace je nutné mít nainstalovaný následující software:
•	Java (JDK): Verze 17 nebo novější.
•	Apache Maven: Pro sestavení projektu (verze 3.8+).
________________________________________
3. Instalace a sestavení (Build)
Aplikace je distribuována jako zdrojový kód. Před prvním spuštěním je nutné vytvořit spustitelný soubor .jar.
1.	Otevřete terminál (příkazový řádek) v kořenové složce projektu.
2.	Spusťte následující příkaz:
Bash
mvn clean package
Po úspěšném dokončení se ve složce target/ vytvoří soubor prime-reader-1.0.jar (název se může lišit dle verze v pom.xml), který obsahuje všechny potřebné knihovny.
________________________________________
4. Použití aplikace
Aplikace se spouští z příkazového řádku. Jako parametr přijímá cestu k souboru Excel, který chcete zpracovat.
Příkaz pro spuštění:
Bash
java -jar target/prime-reader-1.0.jar "cesta/k/souboru.xlsx"
Příklad:
Bash
java -jar target/prime-reader-1.0.jar "C:\Users\Alien\Downloads\data.xlsx"
Výstup programu: Program vypíše seznam nalezených prvočísel:
Plaintext
[INFO] Zahajuji čtení souboru: C:\Users\Alien\Downloads\data.xlsx
[INFO] 5645657
[INFO] 15619
[INFO] 7
[INFO] ...
________________________________________
5. Struktura projektu
Stručný popis klíčových souborů pro vývojáře:
•	Main.java: Vstupní bod aplikace. Kontroluje parametry a spouští čtení souboru.
•	ExcelReader.java: Zajišťuje otevírání souboru a iteraci přes řádky v Excelu.
•	PrimeChecker.java: Obsahuje matematickou logiku pro ověření, zda je číslo prvočíslem (test dělitelnosti).
•	PrimeCheckerTest.java: Obsahuje unit testy pro ověření správnosti výpočtů.
•	pom.xml: Konfigurace projektu Maven a závislostí (Apache POI, SLF4J, JUnit).
________________________________________
6. Řešení problémů
Chyba: "Nebyly zadány vstupní parametry"
•	Příčina: Nespustili jste program s cestou k souboru.
•	Řešení: Přidejte cestu k souboru na konec příkazu (viz sekce Použití).
Chyba: "Soubor nenalezen"
•	Příčina: Zadaná cesta k souboru je neplatná.
•	Řešení: Zkontrolujte název souboru a zda cesta neobsahuje překlepy. Pokud cesta obsahuje mezery, dejte ji do uvozovek.
