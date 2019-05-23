public class Lab2 {
    public static void main(String[] args) {
        IniParser iniParser = new IniParser();
        try {
            iniParser.Parse("com/artem48/test.ini");
            System.out.println(iniParser.getAsDouble("ADC_DEV", "BufferLenSeconds"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
