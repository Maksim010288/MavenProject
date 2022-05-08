package romannumbers.mappers;

public enum MapperType {
    ROM("", false),
    UA(" ", true),
    EN(" ", true);

    private String delimiter;
    private boolean useTeen;

    MapperType(String delimiter, boolean useTeen) {
        this.delimiter = delimiter;
        this.useTeen = useTeen;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean isUseTeen() {
        return useTeen;
    }
}
