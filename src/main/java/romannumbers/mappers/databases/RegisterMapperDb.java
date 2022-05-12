package romannumbers.mappers.databases;

public class RegisterMapperDb {
   private String idMappers;
   private String mappersNum;
   private String mappersNumType;
   private String mappersNumValue;

    public RegisterMapperDb(String idMappers,
                            String mappersNum,
                            String mappersNumType,
                            String mappersNumValue) {
        this.idMappers = idMappers;
        this.mappersNum = mappersNum;
        this.mappersNumType = mappersNumType;
        this.mappersNumValue = mappersNumValue;
    }

    protected void thePathToTheFile(String path) throws Exception {

    }

    public String getIdMappers() {
        return idMappers;
    }

    public String getMappersNum() {
        return mappersNum;
    }

    public String getMappersNumType() {
        return mappersNumType;
    }

    public String getMappersNumValue() {
        return mappersNumValue;
    }
}
