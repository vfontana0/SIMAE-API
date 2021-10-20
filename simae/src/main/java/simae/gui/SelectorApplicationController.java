package simae.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import simae.lib.Simae;

import java.io.File;
import java.util.List;


public class SelectorApplicationController {

    private List<File> archivos = null;

    @FXML
    private ComboBox seleccionLenguajes;

    @FXML
    private ListView<?> listaDeArchivos;

    @FXML
    private Button botonMarcar;

    @FXML
    private Button botonQuitar;

    @FXML
    private Button botonQuitarSeleccion;

    @FXML
    private Button botonDesmarcar;

    @FXML
    private void initialize() {
        seleccionLenguajes.getItems().addAll("C++", "Java", "Python");
    }

    private ObservableList l = FXCollections.observableArrayList();

    private FileChooser fc = new FileChooser();

    @FXML
    void multiFileChooser() {
        archivos = fc.showOpenMultipleDialog(null);
        if(archivos != null) {
            archivos.forEach(file -> l.add(file.getName()));
            listaDeArchivos.setItems(l);
            habilitarMarcado();
        }
    }

    @FXML
    void marcaArchivos() {
        Simae simae = new Simae();
        archivos.parallelStream().forEach(file -> simae.marcaDesmarcaPorArchivos(file, file.toString(), seleccionLenguajes.getValue().toString(), 'M'));
    }

    @FXML
    void desMarcaArchivos() {
        Simae simae = new Simae();
        System.out.println("pasando: " + seleccionLenguajes.getValue().toString());
        archivos.parallelStream().forEach(file -> simae.marcaDesmarcaPorArchivos(file, file.toString(), seleccionLenguajes.getValue().toString(), 'D'));
    }

    @FXML
    void filtraObjeto() {
        if(fc.getExtensionFilters().size() != 0) fc.getExtensionFilters().remove(0);
        switch(seleccionLenguajes.getSelectionModel().getSelectedItem().toString()) {
            case "C++":
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("C++ (.cpp)", "*.cpp"));
                break;
            case "Java":
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Java (.java)", "*.java"));
                break;
            case "Python":
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Python (.py)", "*.py"));
        }
    }

    @FXML
    void eliminarTodos() {
        l.removeAll(l);
    }

    @FXML
    void eliminarArchivoSeleccionado() {
        l.removeAll(listaDeArchivos.getSelectionModel().getSelectedItems());
        detectaHabilitaQuitado();
    }

    @FXML
    void detectaHabilitaQuitado() {
        botonQuitarSeleccion.setDisable(listaDeArchivos.getSelectionModel().getSelectedItems().size() == 0);
    }

    private void habilitarMarcado() {
        botonMarcar.setDisable(false);
        botonQuitar.setDisable(false);
        botonDesmarcar.setDisable(false);
    }

}
