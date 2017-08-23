package vn.myclass.core.common.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class UploadUtil {
    private final int maxMemorySize = 1024 * 1024 * 3;
    private final int maxRequestSize = 1024 * 1024 * 50;
    public void writeOrUpdateFile(HttpServletRequest request ) throws FileUploadException,Exception {
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            System.out.println("have not enctype");
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

// Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

// Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

// Set overall request size constraint
        upload.setSizeMax(maxRequestSize);

// Parse the request
        try{
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item: items){
                if(!item.isFormField()){
                    String fileName = item.getName();
                    File uploadedFile = new File("D:\\Myclass\\Git\\UploadFile"+fileName);
                    try{
                        boolean isExist = uploadedFile.exists();
                        if(isExist){
                            uploadedFile.delete();
                            File uploadedFile1 = new File("D:\\Myclass\\Git\\UploadFile"+fileName);
                            item.write(uploadedFile1);
                        } else {
                            item.write(uploadedFile);
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }catch(FileUploadException e){
            e.printStackTrace();
        }
    }
}
