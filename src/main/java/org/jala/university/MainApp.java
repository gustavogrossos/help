package org.jala.university;

import org.jala.university.application.dao.ClienteDAO;
import org.jala.university.application.model.Cliente;
import org.jala.university.presentation.MainView;

public class MainApp {
    public static void main(String[] args) {
        MainView.launch(args);
    }{
    Cliente cliente = new Cliente("xxxxxxxxxxx", "Teste", "teste@email.com");
    ClienteDAO dao = new ClienteDAO();
    dao.salvar(cliente);
    }
}
