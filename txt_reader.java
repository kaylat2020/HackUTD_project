import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.StringBuilder;

/**
 * @author Kayla Tucker,
 * @version 1.0
 */
public class TextParser
{
	//regex patterns that match markdowns
	private Pattern heading_1, heading_2, heading_3, bold, italic, blockquote, 
		ordered_list, unordered_list, code, horizontal_rule, link, image;
	//html segments for file construction
	private StringBuilder h1, h2, h3, b, i, bq, ol, ul, c, hrule, lnk, img;

	public static void main( String[] args )
	{
		//self-explanatory for local variables
		initialize();

		try
		{
			//TODO change file location later idk where the dragndrop is
			File f = new File( "./src/Map.txt" ); 
			scan = new Scanner( f );

			//grab the new html file returned from the coversion
			File html = converter( scan );
		}
		catch ( Exception e )
		{
			//scanning is dangerous ok im scawred
			System.out.print( e );
		}
		finally
		{
			//scanner no more scanning
			if ( scan != null )
			{
				scan.close();
			}
		}
	}

	/**
	 * Pattern matching for markdowns in .txt document
	 * WARNING: \ to escape requires another \ in a java string 
	 * parser, but I'll add them later to avoid confusing myself
	 */
	public static void initialize()
	{
		//these can definitely be improved
		//btw this cheat sheet is ur reference:
		//https://www.markdownguide.org/cheat-sheet/

		heading_1 = Pattern.compile( "^(#)\s(\w)+" );
		heading_2 = Pattern.compile( "^(##)\s(\w)+" );
		heading_3 = Pattern.compile( "^(###)\s(\w)+" );
		bold Pattern.compile( "\*\*(.*)\*\*" );
		italic = Pattern.compile( "\*(.*)\*" );
		blockquote = Pattern.compile( "^>\s.*" );
		ordered_list = Pattern.compile( "(-.*\n)+" );
		unordered_list = Pattern.compile( "(\d\.)" );
		code = Pattern.compile( "`(.*)`" );
		horizontal_rule = Pattern.compile( "---" );
		link = Pattern.compile( "\[\w\]\(^https?:\/\/.*\)" ); 
		image = Pattern.compile( "!\[[\w\s]\]\(\w(.jpg)$" );
	}

	/**
	 * Method to scan .txt file w/ markdown -> construct .html file
	 */
	public static File converter( Scanner scan )
	{
		
	}
}