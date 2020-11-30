/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.playerRegister;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Ismael
 */
public class InputView {

    private PlayerRegister playerRegister;

    public InputView(PlayerRegister playerRegister) {
        this.playerRegister = playerRegister;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Button remove = new Button("Eliminar");
        remove.setFont(Font.font("Arial", 19));
        remove.setMinSize(105, 40);
        Button create = new Button("Crear");
        create.setFont(Font.font("Arial", 19));
        create.setMinSize(105, 40);
        Button modify = new Button("Modificar");
        modify.setFont(Font.font("Arial", 19));
        modify.setMinSize(105, 40);


        Label name = new Label("Nombre: ");
        name.setFont(Font.font(15));
        Label lastName = new Label("Apellido: ");
        lastName.setFont(Font.font(15));
        Label id = new Label("Cédula: ");
        id.setFont(Font.font(15));
        Label nickname = new Label("Usuario: ");
        nickname.setFont(Font.font(15));

        TextField nameField = new TextField();
        nameField.setFont(Font.font(15));
        TextField lastNameField = new TextField();
        lastNameField.setFont(Font.font(15));
        TextField idField = new TextField();
        idField.setFont(Font.font(15));
        TextField nicknameField = new TextField();
        nicknameField.setFont(Font.font(15));

        ComboBox userIDs = new ComboBox();
        userIDs.setMinSize(255, 30);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);

        GridPane subLayout = new GridPane();
        subLayout.setVgap(5);
        subLayout.setHgap(5);
        subLayout.add(name, 0, 1);
        subLayout.add(nameField, 1, 1);
        subLayout.add(lastName, 0, 2);
        subLayout.add(lastNameField, 1, 2);
        subLayout.add(id, 0, 3);
        subLayout.add(idField, 1, 3);
        subLayout.add(nickname, 0, 4);
        subLayout.add(nicknameField, 1, 4);

        VBox subLayout1 = new VBox();
        subLayout1.setSpacing(9);
        subLayout1.getChildren().addAll(create, modify, remove);
        subLayout.add(subLayout1, 2, 1, 2, 4);

        TableView<PlayerInformation> information = new TableView<>();

        TableColumn gameIDColumn = new TableColumn("id:");
        gameIDColumn.setMinWidth(20);
        gameIDColumn.setMaxWidth(26);
        gameIDColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn nameColumn = new TableColumn("Nombre:");
        nameColumn.setMinWidth(78);
        nameColumn.setMaxWidth(85);
        nameColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn lastNameColumn = new TableColumn("Apellido:");
        lastNameColumn.setMinWidth(78);
        lastNameColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn idColumn = new TableColumn("Cédula:");
        idColumn.setMinWidth(90);
        idColumn.setMaxWidth(100);
        idColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn nicknameColumn = new TableColumn("Usuario:");
        nicknameColumn.setMinWidth(85);
        nicknameColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn victoriesColumn = new TableColumn("Victorias:");
        victoriesColumn.setMinWidth(49);
        victoriesColumn.setStyle("-fx-alignment: CENTER;");

        ObservableList<PlayerInformation> data = FXCollections.observableArrayList();
        information.setItems(data);

        lastNameColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("lastName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("name"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("nickName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("userID"));
        gameIDColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("gameID"));
        victoriesColumn.setCellValueFactory(new PropertyValueFactory<PlayerInformation, String>("victories"));

        information.getColumns().addAll(gameIDColumn, nameColumn,
                lastNameColumn, idColumn, nicknameColumn, victoriesColumn);

        layout.add(subLayout, 0, 1);
        layout.add(information, 0, 2);

        Label fieldComprobation = new Label("");
        fieldComprobation.setMinSize(50, 30);
        fieldComprobation.setFont(Font.font("Arial", 14));
        HBox fieldAndComboBox = new HBox();
        fieldAndComboBox.setSpacing(10);
        fieldAndComboBox.getChildren().addAll(userIDs, fieldComprobation);

        layout.add(fieldAndComboBox, 0, 0);

        Button clearFields = new Button("Limpiar");
        clearFields.setFont(Font.font("Arial", 14));
        clearFields.setMinSize(70, 35);

        BorderPane subButton = new BorderPane();
        subButton.setRight(clearFields);
        layout.add(subButton, 0, 3);

        createButton(create, this.playerRegister, nameField, lastNameField, idField, nicknameField, fieldComprobation, userIDs, data);
        modifyButton(modify, this.playerRegister, nameField, lastNameField, idField, nicknameField, fieldComprobation, data);
        removeButton(remove, this.playerRegister, nameField, lastNameField, idField, nicknameField, fieldComprobation, data, userIDs);
        userIDBox(userIDs, this.playerRegister, nameField, lastNameField, idField, nicknameField);
        readFile(userIDs, this.playerRegister, data);
        clearButton(clearFields, nameField, lastNameField, idField, nicknameField);

        return layout;
    }

    private void createButton(Button create, PlayerRegister playerRegister, TextField nameField,
                              TextField lastNameField, TextField idField, TextField nicknameField, Label fieldComprobation, ComboBox userIDs, ObservableList<PlayerInformation> data) {
        create.setOnAction((event) -> {
            if (nameField.getText().equals("") || lastNameField.getText().equals("") || idField.getText().equals("")
                    || nicknameField.getText().equals("")) {
                fieldComprobation.setText("Algún campo vacío");
            } else if (playerRegister.containsPlayer(idField.getText())) {
                fieldComprobation.setText("Cédula ya ingresada!");
            } else if (!IDValidation(idField.getText())) {
                fieldComprobation.setText("Cédula inválida");
            } else {
                PlayerInformation newPlayer = new PlayerInformation(nameField.getText(),
                        lastNameField.getText(), idField.getText(), nicknameField.getText());

                playerRegister.addPlayer(newPlayer.getUserID(), newPlayer);

                addInformationUserIDBox(userIDs, playerRegister);
                userIDs.setValue(newPlayer.getUserID());
                saveInformation(playerRegister);
                addInformationTable(data, playerRegister);

                clearFields(nameField, lastNameField, idField, nicknameField);
                fieldComprobation.setText("     Éxito!");
            }
        });
    }

    private void modifyButton(Button modify, PlayerRegister playerRegister, TextField nameField, TextField lastNameField,
                              TextField idField, TextField nicknameField, Label fieldComprobation, ObservableList<PlayerInformation> data) {
        modify.setOnAction((event) -> {
            PlayerInformation temp = playerRegister.getPlayer(idField.getText());
            if (!playerRegister.containsPlayer(idField.getText())) {
                fieldComprobation.setText("CI. aún no registrada");
            } else if (nameField.getText().equals(temp.getName()) && lastNameField.getText().equals(temp.getLastName())
                    && idField.getText().equals(temp.getUserID()) && nicknameField.getText().equals(temp.getNickName())) {
                fieldComprobation.setText("Sin cambios!");
                clearFields(nameField, lastNameField, idField, nicknameField);
            } else if (nameField.getText().equals("") || lastNameField.getText().equals("") || idField.getText().equals("")
                    || nicknameField.getText().equals("")) {
                fieldComprobation.setText("Algún campo vacío");
            } else if (playerRegister.containsPlayer(idField.getText())) {
                PlayerInformation aux = playerRegister.getPlayer(idField.getText());
                aux.setName(nameField.getText());
                aux.setLastName(lastNameField.getText());
                aux.setNickName(nicknameField.getText());
                playerRegister.replacePlayer(aux.getUserID(), aux);
                saveInformation(playerRegister);
                addInformationTable(data, playerRegister);

                clearFields(nameField, lastNameField, idField, nicknameField);
                fieldComprobation.setText("Datos actualizados!");
            }
        });
    }

    private void removeButton(Button remove, PlayerRegister playerRegister, TextField nameField,
                              TextField lastNameField, TextField idField, TextField nicknameField,
                              Label fieldComprobation, ObservableList<PlayerInformation> data, ComboBox userIDs) {
        remove.setOnAction((event) -> {
            if (!playerRegister.containsPlayer(idField.getText())) {
                fieldComprobation.setText("CI. no encontrada");
            } else {
                PlayerInformation auxPlayer = playerRegister.getPlayer(idField.getText());

                for (String index : playerRegister.getAllUserIDs()) {
                    if (playerRegister.getPlayer(index).getGameID() > auxPlayer.getGameID()) {
                        int auxID = playerRegister.getPlayer(index).getGameID() - 1;
                        playerRegister.getPlayer(index).setGameID(auxID);
                    }
                }
                playerRegister.removePlayer(idField.getText());
                addInformationUserIDBox(userIDs, playerRegister);
                saveInformation(playerRegister);
                addInformationTable(data, playerRegister);
                clearFields(nameField, lastNameField, idField, nicknameField);
                fieldComprobation.setText("Jugador eliminado!");
            }
        });

    }

    private void userIDBox(ComboBox userIDs, PlayerRegister playerRegister, TextField nameField,
                           TextField lastNameField, TextField idField, TextField nicknameField) {
        userIDs.setOnAction((event) -> {
            if (!userIDs.getItems().isEmpty()) {
                nameField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getName());
                lastNameField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getLastName());
                idField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getUserID());
                nicknameField.setText(playerRegister.getPlayer(userIDs.getValue().toString()).getNickName());
            }
        });
    }

    private void saveInformation(PlayerRegister playerRegister) {
        PrintWriter newWriter;
        try {
            newWriter = new PrintWriter("playerRegister.csv");
            for (String index : playerRegister.getAllUserIDs()) {
                newWriter.println(playerRegister.getPlayer(index).toString());
            }
            newWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        };
    }

    private void readFile(ComboBox userIDs, PlayerRegister playerRegister, ObservableList<PlayerInformation> data) {
        try {
            Files.lines(Paths.get("playerRegister.csv"))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 6)
                    .map(part -> new PlayerInformation(Integer.valueOf(part[0]), part[1], part[2], part[3], part[4], Integer.valueOf(part[5].trim())))
                    .forEach(player -> playerRegister.addPlayerFromFile(player.getUserID(), player));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        addInformationUserIDBox(userIDs, playerRegister);
        addInformationTable(data, playerRegister);
    }

    private void addInformationTable(ObservableList<PlayerInformation> data, PlayerRegister playerRegister) {
        data.removeAll(data);
        for (String index : playerRegister.getAllUserIDs()) {
            data.add(playerRegister.getPlayer(index));
        }
    }

    private void addInformationUserIDBox(ComboBox userIDs, PlayerRegister playerRegister) {
        userIDs.getItems().clear();
        userIDs.getItems().addAll(playerRegister.getAllUserIDs());
    }

    private void clearFields(TextField nameField, TextField lastNameField,
                             TextField idField, TextField nicknameField) {
        nameField.clear();
        lastNameField.clear();
        nicknameField.clear();
        idField.clear();
    }

    private void clearButton(Button clearFields, TextField nameField, TextField lastNameField,
                             TextField idField, TextField nicknameField) {
        clearFields.setOnAction((event) -> {
            clearFields(nameField, lastNameField, idField, nicknameField);
        });
    }

    private boolean IDValidation(String userID) {
        return userID.matches("^[0-9]{10}$");
    }

}
