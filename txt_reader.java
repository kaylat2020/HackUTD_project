import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.text.html.HTMLDocument;

//HTMLDocument API:
//https://docs.oracle.com/javase/8/docs/api/javax/swing/text/html/HTMLDocument.html

//Pattern API + Regex:
//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

/**
 * @author Kayla Tucker,
 * @version 1.0
 */
public class TextParser
{
	//regex patterns that match markdowns
	private final Pattern emptyLn = Pattern.compile( "(\t|\n|\s)+" );
	private Pattern heading_1, heading_2, heading_3, bold, italic, blockquote, 
		ordered_list, unordered_list, code, horizontal_rule, link, image;
	private Pattern[] patterns;
	//tags UPDATE: WELL SHIT THEY MIGHT NOT BE NEEDED AFTER THE HTMLDOC IMPORT
	//private String[] = new String[] { "h1","h2","h3","b","i","blockquote","ol","ul","code","hr","a","img" };

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
		//btw this cheat sheet is ur reference, only basic syntax for now:
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
		horizontal_rule = Pattern.compile( "(---|***|___){1}" );
		link = Pattern.compile( "\[\w\]\(^https?:\/\/.*\)" ); 
		image = Pattern.compile( "!\[[\w\s]\]\(\w(.jpg)$" );

		//throw compiled patterns into array (useful for later)
		patterns = new Pattern[] { heading_1, heading_2, heading_3, bold, italic, 
			blockquote, ordered_list, unordered_list, code, horizontal_rule, link, image };

		//HTMLdocument stuff to make empty html file
		JEditorPane p = new JEditorPane();
		p.setContentType("text/html");
		p.setText("..."); // Document text is provided below.
		HTMLDocument d = (HTMLDocument) p.getDocument();

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
		//loop through document, scan line-by-line
		while ( scan.hasNext() )
		{
			String currentln = scan.nextLine();

			//loop through list of patterns, search for match
			for ( int i = 0; i < patterns.length : patterns )
			{
				//ignore empty lines (stop trying to pattern match the line)
				Matcher empty = emptyLn.matches( currentln );
				if ( empty )
				{
					return;
				}
				//check current pattern in list for match
				Matcher m = p.matches( currentln );
				if ( m.matches() )
				{
					//TODO GENERATE THE HTML DOCUMENT 4HEAD
				}
			}
		}
	}
}