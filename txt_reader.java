import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.StringBuilder;

/**
 * @author Kayla Tucker
 * @version 1.0
 */
public class TextParser
{
	//regex patterns that match markdowns
	private Pattern h1, h2, h3, bold, italic, bq, ol, ul, code, hrule, link, image;


	public static void main( String[] args )
	{
		initialize();

		try
		{
			//TODO change file location later
			File f = new File( "./src/Map.txt" ); 
			scan = new Scanner( f );

			File html = converter( scan );
		}
		catch ( Exception e )
		{
			System.out.print( e );
		}
		finally
		{
			if ( scan != null )
			{
				scan.close();
			}
		}
	}

	public static void initialize()
	{
		h1 = Pattern.compile( "#.*" );
		h2 = Pattern.compile( "##.*" );
		h3 = Pattern.compile( "###.*" );
		bold Pattern.compile( "**.***" );
		italic = Pattern.compile( "*.**" );
		bq = Pattern.compile( ">.*" );
		ol = Pattern.compile( "(-.*\n)+" );
		ul = Pattern.compile( "(\\d\\.)" );
		code = Pattern.compile( "`.*`" );
		hrule = Pattern.compile( "---" );
		link = Pattern.compile( "\[\w\]\(^https?:\/\/.*\)");
			//this will definitely need checking later
		image = Pattern.compile( "!\[[\w\s]\]\(\w(.jpg)$" );
	}

	public static File converter( Scanner scan )
	{
		
	}
}