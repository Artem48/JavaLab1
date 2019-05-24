public class Lab2 {
    public static void main(String[] args) {
        IniData iniData = new IniData();
        try {
            iniData.add(IniData.Parse("com/artem48/test.ini"));
            System.out.println("COMMON/StatisterTimeMs="+iniData.getAsInteger("COMMON", "StatisterTimeMs"));
            System.out.println("COMMON/LogNCMD="+iniData.getAsInteger("COMMON", "LogNCMD"));
            System.out.println("COMMON/DiskCachePath="+iniData.getAsString("COMMON", "DiskCachePath"));
            System.out.println("ADC_DEV/BufferLenSeconds="+iniData.getAsDouble("ADC_DEV", "BufferLenSeconds"));
            System.out.println("ADC_DEV/SampleRate="+iniData.getAsDouble("ADC_DEV", "SampleRate"));
            System.out.println("ADC_DEV/Driver="+iniData.getAsString("ADC_DEV", "Driver"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
