package manager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.log4j.Logger;
public class Manager {
private static final Logger logger = Logger.getLogger(Manager.class.getName());
	public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException, SQLException {
		int total=0;
		int insuccess =0;
		SqLiteConect sql =new SqLiteConect();
		BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
	   BufferedReader buf = new BufferedReader(new FileReader(new File(args[0])));
		String st;
		 while((st =buf.readLine()) != null) {
			 total++;
			String[] arry = st.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			if(arry.length<10) {
				writer.write(st+"\n");
				insuccess++;		
			}else {
				sql.insert(arry);
			}
		 }
		 writer.close();
		 buf.close();
		 logger.info(total + " of records received");
		 logger.info((total-insuccess) + " of records successful");
		 logger.info(insuccess + " of records failed");
		 
	}

}
