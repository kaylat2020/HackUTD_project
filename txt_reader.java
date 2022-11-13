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
	private Pattern[] patterns;
	//regex pattern matchers
	private Matcher h1, h2, h3, b, i, bq, ol, ul, c, hrule, lnk, img;

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

		heading_1 = Pattern.compile( "^(#)\s{1}(\w)+" );
		heading_2 = Pattern.compile( "^(##)\s{1}(\w)+" );
		heading_3 = Pattern.compile( "^(###)\s{1}(\w)+" );
		bold Pattern.compile( "^(\*\*){1}(.*)(\*\*)${1}" );
		italic = Pattern.compile( "(\*){1}(.*)(\*)${1}" );
		blockquote = Pattern.compile( "^>\s{1}.*" );
		ordered_list = Pattern.compile( "(-\s{1}.*\n)+" );
		unordered_list = Pattern.compile( "(\d\.)\s{1}" );
		code = Pattern.compile( "`(.*)`" );
		horizontal_rule = Pattern.compile( "(---){1}" );
		link = Pattern.compile( "\[\w\]\(^https?:\/\/.*\)" ); 
		image = Pattern.compile( "!\[[\w\s]\]\(\w(.jpg)$" );

		//throw compiled patterns into array (useful for later)
		patterns = new Pattern[] {heading_1, heading_2, heading_3, bold, italic, 
			blockquote, ordered_list, unordered_list, code, horizontal_rule, link, image}
		/*
		patterns[0] = heading_1;
		patterns[1] = heading_2;
		patterns[2] = heading_3;
		patterns[3] = bold;
		patterns[4] = italic;
		patterns[5] = blockquote;
		patterns[6] = ordered_list;
		patterns[7] = unordered_list;
		patterns[8] = code;
		patterns[9] = horizontal_rule;
		patterns[10] = link;
		patterns[11] = image;
		*/
	}

	/**
	 * Method to scan .txt file w/ markdown -> construct .html file
	 */
	public static File converter( Scanner scan )
	{
		
		for ( int i = 0; scan.hasNext(); i++ )
		{
			String currentln = scan.nextLine();
			StringBuilder chunk = new StringBuilder();

			//loop through list of patterns, search for match
			for ( Pattern p : patterns )
			{
				Matcher m = p.matches( currentln );
				if ( m.matches() )
				{

				}
			}
		}
	}
}