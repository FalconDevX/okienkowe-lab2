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
    }
}