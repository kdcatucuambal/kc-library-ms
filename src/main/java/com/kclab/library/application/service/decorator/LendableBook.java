package com.kclab.library.application.service.decorator;

import com.kclab.library.domain.model.Book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LendableBook extends BookDecorator {
    private String borrowerName;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean isLoaned;

    public LendableBook(BookOperations bookOperations) {
        super(bookOperations);
        this.isLoaned = false;
    }

    public boolean lendBook(String borrowerName, int loanDurationDays) {
        if (isLoaned) {
            System.out.println("El libro ya está prestado a: " + this.borrowerName);
            return false;
        }

        if (!"AVAILABLE".equalsIgnoreCase(getStatus())) {
            System.out.println("El libro no está disponible para préstamo. Estado: " + getStatus());
            return false;
        }

        this.borrowerName = borrowerName;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(loanDurationDays);
        this.isLoaned = true;
        setStatus("LOANED");

        System.out.println("Libro prestado exitosamente a: " + borrowerName);
        return true;
    }

    public boolean returnBook() {
        if (!isLoaned) {
            System.out.println("El libro no está prestado actualmente");
            return false;
        }

        System.out.println("Libro devuelto por: " + borrowerName);
        this.borrowerName = null;
        this.loanDate = null;
        this.dueDate = null;
        this.isLoaned = false;
        setStatus("AVAILABLE");
        return true;
    }

    public boolean isOverdue() {
        return isLoaned && LocalDate.now().isAfter(dueDate);
    }

    public String getLoanInfo() {
        if (!isLoaned) {
            return "Libro no prestado";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String overdueStatus = isOverdue() ? " [VENCIDO]" : "";

        return String.format("Prestado a: %s | Fecha préstamo: %s | Fecha límite: %s%s",
                borrowerName,
                loanDate.format(formatter),
                dueDate.format(formatter),
                overdueStatus);
    }

    @Override
    public String getBookInfo() {
        return super.getBookInfo() + "\n  Préstamo: " + getLoanInfo();
    }

    @Override
    public Book getBook() {
        return null;
    }

    // Getters adicionales
    public String getBorrowerName() { return borrowerName; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isLoaned() { return isLoaned; }
}