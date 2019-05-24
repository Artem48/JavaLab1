import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IniData {
    private Map<String, Map<String, String>> data;

    public IniData(){
        data = new HashMap<>();
    }

    public String getAsString(String section, String key) throws EntryNotFoundException {
        Map<String, String> sectionData = data.get(section);
        if (sectionData == null) {
            throw new EntryNotFoundException("Section not found");
        }
        String value = sectionData.get(key);
        if (value == null) {
            throw new EntryNotFoundException("Key not found");
        }
        return value;
    }

    public int getAsInteger(String section, String key) throws EntryNotFoundException {
        return Integer.parseInt(getAsString(section, key));
    }

    public double getAsDouble(String section, String key) throws EntryNotFoundException {
        return Double.parseDouble(getAsString(section, key));
    }

    public void add(IniData temp){
        data.putAll(temp.data);
    }

    public static IniData Parse(String fileName) throws FileNotFoundException, BadFileFormatException {
        IniData temp=new IniData();
        Scanner scanner = null;
        if (!fileName.substring(fileName.length() - 4).equals(".ini")) {
            try {
                throw new BadExtensionException();
            } catch (BadExtensionException e) {
                e.printStackTrace();
            }
        }
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String section = null;
        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine().replaceFirst("\\s*;.*", "");
            if (line.length() == 0)
                continue;
            if (line.matches("\\[\\w+]")) {
                section = line.substring(1, line.length() - 1);
            } else if (line.matches("\\w+\\s*=\\s*[\\w./]+")) {
                if (section == null)
                    throw new BadFileFormatException();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\\s*=\\s*");
                String key = lineScanner.next();
                String value = lineScanner.next();
                temp.data.computeIfAbsent(section, k -> new HashMap<String, String>());
                temp.data.get(section).put(key, value);
            } else
                throw new BadFileFormatException();
        }
        return temp;
    }
}
