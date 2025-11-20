public class Main {
    public static void main(String[] args) {
        ClassEmployee grupa1 = new ClassEmployee("Programiści", 10);

        // tworzenei pracowników
        Employee empl1 = new Employee("Jan", "Kowalski", EmployeeCondition.OBECNY, 1990, 5000);
        Employee empl2 = new Employee("Piotr", "Nowak", EmployeeCondition.DELEGACJA, 1991, 6000);
        Employee empl3 = new Employee("Adam", "Kowalski", EmployeeCondition.CHORY, 1992, 7000);

        // dodawanie pracownikow do grupy
        System.out.println("dodwanie pracowników:");

        grupa1.addEmployee(empl1);
        grupa1.addEmployee(empl2);
        grupa1.addEmployee(empl3);
        // duplikat
        grupa1.addEmployee(empl1);

        // podsumowanie po dodaniu
        System.out.println("podsumowanie po dodaniu:");
        grupa1.summary();

        // Zmiana stanu
        System.out.println("\nZmiana stanu:");
        grupa1.changeCondition(empl2, EmployeeCondition.NIEOBECNY);

        // Dodanie pensji
        System.out.println("\nDodawanie pensji:");
        grupa1.addSalary(empl1, 500);

        // Wyszukiwanie po nazwisku
        System.out.println("\nWyszukiwanie po nazwisku 'Nowak':");
        Employee found = grupa1.searchByLastName("Nowak");
        if (found != null)
            found.printing();

        // Wyszukiwanie częściowe
        System.out.println("\nWyszukiwanie częściowe (fragment 'ski'):");
        grupa1.searchByPartial("Za").forEach(Employee::printing);
        System.out.println("Ilość wyników: " + grupa1.searchByPartial("ski").size());
        //wyswietlanie wynikow
        grupa1.searchByPartial("ski").forEach(Employee::printing);

        // Sortowanie po nazwisku
        System.out.println("\nSortowanie po nazwisku:");
        grupa1.sortByName().forEach(Employee::printing);

        // Sortowanie po pensji malejąco
        System.out.println("\nSortowanie po pensji malejąco:");
        grupa1.sortbySalary().forEach(Employee::printing);

        // MAX – największy wg compareTo (po nazwisku)
        System.out.println("\nMaksymalny (Collections.max):");
        System.out.println(grupa1.max().getLastName());

        // Liczenie po stanie
        System.out.println("\nIlość NIEOBECNYCH:");
        System.out.println(grupa1.countByCondition(EmployeeCondition.NIEOBECNY));

        // ========== CZĘŚĆ DRUGA ==========
        System.out.println("\n\n========== CZĘŚĆ DRUGA ==========\n");

        // Test ClassContainer
        System.out.println("=== Test ClassContainer ===");
        ClassContainer container = new ClassContainer();
        
        // Dodawanie klas
        System.out.println("\nDodawanie klas:");
        container.addClass("Programiści", 10);
        container.addClass("Testerzy", 5);
        container.addClass("Designerzy", 8);
        
        // Pobieranie listy klas w porządku alfabetycznym
        System.out.println("\nLista klas w porządku alfabetycznym:");
        container.getGroupsInOrder().forEach(System.out::println);
        
        // Podsumowanie
        System.out.println("\nPodsumowanie kontenera:");
        container.summary();
        
        // Dodanie pracowników do różnych grup
        ClassEmployee grupa2 = container.getGroup("Testerzy");
        Employee empl4 = new Employee("Anna", "Wiśniewska", EmployeeCondition.OBECNY, 1988, 5500);
        Employee empl5 = new Employee("Maria", "Dąbrowska", EmployeeCondition.DELEGACJA, 1993, 6500);
        grupa2.addEmployee(empl4);
        grupa2.addEmployee(empl5);
        
        // Liczenie pracowników w klasach
        System.out.println("\nLiczba pracowników w klasach (posortowane):");
        container.countEmployeesInGroups().forEach((k, v) -> 
            System.out.println(k + ": " + v + " pracowników"));
        
        // Znajdowanie pustych klas
        System.out.println("\nPuste klasy:");
        container.findEmpty().forEach(System.out::println);
        
        // Test zmiany trybu przechowywania
        System.out.println("\nTest zmiany trybu przechowywania:");
        container.demonstrateOrderDifferences();
        container.changeStorageMode(StorageMode.LINKED_HASH_MAP);
        container.demonstrateOrderDifferences();
        
        // Test metod ClassEmployee z części drugiej
        System.out.println("\n=== Test metod ClassEmployee z części drugiej ===");
        
        // Usuwanie duplikatów
        System.out.println("\nUsuwanie duplikatów:");
        Employee empl6 = new Employee("Jan", "Kowalski", EmployeeCondition.OBECNY, 1990, 5000);
        grupa1.addEmployee(empl6);
        int removed = grupa1.removeDuplicates();
        System.out.println("Usunięto duplikatów: " + removed);
        
        // Grupowanie po condition
        System.out.println("\nGrupowanie po stanie:");
        grupa1.groupByCondition().forEach((cond, list) -> {
            if (!list.isEmpty()) {
                System.out.println(cond + ":");
                list.forEach(Employee::printing);
            }
        });
        
        // Mediana pensji
        System.out.println("\nMediana pensji: " + grupa1.medianSalary());
        
        // Najstarszy i najmłodszy pracownik
        System.out.println("\nNajstarszy pracownik:");
        grupa1.oldestEmployee().ifPresent(Employee::printing);
        System.out.println("Najmłodszy pracownik:");
        grupa1.youngestEmployee().ifPresent(Employee::printing);
        
        // Średni wiek
        System.out.println("\nŚredni wiek: " + grupa1.getAverageAge());
        
        // Statystyki wieku
        System.out.println("\nStatystyki wieku:");
        System.out.println(grupa1.getAgeStatistics());
        
        // Filtrowanie po wynagrodzeniu
        System.out.println("\nPracownicy z pensją >= 6000:");
        grupa1.filterByMinSalary(6000).forEach(Employee::printing);
        
        System.out.println("\nPracownicy z pensją w zakresie 5000-7000:");
        grupa1.filterBySalaryRange(5000, 7000).forEach(Employee::printing);
        
        // Top earners
        System.out.println("\nTop 2 najlepiej zarabiających:");
        grupa1.getTopEarners(2).forEach(Employee::printing);
        
        // Filtrowanie po percentylu
        System.out.println("\nPracownicy w górnym 50% pensji:");
        grupa1.filterByPercentile(50).forEach(Employee::printing);
        
        // Grupowanie po wynagrodzeniu
        System.out.println("\nGrupowanie po wynagrodzeniu:");
        grupa1.groupBySalary().forEach((salary, list) -> {
            System.out.println("Pensja " + salary + ":");
            list.forEach(Employee::printing);
        });
        
        // Grupowanie po zakresie wynagrodzenia
        System.out.println("\nGrupowanie po zakresie wynagrodzenia (zakres 2000):");
        grupa1.groupBySalaryRange(2000).forEach((range, list) -> {
            System.out.println("Zakres " + range + ":");
            list.forEach(Employee::printing);
        });
        
        // Test ConditionAnalyzer
        System.out.println("\n=== Test ConditionAnalyzer ===");
        System.out.println("\nCzy są pracownicy OBECNI: " + 
            ConditionAnalyzer.hasCondition(grupa1.sortByName(), EmployeeCondition.OBECNY));
        System.out.println("Procent pracowników OBECNYCH: " + 
            ConditionAnalyzer.getConditionPercentage(grupa1.sortByName(), EmployeeCondition.OBECNY) + "%");
        
        // Test SalaryFilter
        System.out.println("\n=== Test SalaryFilter ===");
        System.out.println("\nPracownicy z pensją >= 6000 (używając SalaryFilter):");
        grupa1.sortByName().stream()
            .filter(SalaryFilter.minSalary(6000))
            .forEach(Employee::printing);
        
        System.out.println("\nPracownicy z pensją w zakresie 5500-6500 (używając SalaryFilter):");
        grupa1.sortByName().stream()
            .filter(SalaryFilter.salaryRange(5500, 6500))
            .forEach(Employee::printing);
    }
}