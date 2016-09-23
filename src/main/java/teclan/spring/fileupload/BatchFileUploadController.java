package teclan.spring.fileupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BatchFileUploadController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BatchFileUploadController.class);

    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");

        for (int i = 0; i < files.size(); ++i) {
            MultipartFile file = files.get(i);

            String name = "upload" + File.separator
                    + file.getOriginalFilename();

            new File("upload").mkdirs();

            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(new File(name)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    return "You failed to upload " + name + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + name
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download() throws IOException {
        HttpHeaders headers = new HttpHeaders();

        String path = "/home/dev/1xxx.odt";
        File file = new File(path);

        if (!file.exists()) {
            LOGGER.error("File is not exist : {}", file.getAbsolutePath());
            return null;
        }

        headers.setContentDispositionFormData("attachment", file.getName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
