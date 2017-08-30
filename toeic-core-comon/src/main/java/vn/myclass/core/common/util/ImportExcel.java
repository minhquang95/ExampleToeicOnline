package vn.myclass.core.common.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import vn.myclass.core.dto.UserDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportExcel {

    public Object[] ImportExcel() {
        String kt = "";
        FileInputStream fis;
        POIFSFileSystem poif ;
        UserDTO userDTO = new UserDTO();
        try
        {
            fis = new FileInputStream("D:/Book1.xls");
            poif = new POIFSFileSystem(fis);
            HSSFWorkbook wb = new HSSFWorkbook(poif);

            HSSFSheet sheet = wb.getSheetAt(0);

            for(int i = 1 ; i<=sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);

                //int stt = (int) row.getCell(0).getNumericCellValue();

                userDTO.setName(row.getCell(0).getStringCellValue());




            }
            wb.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new Object[]{userDTO};
    }
}
