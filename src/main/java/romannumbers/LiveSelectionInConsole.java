package romannumbers;

import romannumbers.db.MappersDAO;
import romannumbers.mappers.MapperType;

public class LiveSelectionInConsole {

    public void selectionInConsole(int number,
                                   String string,
                                   OutputNumerals outputNumerals,
                                   MappersDAO mappersDAO,
                                   MapperType mapperType) {
        if (string.equals("inMemory") || string.equals("file")) {
            outputNumerals.output(number, mapperType);
        } else {
            mappersDAO.returnResult(mapperType, string, number);
        }
    }
}
