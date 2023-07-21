package com.example.projeto_final;

import com.example.projeto_final.controller.PersonController;
import com.example.projeto_final.model.Employee;
import com.example.projeto_final.model.ennumeration.EducationLevel;
import com.example.projeto_final.model.ennumeration.Job;
import com.example.projeto_final.model.ennumeration.MaritialStatus;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class addNewUsercontroller {
    public TextField CPF ;
    public TextField RG;
    public TextField nome;


    public TextField telefone;
    public DatePicker nascimento;
    public TextField Endereco;
    public ComboBox estadoCivil;
    public ComboBox escolaridade;
    public ComboBox cargo;
    public TextField carteiraTrabalho;
    public CheckBox ativo;

    public void adicionarNovoFuncionario(ActionEvent actionEvent) throws Exception {
        MaritialStatus tempEstadoCivil = null;
        EducationLevel tempEscolaridade = null;
        int tempCarteiraTrabalho = Integer.parseInt(carteiraTrabalho.getText());

        switch (estadoCivil.getSelectionModel().getSelectedItem().toString().toUpperCase()) {
            case "CASADO" -> tempEstadoCivil = MaritialStatus.MARRIED;
            case "SOLTEIRO" -> tempEstadoCivil = MaritialStatus.SINGLE;
            case "VIÚVO" -> tempEstadoCivil = MaritialStatus.WIDOWER;
        }

        switch (escolaridade.getSelectionModel().getSelectedItem().toString().toUpperCase()){
            case "ENSINO FUNDAMENTAL"-> tempEscolaridade = EducationLevel.ELEMENTARY;
            case "ENSINO MÉDIO"-> tempEscolaridade = EducationLevel.HIGHSCHOOL;
            case "ENSINO SUPERIOR"-> tempEscolaridade = EducationLevel.COLLEGE;
            case "PÓS GRADUAÇÃO"-> tempEscolaridade = EducationLevel.ESPECIALIZATION;
        }
        Employee employee = new Employee(nome.getText(),telefone.getText(), LocalDateTime.of(nascimento.getValue().getYear(), nascimento.getValue().getMonth(),nascimento.getValue().getDayOfMonth(),0,0),CPF.getText(),Endereco.getText(),RG.getText(),tempEstadoCivil,tempEscolaridade, Job.WAITER,tempCarteiraTrabalho,Date.from(Instant.now()), ativo.isSelected(), ativo.isSelected());
        PersonController.getInstance().save(employee);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
