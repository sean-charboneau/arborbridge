import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDSearch
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				IDSearch.class.getClassLoader().getResourceAsStream("data.txt")));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        
	        Matcher m = Pattern.compile("[A-Y][0-9A-F]{3}-[\\d]*Z").matcher(line);
	        while (m.find()) {
	          System.out.println(m.group());
	        }
	    } catch (IOException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        } finally {
	        br.close();
	    }
	}
}