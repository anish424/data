package no.kantega.springandreact;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class SampleController {

	@Autowired
	DataSource dataSource;

	@Autowired
	CustomerRepository customerRepository;

	private static Logger log = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile upgradeFile) throws IOException, ParseException {
		log.info("Obtained a upload request for the id {} " + upgradeFile.getName());
		log.info("Obtained a upload request for the id {} " + upgradeFile.getContentType());
		log.info("Obtained a upload request for the id {} " + upgradeFile.getSize());
		log.info("Obtained a upload request for the id {} " + upgradeFile.getInputStream());
		log.info("Obtained a upload request for the id {} " + upgradeFile.getBytes());

		ArrayList<STG_CCAR_STATISTICS> data = Util.read(upgradeFile.getInputStream());
		addtoDatabase(data);
		System.out.println("***********************************************************");

		/*
		 * BufferedReader reader = new BufferedReader(new
		 * InputStreamReader(upgradeFile.getInputStream())); StringBuilder out =
		 * new StringBuilder(); String line; while ((line = reader.readLine())
		 * != null) { out.append(line); } System.out.println(out.toString());
		 * //Prints the string content read from input stream reader.close();
		 */

		return new ResponseEntity<String>("file upload has been accepted.", HttpStatus.ACCEPTED);
	}

	public void addtoDatabase(ArrayList<STG_CCAR_STATISTICS> data) {
		for (int i =1;i<data.size();i++)
			customerRepository.save(data.get(i));
	}

}