package no.uib.info233.v2016.puz001.esj002.Oblig2.FileHandling;
import java.io.*;

/**
 * This class creates and object file and saves it to the system
 * to resume from the same place later.
 * 
 * @author Marius Lillevik
 * @version version 5.1
 */
public class SaveProgram implements Serializable{
    
	//Fields of the SaveProgram class
	private static final long serialVersionUID = 8002287752953013587L;
	public static final String filename = "IssueTracker.obj";
    public static final String root = "IssueTable";
    
    
    /**
    * Method for saving the program into a folder (C:\Users\[user]\AppData\Roaming (Windows))"
    * It also works for the other OSs.
    */
    public static void save(Serializable objectToSerialise) {
            FileOutputStream fos = null;
            try{
                fos = new FileOutputStream(createDataFolder() + filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(objectToSerialise);
                oos.flush();
                oos.close();
                System.out.println("Saving: " + objectToSerialise);
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to save: " + objectToSerialise);
            }
        }
        
    
    /**
     * Load the last saved program file into the program.
     */
    public static IssueTable load(){ 
            if(checkFileExists()){
                FileInputStream fis = null;
                IssueTable loadedObject = null;
                
                try {
                    fis = new FileInputStream(createDataFolder() + filename);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    loadedObject = (IssueTable) ois.readObject();
                    ois.close();
                    System.out.println("Loaded: " + (loadedObject));
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("Failed: Could not load object from file.");
                    e.printStackTrace();                    
                }  
                return loadedObject;                
            }
            return null; 
        }
    
    /**
     * Checks if the file allready exists.     
     * @return boolean
     */
    public static boolean checkFileExists() {
        return new File(createDataFolder() + filename).isFile();
    }
    
    /**
     * Creates a new folder containing the saved objects. 
     * This folder is created differently depending on the current operating system.
     */
    public static String createDataFolder(){
        String home = System.getProperty("user.home");
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(home);
        if(os.contains("win")){
            home = System.getenv("appdata");
        }else if(os.contains("mac")){
            home += ("/Library/Application Support");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")){
            home += ("~/.");
        }
        File dir = new File(home);
        dir = new File(dir, root);
        if(!dir.exists()){
            dir.mkdir();
            System.out.println("Creating Directory!");
        }
        return dir.getAbsolutePath();
    }
    
    /**
     * Deletes a saved file. (Not currently implemented into the gui)
     */
    public static boolean deleteSaveFile(){
        if(!checkFileExists()){
            System.err.println("File: " + createDataFolder() + filename + "does not exist!");
            return new File(createDataFolder()).delete();
        }
        
        File toDelete = new File(createDataFolder() + filename);
        
        if(toDelete.canWrite()) {
            return toDelete.delete();
        }
        System.err.println("File " + createDataFolder() + filename + " is write protected.");
        return false;
    }
}
