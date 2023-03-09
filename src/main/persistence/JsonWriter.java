package persistence;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Writer that writes budget information to a file in JSON.
public class JsonWriter {

    private String destination;
    private PrintWriter writer;

    //EFFECTS: constructs writer to write to given destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    //MODIFIES: this
    //EFFECTS: opens writer. Throws FileNotFoundException
    // if destination file cannot be opened
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(destination);
    }

    //MODIFIES: this
    //EFFECTS: writes JSON version of budgeting app to file
    public void write(){}
}
