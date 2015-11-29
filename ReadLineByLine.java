package lecture11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*Open a local file, read the file line by line. 
 * Each line should be imported as a string and stored in ArrayList. 
 * Then print out the ArrayList reversely. You can create your own file to test.*/

public class ReadLineByLine {
	public static void main(String[] args) throws IOException {
		ReadLineByLine rlbl = new ReadLineByLine();
		ArrayList<String> list = rlbl.readlinebyline();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));	
	    }
	}

	ArrayList <String>  readlinebyline() throws IOException {
		File file = new File("/Users/makexuan/Documents/workspace/try/src/lecture11/abc");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader buffered = new BufferedReader(reader);
		ArrayList <String> store = new ArrayList<String>();
		while(true){
			String line=buffered.readLine();
			if(line!=null){
				store.add(line);
			}else{
				break;
			}
		}
		buffered.close();
		reader.close();
		fis.close();
		return store;
	}

}
