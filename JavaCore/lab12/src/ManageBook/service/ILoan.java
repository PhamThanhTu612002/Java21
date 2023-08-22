package ManageBook.service;

import ManageBook.entities.Loan;

import java.util.ArrayList;

public interface ILoan {
    ArrayList<Loan> createLoan(ArrayList<Loan> loans);
    ArrayList<Loan> giveLoan(ArrayList<Loan> loans);
}
